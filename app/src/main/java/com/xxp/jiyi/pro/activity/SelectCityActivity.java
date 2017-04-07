package com.xxp.jiyi.pro.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xxp.jiyi.R;
import com.xxp.jiyi.pro.adapter.AlmightyAdapter;
import com.xxp.jiyi.pro.adapter.assist.ViewHolder;
import com.xxp.jiyi.pro.entity.CityData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectCityActivity extends BaseActivity implements TextWatcher {


    private final String TAG = "SelectCityActivity";
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.txt_city)
    EditText txtCity;
    @BindView(R.id.rv_city)
    RecyclerView rvCity;
    @BindView(R.id.tv_isEmpty)
    TextView tvIsEmpty;

    //通过关键字查到的
    private List<CityData> citysTwo;
    //推荐的城市
    private List<CityData> citysOne;
    //定位得到的城市
    private CityData fromGPSCity;

    private String ASSETS_NAME = "china_cities.db";
    private String DB_NAME = "china_cities.db";
    private String TABLE_NAME = "city";
    private String NAME = "name";
    private String PINYIN = "pinyin";
    private int BUFFER_SIZE = 1024;
    private String DB_PATH;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_city;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDate();
        initListener();
    }

    private void initListener() {
        txtCity.addTextChangedListener(this);
    }

    private void initDB() {
        DB_PATH = File.separator + "data"
                + Environment.getDataDirectory().getAbsolutePath() + File.separator
                + this.getPackageName() + File.separator + "databases" + File.separator;
        copyDBFile();
    }

    private void initDate() {
        initDB();
        loadRecommendCity();
    }


    private void loadRecommendCity() {
        citysOne = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(DB_PATH + DB_NAME, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        for (int i = 0; i < 18; i++) {
            if (cursor.moveToNext()) {
                citysOne.add(new CityData(cursor.getString(cursor.getColumnIndex(NAME)),
                        cursor.getString(cursor.getColumnIndex(PINYIN))));
            }
        }
        cursor.close();
        showToViwe(0);

    }

    private void showToViwe(int type) {
        switch (type) {
            case 0:
                AlmightyAdapter<CityData> adapterOne = new AlmightyAdapter<CityData>(citysOne, this) {
                    @Override
                    protected int getRootViewId(int viewType) {
                        return R.layout.item_reco_city;
                    }

                    @Override
                    protected void convert(ViewHolder viewHolder, int position, List<CityData> mDatas) {
                        viewHolder.setText(R.id.tv_city, mDatas.get(position).getName());
                    }

                };

                rvCity.setLayoutManager(new GridLayoutManager(this, 3));
                rvCity.setAdapter(adapterOne);

                click(adapterOne,type);
                break;
            case 1:
                AlmightyAdapter<CityData> adapterTwo = new AlmightyAdapter<CityData>(citysTwo, this) {
                    @Override
                    protected int getRootViewId(int viewType) {
                        return R.layout.item_sarch_city;
                    }

                    @Override
                    protected void convert(ViewHolder viewHolder, int position, List<CityData> mDatas) {
                        viewHolder.setText(R.id.tv_city, mDatas.get(position).getName()+"  "+mDatas.get(position).getPinyin());
                    }

                };

                rvCity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                rvCity.setAdapter(adapterTwo);
                click(adapterTwo,type);
                break;
        }
    }

    //点击item
    private void click(AlmightyAdapter<CityData> adapter, final int type) {
        adapter.setOnItemOnClickListener(new AlmightyAdapter.OnItemOnClickListener() {
            @Override
            public void onClick(int position) {
                switch (type) {
                    case 0:
                        CityData cityOne = citysOne.get(position);
                        Log.e(TAG, "onClick: "+cityOne.toString());
                        break;
                    case 1:
                        CityData cityTwo =  citysTwo.get(position);
                        Log.e(TAG, "onClick: "+cityTwo.toString());
                        break;
                }
            }
        });
    }

    private void fromGPS() {

    }

    public List<CityData> searchCity(String keyword) {
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(DB_PATH + DB_NAME, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + " where name like \"%" + keyword
                + "%\" or pinyin like \"%" + keyword + "%\"", null);
        List<CityData> result = new ArrayList<>();
        CityData city;
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String pinyin = cursor.getString(cursor.getColumnIndex(PINYIN));
            city = new CityData(name, pinyin);
            result.add(city);
        }
        cursor.close();
        sqLiteDatabase.close();
        return result;
    }

    //保存数据库到本地
    public void copyDBFile() {
        File dir = new File(DB_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dbFile = new File(DB_PATH + DB_NAME);
        if (!dbFile.exists()) {
            InputStream is;
            OutputStream os;
            try {
                is = this.getResources().getAssets().open(ASSETS_NAME);
                os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int length;
                while ((length = is.read(buffer, 0, buffer.length)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick({R.id.iv_close, R.id.txt_city})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                finish();
                break;
            case R.id.txt_city:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String keyword = s.toString();
        if (TextUtils.isEmpty(keyword)) {
            tvIsEmpty.setVisibility(View.INVISIBLE);
            rvCity.setVisibility(View.VISIBLE);
            showToViwe(0);
        } else {
            citysTwo = searchCity(keyword);
            if (citysTwo.size() == 0) {
                tvIsEmpty.setVisibility(View.VISIBLE);
                rvCity.setVisibility(View.INVISIBLE);
            } else {
                tvIsEmpty.setVisibility(View.INVISIBLE);
                rvCity.setVisibility(View.VISIBLE);
                showToViwe(1);
            }
        }
    }
}
