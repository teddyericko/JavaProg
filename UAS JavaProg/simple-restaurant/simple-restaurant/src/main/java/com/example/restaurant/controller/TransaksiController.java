package com.example.restaurant.controller;

import com.example.restaurant.entity.Cart;
import com.example.restaurant.entity.Goods;
import com.example.restaurant.entity.TotalDTO;
import com.example.restaurant.entity.Transaksi;
import com.example.restaurant.repository.CartRepository;
import com.example.restaurant.repository.GoodsRepository;
import com.example.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/transaksi/")
public class TransaksiController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("order")
    public String orderForm(Model model){
        model.addAttribute("goods", goodsRepository.findAllByCategory("makanan"));
        return "transaction";
    }

    @GetMapping("makanan")
    public String menuMakanan(Model model){
        model.addAttribute("goods", goodsRepository.findAll());
        return "menuMakanan";
    }
    @GetMapping("minuman")
    public String menuMinuman(Model model){
        model.addAttribute("goods", goodsRepository.findAllByCategory("minuman"));
        return "menuMakanan";
    }
    @PostMapping("order")
    public String order(@PathVariable("id") int id, @Valid Transaksi transaksi, List<Goods> goods
            , BindingResult result, Model model){

        System.out.println(id);
        return "transaction";
    }

    @GetMapping("cart/{id}")
    public String addToCart(@PathVariable("id") int id, Model model){
        model.addAttribute("goods", goodsRepository.findAll());
        Goods goods = this.goodsRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Goods id : " + id));

        Cart cart = new Cart();
        cart.setGoodsId(String.valueOf(id));
        int qty =1;
        if(cartRepository.findByGoodsId(String.valueOf(id)) != null){
            qty += cartRepository.findByGoodsId(String.valueOf(id)).getQty();
            cartRepository.deleteAllByGoodsId(String.valueOf(id));
        }
        cart.setQty(qty);
        cart.setHarga(goods.getHarga());
        cart.setNama(goods.getName());
        cartRepository.save(cart);
        return "menuMakanan";
    }

    @GetMapping("cart")
    public String cart(Model model){
        model.addAttribute("cart", cartRepository.findAll());
        return "carts";
    }

    @GetMapping("total")
    public String total(){
        cartRepository.deleteAll();
        return "menuMakanan";
    }
    @GetMapping("finish")
    public String finish(){
        userRepository.deleteAll();
        cartRepository.deleteAll();
        return "thanks";
    }
    @GetMapping("total-page")
    public String goTotal(Model model){
        TotalDTO totalDTO = new TotalDTO();
        totalDTO.setCarts( cartRepository.findAll());
        int harga =0;
        for(Cart cart : totalDTO.getCarts()){
            harga+= (cart.getHarga() * cart.getQty());
        }
        totalDTO.setHarga(harga);
        totalDTO.setNama("test");
        model.addAttribute("total", totalDTO);
        return "totals";
    }

}
