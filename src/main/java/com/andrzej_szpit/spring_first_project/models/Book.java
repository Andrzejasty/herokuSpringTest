package com.andrzej_szpit.spring_first_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String title;
    private double price;

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "Book [id=" + id + ", title=" +title +", price="+price+"]";
    }

}
