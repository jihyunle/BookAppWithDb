package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    private String title = "";

    @NotNull
    private String author = "";

    @NotNull
    private String description = "";

    @NotNull
    private double price = 0;

    @NotNull
    private boolean isInStock;

    @NotNull
    private int numberOfBooks = 0;

    public Book(){
        System.out.println("In no-arg constructor");
    }

    public Book(String a, String t, String d){  // overloaded version
        System.out.println("In three-arg constructor");
        author = a;
        title = t;
        description = d;
    }

    public void setTitle(String t){
        title = t;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String a){
        author = a;
    }

    public String getAuthor(){
        return author;
    }

    public void setDescription(String d){
        description = d;
    }

    public String getDescription(){
        return description;
    }

    public void setPrice(double p){
        price = p;
    }

    public double getPrice(){
        return price;
    }

    public void setIsInStock(boolean i){
        isInStock = i;
    }

    public boolean getIsInStock(){
        return isInStock;
    }

    public void setNumberOfBooks(int n){
        numberOfBooks = n;
    }

    public int getNumberOfBooks(){
        return numberOfBooks;
    }

    public double calculatePrice(){
        return price * numberOfBooks;
    }

    public String getDisplayText(){
        return "Author: " + getAuthor() + "\t Title: " + getTitle() + "\t Description: " + getDescription() + "\t";
    }
}
