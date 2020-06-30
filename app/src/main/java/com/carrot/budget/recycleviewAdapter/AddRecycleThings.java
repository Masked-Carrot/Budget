package com.carrot.budget.recycleviewAdapter;

import android.graphics.drawable.Drawable;

public class AddRecycleThings {

    int icon;
    String name;

    public AddRecycleThings(int icon , String name){
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
