package com.example.shoppingapp.Model;

public class SliderModel {
    private int banner;
    private  String bannerBackgroundcolor;

    public SliderModel(int banner, String bannerBackgroundcolor) {
        this.banner = banner;
        this.bannerBackgroundcolor = bannerBackgroundcolor;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getBannerBackgroundcolor() {
        return bannerBackgroundcolor;
    }

    public void setBannerBackgroundcolor(String bannerBackgroundcolor) {
        this.bannerBackgroundcolor = bannerBackgroundcolor;
    }
}
