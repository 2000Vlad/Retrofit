package com.course.networking.retrofitmovies;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    private String mTitle;
    public String getTitle(){
        return  mTitle;
    }
    public void setTitle(String title){
        mTitle =  title;
    }
    @Override
    public String toString(){
        return mTitle+",";
    }
}
