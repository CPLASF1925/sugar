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
package com.sugar.demo.ui.mvp.gank;

import com.sugar.demo.bean.gank.GirlsData;
import com.sugar.demo.http.repository.GankRepository;
import com.sugar.sugarlibrary.base.presenter.BasePresenter;
import com.sugar.sugarlibrary.rx.SugarHandleSubscriber;

import java.util.List;


/**
 * @author wobiancao
 * @date 2019/5/20
 * desc :
 */
public class GankPresenter extends BasePresenter<GankContract.IView, GankRepository> implements GankContract.PView {

    @Override
    protected void initRepository() {
        mModel = new GankRepository(mView);
    }

    @Override
    public void getFuliDataRepository(String size, String index) {

        mModel.getFuliDataRepository(size, index)
                .subscribe(new SugarHandleSubscriber<List<GirlsData>>() {
                    @Override
                    public void onNext(List<GirlsData> girlsData) {
                        mView.bindData(girlsData);
                    }
                });
    }


}
