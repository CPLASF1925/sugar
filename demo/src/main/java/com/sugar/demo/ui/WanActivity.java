/*
 * Copyright 2019 wobiancao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sugar.demo.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.sugar.demo.R;
import com.sugar.demo.bean.wan.WanData;
import com.sugar.demo.ui.mvp.wan.WanContract;
import com.sugar.demo.ui.mvp.wan.WanPresenter;
import com.sugar.sugarlibrary.base.BaseActivity;
import com.sugar.sugarlibrary.base.anno.CreatePresenter;
import com.sugar.sugarlibrary.base.anno.PresenterVariable;

/**
 * @author wobiancao
 * @date 2019-05-21
 * desc :
 */
@CreatePresenter(presenter = WanPresenter.class)
public class WanActivity extends BaseActivity<WanPresenter> implements WanContract.IView {
    @PresenterVariable
    WanPresenter mPresenter;
    TextView mInfoView;
    Toolbar mToolbar;
    @Override
    protected int getContentView() {
        return R.layout.gank_activity_list;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mInfoView = findViewById(R.id.tv_info);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("WanAndroid");
        }
    }

    @Override
    public void loadData() {
        mPresenter.getWanArticleList("1");
    }

    @Override
    public void bindData(WanData data) {
        String jsonStr = new Gson().toJson(data);
        mInfoView.setText(jsonStr);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
