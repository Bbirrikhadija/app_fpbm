package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    private int tabNum;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabNum=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new isi();
            case 1:
                return new stri();
            case 2:
                return new bios();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
