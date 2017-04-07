package com.xxp.jiyi.mvp.presenter;

import com.xxp.jiyi.mvp.view.MVPView;

/**
 * Created by 钟大爷 on 2017/3/27.
 */

public interface MVPPresenter<T extends MVPView> {
    //绑定视图
    void attachViwe();
    //解绑视图
    void detachView();
}
