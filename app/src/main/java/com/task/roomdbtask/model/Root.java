package com.task.roomdbtask.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "root",indices = @Index(value = {"id"},unique = true))
public class Root {

    @PrimaryKey(autoGenerate = true)
    private int rootId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    public int id;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    public String title;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    public double price;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    public String description;

    @SerializedName("category")
    @ColumnInfo(name = "category")
    public String category;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    public String image;

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    public Rating rating;

    public Root(int id, String title, double price, String description, String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Root{" +
                "rootId=" + rootId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class Rating {
        public double rate;

        public int count;

        public Rating(double rate, int count) {
            this.rate = rate;
            this.count = count;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }
}