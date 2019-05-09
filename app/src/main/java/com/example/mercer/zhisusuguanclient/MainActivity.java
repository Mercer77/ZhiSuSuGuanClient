package com.example.mercer.zhisusuguanclient;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentBX;
import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentQJ;
import com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentWS;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //三个底部导航栏fragment
    FragmentQJ fragmentQJ;
    FragmentWS fragmentWS;
    FragmentBX fragmentBX;
    //三个导航栏布局
    View Actionbar1layout;
    View Actionbar2layout;
    View Actionbar3layout;
    //三个布局所在图片文本
    ImageView img1;
    ImageView img2;
    ImageView img3;
    TextView text1;
    TextView text2;
    TextView text3;
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> fragments;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSelected(0);
    }
    public  void init(){
        Actionbar1layout=findViewById(R.id.actionbar1_layout);
        Actionbar2layout=findViewById(R.id.actionbar2_layout);
        Actionbar3layout=findViewById(R.id.actionbar3_layout);
        Actionbar1layout.setOnClickListener(this);
        Actionbar2layout.setOnClickListener(this);
        Actionbar3layout.setOnClickListener(this);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        title=findViewById(R.id.SyTitle);
        viewPager=findViewById(R.id.viewpager);
        fragmentBX =new FragmentBX();
        fragmentQJ =new FragmentQJ();
        fragmentWS =new FragmentWS();
        fragments=new ArrayList<>();
        fragments.add(fragmentQJ);
        fragments.add(fragmentWS);
        fragments.add(fragmentBX);
        fragmentPagerAdapter =new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                int item =viewPager.getCurrentItem();
                change(item);

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.actionbar1_layout:
                setSelected(0);
                //Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionbar2_layout:
                setSelected(1);
                //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionbar3_layout:
                setSelected(2);
                //Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    public void change(int item){
        clearSelection();
        switch (item){
            case 0:
            img1.setImageResource(R.drawable.contacts1);
            title.setText("请假信息");
                break;
            case 1:
            img2.setImageResource(R.drawable.message1);
            title.setText("卫生信息");
                break;
            case 2:
            img3.setImageResource(R.drawable.setting1);
            title.setText("报修信息");
                break;
        }
 }
    public void setSelected(int item){
        change(item);
        viewPager.setCurrentItem(item);
    }
    public void clearSelection(){
        img1.setImageResource(R.drawable.contacts);
        img2.setImageResource(R.drawable.message);
        img3.setImageResource(R.drawable.setting);
    }
}
