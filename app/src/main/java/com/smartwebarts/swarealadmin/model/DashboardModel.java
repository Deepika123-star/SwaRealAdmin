package com.smartwebarts.swarealadmin.model;

import android.widget.ImageView;

public class DashboardModel {
   String imagesId;
    String  iconName;

    public DashboardModel(String imagesId, String iconName) {
        this.imagesId = imagesId;
        this.iconName = iconName;
    }

    public String getImagesId() {
        return imagesId;
    }

    public void setImagesId(String imagesId) {
        this.imagesId = imagesId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
