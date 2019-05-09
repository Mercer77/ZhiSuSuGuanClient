package com.example.mercer.zhisusuguanclient.FragmentsBottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentWSs.FragmentSDF;
import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentWSs.FragmentWSJC;
import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentWSs.FragmentWSJL;
import com.example.mercer.zhisusuguanclient.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentWS extends Fragment {
    TabLayout tabLayout;
    FragmentManager fragmentManager;
    FragmentWSJC fragmentWSJC;
    FragmentWSJL fragmentWSJL;
    FragmentSDF fragmentSDF;
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    List<String> list;
    List<Fragment> fragments;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ws,container,false);
        tabLayout=view.findViewById(R.id.tab_layout);
        viewPager=view.findViewById(R.id.viewpager);
        fragmentWSJC=new FragmentWSJC();
        fragmentWSJL =new FragmentWSJL();
        fragmentSDF=new FragmentSDF();
        list=new ArrayList<>();
        fragments=new ArrayList<>();
        fragments.add(fragmentWSJC);
        fragments.add(fragmentWSJL);
        fragments.add(fragmentSDF);
        list.add("卫生检查");
        list.add("卫生记录");
        list.add("水电费");
        fragmentManager=getChildFragmentManager();
        viewPager.setOffscreenPageLimit(list.size());//预加载
        fragmentPagerAdapter= new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }


            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        };


        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
