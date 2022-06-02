package com.example.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "qty")
    private int qty;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "nama")
    private String nama;

    @Column(name = "harga")
    private int harga;

    public Cart(long id, int qty, String goodsId, String nama, int harga) {
        this.id = id;
        this.qty = qty;
        this.goodsId = goodsId;
        this.nama = nama;
        this.harga = harga;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
