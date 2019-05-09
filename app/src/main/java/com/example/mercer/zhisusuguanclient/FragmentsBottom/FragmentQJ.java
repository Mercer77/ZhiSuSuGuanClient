package com.example.mercer.zhisusuguanclient.FragmentsBottom;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercer.zhisusuguanclient.R;
import com.example.mercer.zhisusuguanclient.ShowQJTX;

import org.feezu.liuli.timeselector.TimeSelector;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FragmentQJ extends Fragment {
    ListView listView;
    SimpleAdapter simpleAdapter;
    ArrayList<Map<String,String>> list;
    SearchView searchView;
    TextView roomnum;
    TextView choosedate;
    Button search;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_qj,container,false);
        listView=view.findViewById(R.id.lv_qj);
        searchView=view.findViewById(R.id.search);
        roomnum=view.findViewById(R.id.choose_roomnum);
        choosedate=view.findViewById(R.id.choose_date);
        search=view.findViewById(R.id.find);
        initdb();
        simpleAdapter =new SimpleAdapter(getActivity(),list,R.layout.list_qj,new String[]{"name","roomnum","date"},new int[]{R.id.name,R.id.roomnum,R.id.date});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent();
                intent.setClass(getActivity(), ShowQJTX.class);
                startActivity(intent);

            }
        });
        choosedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String format1 = format.format(date);
                TimeSelector timeSelector = new TimeSelector(getActivity(), new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        choosedate.setText(time.substring(0,10));
                    }
                }, "2017-1-1 24:00", "2050-1-1 24:00");
                timeSelector.setMode(TimeSelector.MODE.YMD);
                timeSelector.show();

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(TextUtils.isEmpty(query))
                {
                    Toast.makeText(getActivity(), "请输入姓名", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent intent = new Intent();
                    Bundle bundle=new Bundle();
                    intent.setClass(getActivity(),ShowQJTX.class);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(2);
                list.remove(1);

                simpleAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
    public void initdb() {

        list = new ArrayList<Map<String, String>>();


            Map<String, String> map = new HashMap<>();
            Map<String, String> map1 = new HashMap<>();
            Map<String, String> map2 = new HashMap<>();
            map.put("name", "张三");
            map.put("roomnum", "4207");
            map.put("date", "2018-8-5");
            list.add(map);
            map1.put("name", "李四");
            map1.put("roomnum", "4101");
            map1.put("date", "2018-8-6");
            list.add(map1);
            map2.put("name", "王五");
            map2.put("roomnum", "4103");
            map2.put("date", "2018-8-7");
            list.add(map2);

    }





}
