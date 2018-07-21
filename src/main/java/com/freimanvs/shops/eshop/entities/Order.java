package com.freimanvs.shops.eshop.entities;


import com.freimanvs.shops.eshop.entities.interfaces.Idable;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order", schema = "eshop")
public class Order implements Idable, Serializable {

    @ApiParam(value = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ApiParam(value = "goods")
    @ManyToMany
    @JoinTable(name = "order_goods", joinColumns = {
            @JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "goods_id")})
    private List<Goods> goods = new ArrayList<>();

    @ApiParam(value = "user")
    @OneToOne()
    @JoinColumn(name="user_id")
    private User user;

    @ApiParam(value = "name")
    @NotBlank
    @Column(name="name")
    private String name;

    @ApiParam(value = "phoneNumber")
    @NotBlank
    @Column(name="phoneNumber")
    private String phoneNumber;

    @ApiParam(value = "street")
    @NotBlank
    @Column(name="street")
    private String street;

    @ApiParam(value = "houseNumber")
    @NotBlank
    @Column(name="houseNumber")
    private String houseNumber;

    @ApiParam(value = "apartment")
    @NotBlank
    @Column(name="apartment")
    private String apartment;

    @ApiParam(value = "floor")
    @NotBlank
    @Column(name="floor")
    private String floor;

    @ApiParam(value = "codeEntrance")
    @Column(name="codeEntrance")
    private String codeEntrance;

    @ApiParam(value = "comment")
    @Column(name="comment")
    private String comment;

    public Order() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCodeEntrance() {
        return codeEntrance;
    }

    public void setCodeEntrance(String codeEntrance) {
        this.codeEntrance = codeEntrance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goods=" + goods +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartment='" + apartment + '\'' +
                ", floor='" + floor + '\'' +
                ", codeEntrance='" + codeEntrance + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
