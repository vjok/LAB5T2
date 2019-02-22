package com.example.predator.lab5t2.model;

import java.io.Serializable;

public class ToDoItem implements Serializable {

    int id;
    String itemTitle;
    String itemDescription;
    String dueDate;

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ToDoItem(String title, String description, String duedate)
    {
        this.itemTitle = title;
        this.itemDescription = description;
        this.dueDate = duedate;
    }

    public ToDoItem(){}

    public void setTitle(String title)
    {
        this.itemTitle = title;
    }

    public void setDescription(String description)
    {
        this.itemDescription = description;
    }

    public String getTitle()
    {
        return itemTitle;
    }

    public String getDescription()
    {
        return itemDescription;
    }


    public String toString() {
        return "Item [id=" + id + ", title=" + itemTitle + ", author=" + itemDescription+ ", päivä="+dueDate+ "]";
    }
}
