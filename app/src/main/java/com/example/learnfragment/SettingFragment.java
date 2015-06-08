package com.example.learnfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 钦颖 on 2015/6/6.
 */
public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View settingLayout = inflater.inflate(R.layout.setting_layout,container,false);
        return settingLayout;
    }
}
