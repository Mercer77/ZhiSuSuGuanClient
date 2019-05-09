package com.example.mercer.zhisusuguanclient.FragmentsBottom.FragmentWSs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mercer.zhisusuguanclient.R;

public class FragmentSDF extends Fragment {
    Button save;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sdf,container,false);
        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已录入水电费", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
