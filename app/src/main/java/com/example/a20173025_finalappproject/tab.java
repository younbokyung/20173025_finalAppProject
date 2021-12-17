package com.example.a20173025_finalappproject;

import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

public class tab extends AppCompatActivity {


    String tabname;
    String tabrole;
    String tabdiff;
    Drawable iconDrawable ;




    public String getName() {
        return tabname;
    }

    public void setName(String name) {
        this.tabname = name;

    }


    public String getTabrole() {
        return tabrole;
    }

    public void setTabrole(String role) {
        this.tabrole = role;
    }

    public String getTabdiff() {
        return tabdiff;
    }

    public void setTabdiff(String diff) {
        this.tabdiff = diff;
    }

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public Drawable getIcon() {
        return this.iconDrawable ;
    }

}

