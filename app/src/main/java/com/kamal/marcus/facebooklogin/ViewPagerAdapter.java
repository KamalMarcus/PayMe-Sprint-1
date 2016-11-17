package com.kamal.marcus.facebooklogin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KiMoo on 09/11/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments=new ArrayList<>();
    List<String> fragmentsTitlesList=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment,String title){
        fragments.add(fragment);
        fragmentsTitlesList.add(title);
    }

    public CharSequence getPageTitle(int position){
        return fragmentsTitlesList.get(position);
    }
}
