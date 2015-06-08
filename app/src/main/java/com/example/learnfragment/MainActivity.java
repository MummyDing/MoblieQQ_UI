package com.example.learnfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{

    /**
     * 用于展示消息的Fragment
     */
    private MessageFragment messageFragment;

    /**
     * 用于展示联系人的Fragment
     */
    private ContactsFragement contactsFragement;


    /**
     * 用于展示动态的Fragment
     */
    private NewsFragment newsFragment;


    /**
     * 用于展示设置的Fragment
     */
    private SettingFragment settingFragment;


    /**
     * 消息界面布局
     */
    private View messageLayout;


    /**
     * 联系人界面
     */
    private View contactsLayout;

    /**
     * 动态界面布局
     */
    private View newsLayout;

    /**
     * 设置界面布局
     */
    private View settingLayout;

    /**
     * 在Tab 上显示消息图标的控件
     */
    private ImageView messageImage;

    /**
     * 在Tab上显示联系人图标的控件
     */
    private ImageView contactsImage;


    /**
     * 在Tab上显示动态图标的控件
     */
    private ImageView newsImage;

    /**
     * 在Tab 上显示设置图标的控件
     */
    private ImageView settingImage;

    /**
     * 在Tab上显示消息标题的控件
     */
    private TextView messageText;


    /**
     * 在Tab上显示联系人标题的控件
     */
    private TextView contactsText;

    /**
     * 在Tab上显示动态标题的控件
     */
    private TextView newsText;

    /**
     * 在Tab上显示设置标题的控件
     */
    private TextView settingText;


    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    private void initViews(){

        messageLayout = findViewById(R.id.message_layout);
        contactsLayout = findViewById(R.id.contacts_layout);
        newsLayout = findViewById(R.id.news_layout);
        settingLayout = findViewById(R.id.setting_layout);

        messageImage = (ImageView) findViewById(R.id.message_image);
        contactsImage = (ImageView) findViewById(R.id.contacts_image);
        newsImage = (ImageView) findViewById(R.id.news_image);
        settingImage = (ImageView) findViewById(R.id.setting_image);

        messageText = (TextView) findViewById(R.id.message_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        settingText = (TextView) findViewById(R.id.setting_text);

        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.message_layout:
                //当点击了消息tab时，选中第一个Tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                //当点击了联系人tab时，选中第二个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                //当点击了动态tab时，选中第三个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                //当点击了设置tab时，选中第四个tab
                setTabSelection(3);
                break;
        }
    }

    private void setTabSelection(int index){

        //每次选中之前先清除掉上次的选中状态
        clearSelection();
        //开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //先隐藏掉所有的Fragment,防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);

        switch (index){
            case 0:
                //当点击了消息Tab时，改变控件的图片和文字颜色
                messageImage.setImageResource(R.mipmap.message_selected);

                messageText.setTextColor(Color.WHITE);
                if(messageFragment == null){
                    //如果MessageFragment为空，则创建一个添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content,messageFragment);
                }else {
                    //如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;

            case 1:
                //当点击了联系人tab时，改变控件的图片和文字颜色
                contactsImage.setImageResource(R.mipmap.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if(contactsFragement == null){
                    //如果ContactsFragment为空，则创建一个并添加到界面上
                    contactsFragement = new ContactsFragement();
                    transaction.add(R.id.content,contactsFragement);
                }else {
                    //如果ContactsFragment 不为空，则直接将它显示出来
                    transaction.show(contactsFragement);
                }
                break;
            case 2:
                //当点击了动态tab时，改变控件的图片和文字颜色
                newsImage.setImageResource(R.mipmap.news_selected);
                newsText.setTextColor(Color.WHITE);
                if(newsFragment == null){
                    //如果NewsFragment 为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content,newsFragment);
                }else {
                    //如果NesFragment不为空，则直接将它显示出来
                    transaction.show(newsFragment);

                }

                break;
            case 3:
               //当点击了设置tab时，改变控件的图片和文字颜色
                settingImage.setImageResource(R.mipmap.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if(settingFragment == null){
                    //如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment =  new SettingFragment();
                    transaction.add(R.id.content,settingFragment);
                }else{
                    //如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);

                }

                break;
        }
        transaction.commit();
    }

    private void clearSelection(){
        messageImage.setImageResource(R.mipmap.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.mipmap.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.mipmap.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.mipmap.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }

    private void hideFragments(FragmentTransaction transaction){
        if(messageFragment != null){
            transaction.hide(messageFragment);
        }
        if(contactsFragement != null){
            transaction.hide(contactsFragement);
        }
        if(newsFragment != null){
            transaction.hide(newsFragment);
        }
        if(settingFragment != null){
            transaction.hide(settingFragment);
        }
    }
}
