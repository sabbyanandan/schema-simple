package com.example.consumer;

public class User {

    String name;
    String favoriteColor;

    /**
     * @return the favoriteColor
     */
    public String getFavoriteColor() {
        return favoriteColor;
    }

    /**
     * @param favoriteColor the favoriteColor to set
     */
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}