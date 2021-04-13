package com.example.fragment;

import android.widget.TextView;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private String titleTitle, lastText;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleTitle() {
        return titleTitle;
    }

    public void setTitleTitle(String titleTitle) {
        this.titleTitle = titleTitle;
    }

    public String getLastText() {
        return lastText;
    }

    public void setLastText(String lastText) {
        this.lastText = lastText;
    }

    public ItemModel(String titleTitle, String lastText) {
        this.titleTitle = titleTitle;
        this.lastText = lastText;
    }
}
