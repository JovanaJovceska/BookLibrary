package com.example.booklibrary;

public class ModelCategory {
    String id, categoryName, uid;
    long timestamp;

    public ModelCategory() {

    }

    public ModelCategory(String id, String categoryName, String uid, long timestamp) {
        this.id = id;
        this.categoryName = categoryName;
        this.uid = uid;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
