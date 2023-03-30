/*
 * This class represents a DTO (Data Transfer Object) used for mapping incoming JSON requests
 * for creating a product from a cloud service.
 */
package com.fredy.pruebanexsys.dto.request;

import java.util.ArrayList;
import java.util.List;

public class ProductRequestCloudDto {

    private String title;           // the title of the product
    private int price;              // the price of the product
    private Long categoryId;        // the ID of the category the product belongs to
    private String description;     // the description of the product
    private List<String> images;    // a list of URLs for the images of the product

    public ProductRequestCloudDto() {
        images = new ArrayList<>(); // initialize the images list to an empty ArrayList
    }

    // Add an image URL to the list of images for this product
    public void addImage(String image){
        images.add(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
