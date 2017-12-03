package com.morening.hello.hellosystemui;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private View mStatusNavigationBarLayout = null;
    private View mStatusBarLayout = null;
    private View mNavigationBarLayout = null;

    private ViewPager mViewPager = null;

    private boolean mIsNavigationStatusBarTranslucent = false;
    private boolean mIsNavigationBarTranslucent = false;
    private boolean mIsStatusBarTranslucent = false;

    private int mNavigationBarColor = 0;
    private int mStatusBarColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        mNavigationBarColor = getWindow().getNavigationBarColor();
        mStatusBarColor = getWindow().getStatusBarColor();

        initAllView();
        initAllBtn();
    }

    private void initAllView() {
        mViewPager = findViewById(R.id.id_viewpager);
        LayoutInflater inflater = LayoutInflater.from(this);
        mStatusNavigationBarLayout = inflater.inflate(R.layout.layout_status_navigation_bar, null, false);
        mStatusBarLayout = inflater.inflate(R.layout.layout_status_bar, null, false);
        mNavigationBarLayout = inflater.inflate(R.layout.layout_navigation_bar, null, false);
        List<View> viewList = new ArrayList<>();
        viewList.add(mStatusNavigationBarLayout);
        viewList.add(mStatusBarLayout);
        viewList.add(mNavigationBarLayout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(viewList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
    }

    private void initAllBtn() {
        initStatusNavigationBarBtn();
        initStatusBarBtn();
        initNavigationBarBtn();
    }

    private void initStatusNavigationBarBtn(){
        View hideStatusNavigationBarWithoutLayoutBtn = mStatusNavigationBarLayout.findViewById(R.id.hide_status_navigation_bar_without_layout);
        hideStatusNavigationBarWithoutLayoutBtn.setOnClickListener(this);
        View hideStatusNavigationBarWithLayoutBtn = mStatusNavigationBarLayout.findViewById(R.id.hide_status_navigation_bar_with_layout);
        hideStatusNavigationBarWithLayoutBtn.setOnClickListener(this);
        View showStatusNavigationBarTranslucentBtn = mStatusNavigationBarLayout.findViewById(R.id.show_status_navigation_bar_translucent);
        showStatusNavigationBarTranslucentBtn.setOnClickListener(this);
        View showStatusNavigationBar = mStatusNavigationBarLayout.findViewById(R.id.show_navigation_status_bar);
        showStatusNavigationBar.setOnClickListener(this);
    }

    private void initStatusBarBtn(){
        View hideStatusBarWithoutLayoutBtn = mStatusBarLayout.findViewById(R.id.hide_status_bar_without_layout);
        hideStatusBarWithoutLayoutBtn.setOnClickListener(this);
        View hideStatusBarWithLayoutBtn = mStatusBarLayout.findViewById(R.id.hide_status_bar_with_layout);
        hideStatusBarWithLayoutBtn.setOnClickListener(this);
        View showStatusBarTranslucentBtn = mStatusBarLayout.findViewById(R.id.show_status_bar_translucent);
        showStatusBarTranslucentBtn.setOnClickListener(this);
        View showStatusBar = mStatusBarLayout.findViewById(R.id.show_status_bar);
        showStatusBar.setOnClickListener(this);
    }

    private void initNavigationBarBtn(){
        View hideNavigationBarWithoutLayoutBtn = mNavigationBarLayout.findViewById(R.id.hide_navigation_bar_without_layout);
        hideNavigationBarWithoutLayoutBtn.setOnClickListener(this);
        View hideNavigationBarWithLayoutBtn = mNavigationBarLayout.findViewById(R.id.hide_navigation_bar_with_layout);
        hideNavigationBarWithLayoutBtn.setOnClickListener(this);
        View showNavigationBarTranslucentBtn = mNavigationBarLayout.findViewById(R.id.show_navigation_bar_translucent);
        showNavigationBarTranslucentBtn.setOnClickListener(this);
        View showNavigationBar = mNavigationBarLayout.findViewById(R.id.show_navigation_bar);
        showNavigationBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hide_status_navigation_bar_without_layout:
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mStatusNavigationBarLayout);
                break;
            case R.id.hide_status_navigation_bar_with_layout:
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mStatusNavigationBarLayout);
                break;
            case R.id.show_status_navigation_bar_translucent:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setNavigationBarColor(Color.TRANSPARENT);
                getWindow().setStatusBarColor(Color.TRANSPARENT);

                mIsNavigationStatusBarTranslucent = true;

                onHideOrTranslucentBtnClicked(mStatusNavigationBarLayout);
                break;
            case R.id.show_navigation_status_bar:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

                if (mIsNavigationStatusBarTranslucent){
                    getWindow().setStatusBarColor(mStatusBarColor);
                    getWindow().setNavigationBarColor(mNavigationBarColor);
                    mIsNavigationStatusBarTranslucent = false;
                }
                onShowBtnClicked(mStatusNavigationBarLayout);
                break;


            case R.id.hide_status_bar_without_layout:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mStatusBarLayout);
                break;
            case R.id.hide_status_bar_with_layout:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mStatusBarLayout);
                break;
            case R.id.show_status_bar_translucent:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.TRANSPARENT);

                mIsStatusBarTranslucent = true;

                onHideOrTranslucentBtnClicked(mStatusBarLayout);
                break;
            case R.id.show_status_bar:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                if (mIsStatusBarTranslucent){
                    getWindow().setStatusBarColor(mStatusBarColor);
                    mIsStatusBarTranslucent = false;
                }

                onShowBtnClicked(mStatusBarLayout);
                break;


            case R.id.hide_navigation_bar_without_layout:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mNavigationBarLayout);
                break;
            case R.id.hide_navigation_bar_with_layout:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

                onHideOrTranslucentBtnClicked(mNavigationBarLayout);
                break;
            case R.id.show_navigation_bar_translucent:
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                getWindow().setNavigationBarColor(Color.TRANSPARENT);

                mIsNavigationBarTranslucent = true;

                onHideOrTranslucentBtnClicked(mNavigationBarLayout);
                break;
            case R.id.show_navigation_bar:
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_VISIBLE);

                if (mIsNavigationBarTranslucent){
                    getWindow().setNavigationBarColor(mNavigationBarColor);
                    mIsNavigationBarTranslucent = false;
                }

                onShowBtnClicked(mNavigationBarLayout);
                break;
        }
    }

    private void onHideOrTranslucentBtnClicked(View itemView) {
        LinearLayout layout = itemView.findViewById(R.id.id_linearlayout);
        int count = layout.getChildCount();
        for (int k=0; k<count-1; k++){
            Button button = (Button) layout.getChildAt(k);
            button.setEnabled(false);
        }
    }

    private void onShowBtnClicked(View itemView){
        LinearLayout layout = itemView.findViewById(R.id.id_linearlayout);
        int count = layout.getChildCount();
        for (int k=0; k<count-1; k++){
            Button button = (Button) layout.getChildAt(k);
            button.setEnabled(true);
        }
    }
}
