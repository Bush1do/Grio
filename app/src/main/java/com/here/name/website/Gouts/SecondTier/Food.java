package com.here.name.website.Gouts.SecondTier;

/**
 * Created by Charles on 6/3/2018.
 */

public class Food {
    private String name;
    private String prepTime;
    private String ingredients;
    private String description;
    private int thumbnail;
    private boolean liked=false;

    public Food(){}

    public Food(String name, String prepTime, String ingredients, String description, int thumbnail, boolean liked) {
        this.name = name;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.description = description;
        this.thumbnail = thumbnail;
        this.liked=liked;
    }

    public String getName() {
        return name;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

}
