package com.freimanvs.shops.eshop.entities;

import com.freimanvs.shops.eshop.entities.interfaces.Idable;
import io.swagger.annotations.ApiParam;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "goods", schema = "eshop")
public class Goods implements Idable, Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ApiParam(value = "name")
    @NotBlank
    @Size(min = 4, max = 50)
    @Column(name="name")
    private String name;

    @ApiParam(value = "price")
    @Column(name="price")
    private double price;

    @ApiParam(value = "img")
    @Column(name="img")
    private String img;

    @JsonbTransient
    @ManyToMany(mappedBy = "goods")
    private List<Order> orders = new ArrayList<>();

    public Goods() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id == goods.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img=" + img +
                '}';
    }
}
