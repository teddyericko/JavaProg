package com.example.restaurant.entity;

import java.util.List;

public class TotalDTO {

    private String nama;
    private List<Cart> carts;
    private int harga;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public TotalDTO() {
    }

    public TotalDTO(String nama, List<Cart> carts, int harga) {
        this.nama = nama;
        this.carts = carts;
        this.harga = harga;
    }
}
