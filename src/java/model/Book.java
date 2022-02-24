/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Fernández
 */
public class Book {
    private final String title;
    private final String isbn;
    //private int pageCount;
    //private date publishedDate; si tal hacer una clase date propia y busvar date java y el primero guay
    private String thumbnailUrl;  
    //private String shortDescription;
    //private String longDescription;
    //private String status; //quizas enum?       
    private ArrayList authors;
    //private ArrayList categories;
    //private String country;
    private final float price; //???????//???????
    
    
    public Book(String title, String isbn, String thumbnailUrl, ArrayList authors, float price) {
        this.title = title;
        this.isbn = isbn;
        //this.pageCount = pageCount;
        //this.publishedDate = publishedDate;
        this.thumbnailUrl = thumbnailUrl;
        //this.shortDescription = shortDescription;
        //this.longDescription = longDescription;
        //this.status = status;
        this.authors = authors;
        //this.categories = categories;
        //this.country = country;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    
    public ArrayList getArrayAuthors() {
        return authors;
    }
    public String getAuthors() { //ArrayList
        ArrayList<String> authorsArray = new ArrayList<String>();
        for ( Object a : this.getArrayAuthors()) {
            authorsArray.add((String) a);
        }
        String authorsStr = String.join(", ", authorsArray);
        return authorsStr;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Libro{" + "title=" + title + ", autor=" + authors + ", image=" + thumbnailUrl + ", id=" + isbn + ", price=" + price + '}';
    }
    
    
    
    /**

    public int getPageCount() {
        return pageCount;
    }

    public date getPublishedDate() {
        return publishedDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getStatus() {
        return status;
    }
    * 
    *     public ArrayList getCategories() {
        return categories;
    }

    public String getCountry() {
        return country;
    }
    **/                       
    
}
