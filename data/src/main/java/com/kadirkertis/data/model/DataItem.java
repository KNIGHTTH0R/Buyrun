package com.kadirkertis.data.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;

/**
 * Created by Kadir Kertis on 11/13/2017.
 */

public class DataItem {

    private String key;
    private String category;
    private String subCategory;
    private String name;
    private String description;
    private String url;
    private double price;
    private HashMap<String,Object> timeAdded;
    private HashMap<String,Object> timeLastEdited;

    public DataItem(){

    }

    public DataItem(String key, String category, String subCategory,
                String name, String description,
                double price, String url, HashMap<String,Object> timeAdded){
        this.key = key;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.description = description;
        this.price = price;
        this.timeAdded = timeAdded;
        this.url = url;

        HashMap<String,Object> timeLastEditedObj = new HashMap<>();
        timeLastEditedObj.put("timestamp", ServerValue.TIMESTAMP);
        this.timeLastEdited = timeLastEditedObj;
    }


    public String getKey(){return key;}
    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }

    public String getSubCategory(){return  subCategory;}

    public String getUrl(){return url;}

    public HashMap<String, Object> getTimeAdded() {
        if(timeAdded != null){
            return timeAdded;
        }

        HashMap<String,Object> timeAddedObj = new HashMap<>();
        timeAddedObj.put("timestamp", ServerValue.TIMESTAMP);
        return timeAddedObj;
    }

    public HashMap<String,Object> getTimeLastEdited(){
        return timeLastEdited;
    }

    @Exclude
    public long getTimeAddedLong(){
        return (long)timeAdded.get("timestamp");
    }

    @Exclude
    public long getTimeLastEditedLong(){
        return (long) timeLastEdited.get("timestamp");
    }
}
