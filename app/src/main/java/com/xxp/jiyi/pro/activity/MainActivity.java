package com.xxp.jiyi.pro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xxp.jiyi.R;
import com.xxp.jiyi.pro.api.APIEngine;
import com.xxp.jiyi.pro.entity.WeatherData;
import com.xxp.jiyi.pro.fragment.AboutFragment;
import com.xxp.jiyi.pro.fragment.DiyFragment;
import com.xxp.jiyi.pro.fragment.HomeFragment;
import com.xxp.jiyi.pro.fragment.MeiwenFragment;
import com.xxp.jiyi.pro.fragment.MoodFragment;
import com.xxp.jiyi.pro.fragment.NoticeFragment;
import com.xxp.jiyi.pro.utils.Lunar;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.xxp.jiyi.R.id.fl_content;
import static com.xxp.jiyi.R.id.nav_view;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "MainActivity";
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_openMenu)
    ImageView ivOpenMenu;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //headView
    private View mHeaderLayout;

    //请求码
    public static final int CODE_REQUEST = 0x11;

    //返回码
    public static final int CODE_RESULT = 0x12;

    //城市信息key
    public static final String KEY_CITY_INFO = "key_city_info";

    //切换城市
    private ImageView ivChangeCity;
    //天气一行
    private TextView tvOne;
    //天气二行
    private TextView tvTwo;

    //主页
    private Fragment mHomeFragment;
    //个性化
    private Fragment mDiyFragment;
    //美文推荐
    private Fragment mMeiwenFragment;
    //通知
    private Fragment mNoticeFragment;
    //心情
    private Fragment mMoodFragment;
    //关于
    private Fragment mAboutFragment;
    //
    private FragmentManager mFragmentManager;

    private Fragment mCurrentFragment;

    private String mTitles[] = {"忆筏", "个性化", "美文推荐", "通知", "心情", "关于"};
    //默认的城市
    private final String DEFAULT_CITY = "成都";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationView();
        initContentView();
        //获取天气
        loadWeather(DEFAULT_CITY);
        //农历
        loadLunar();
    }

    private void loadLunar() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        Lunar lunar = new Lunar(calendar);
        tvTwo.setText(String.format("%d月%d日  星期%s  %s", month, day, lunar.getChineseWeek(weekday), lunar.getLunarMonthString()));
    }

    private void loadWeather(String city) {
        Observable<WeatherData> observable = APIEngine.getInstance().getWeatherService().getWeather(city);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<WeatherData>() {
                    @Override
                    public void onNext(WeatherData value) {
                        Log.e(TAG, "onNext: " + value
                                .getShowapi_res_body()
                                .getArea() + " "
                                + value
                                .getShowapi_res_body()
                                .getDayList()
                                .get(0)
                                .getDay_weather() + " "
                                + value
                                .getShowapi_res_body()
                                .getDayList()
                                .get(0).getDay_air_temperature() + "℃");

                        tvOne.setText(value
                                .getShowapi_res_body()
                                .getArea() + " "
                                + value
                                .getShowapi_res_body()
                                .getDayList()
                                .get(0)
                                .getDay_weather() + " "
                                + value
                                .getShowapi_res_body()
                                .getDayList()
                                .get(0).getDay_air_temperature() + "℃");
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e );
                    }

                });

    }

    private void initContentView() {
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        setHomeFragment();
    }

    private void setHomeFragment() {
        tvTitle.setText(mTitles[0]);
        ivSearch.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        switchFragment(mHomeFragment);
    }

    private void setDiyFragment() {
        tvTitle.setText(mTitles[1]);
        ivSearch.setVisibility(View.INVISIBLE);
        fab.setVisibility(View.GONE);
        if (mDiyFragment == null) {
            mDiyFragment = new DiyFragment();
        }
        switchFragment(mDiyFragment);
    }

    private void setMeiwenFragment() {
        tvTitle.setText(mTitles[2]);
        fab.setVisibility(View.GONE);
        if (mMeiwenFragment == null) {
            mMeiwenFragment = new MeiwenFragment();
        }
        switchFragment(mMeiwenFragment);
    }

    private void setNoticeFragment() {
        tvTitle.setText(mTitles[3]);
        ivSearch.setVisibility(View.INVISIBLE);
        fab.setVisibility(View.GONE);
        if (mNoticeFragment == null) {
            mNoticeFragment = new NoticeFragment();
        }
        switchFragment(mNoticeFragment);
    }

    private void setMoodFragment() {
        tvTitle.setText(mTitles[4]);
        fab.setVisibility(View.GONE);
        if (mMoodFragment == null) {
            mMoodFragment = new MoodFragment();
        }
        switchFragment(mMoodFragment);
    }

    private void setAboutFragment() {
        tvTitle.setText(mTitles[5]);
        ivSearch.setVisibility(View.INVISIBLE);
        fab.setVisibility(View.GONE);
        if (mAboutFragment == null) {
            mAboutFragment = new AboutFragment();
        }
        switchFragment(mAboutFragment);
    }


    private void switchFragment(Fragment total) {
        android.support.v4.app.FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (null == mCurrentFragment) {
            transaction.add(fl_content, mHomeFragment).commit();
            mCurrentFragment = total;
        }
        if (mCurrentFragment != total) {
            transaction = mFragmentManager.beginTransaction();
            if (!total.isAdded()) {
                transaction.hide(mCurrentFragment).add(fl_content, total).commit();
            } else {
                transaction.hide(mCurrentFragment).show(total).commit();
            }
            mCurrentFragment = total;
        }
    }

    private void initNavigationView() {
        navView.setNavigationItemSelectedListener(this);
        mHeaderLayout = navView.getHeaderView(0);
        ivChangeCity = (ImageView) mHeaderLayout.findViewById(R.id.iv_change);
        tvOne = (TextView) mHeaderLayout.findViewById(R.id.tv_one);
        tvTwo = (TextView) mHeaderLayout.findViewById(R.id.tv_two);

        ivChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击到选择城市
                toChangeCity();
            }
        });
    }

    //到选择城市的Activity
    private void toChangeCity() {
        Intent intent = new Intent(this,SelectCityActivity.class);
        startActivityForResult(intent,CODE_REQUEST);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                setHomeFragment();
                break;
            case R.id.nav_diy:
                setDiyFragment();
                break;
            case R.id.nav_meiwen:
                setMeiwenFragment();
                break;
            case R.id.nav_notice:
                setNoticeFragment();
                break;
            case R.id.nav_mood:
                setMoodFragment();
                break;
            case R.id.nav_about:
                setAboutFragment();
                break;
            case R.id.nav_share:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.iv_openMenu, R.id.iv_search, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_openMenu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.iv_search:
                break;
            case R.id.fab:
                addNotes();
                break;
        }
    }

    //添加笔记
    private void addNotes() {
// TODO: 2017/4/8  新建记录
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case CODE_RESULT:
                Log.e(TAG, "onActivityResult: " );
                String city = data.getStringExtra(KEY_CITY_INFO);
                if(!TextUtils.isEmpty(city)){
                    loadWeather(city);
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
