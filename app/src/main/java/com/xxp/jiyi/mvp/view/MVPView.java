package com.xxp.jiyi.mvp.view;

import com.xxp.jiyi.mvp.presenter.MVPPresenter;

/**
 * Created by 钟大爷 on 2017/03/27
 */

public interface MVPView<P extends MVPPresenter> {
    //指定view的Presenter
    void setPresenter(P presenter);
}