package com.bwf.aiyiqi.gui.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseFitmentLive;
import com.bwf.aiyiqi.entity.ResponseFlashView;
import com.bwf.aiyiqi.gui.mvp.model.DecorationCompanyModel;
import com.bwf.aiyiqi.gui.mvp.model.impl.DecorationCompanyModelImpl;
import com.bwf.aiyiqi.gui.mvp.presenter.DecorationCompanyPresenter;
import com.bwf.aiyiqi.gui.mvp.view.DecorationCompanyView;

/**
 * Created by Administrator on 2016/11/23.
 */

public class DecorationCompanyPresenterImpl implements DecorationCompanyPresenter {
    private DecorationCompanyModel decorationCompanyModel;
    private DecorationCompanyView decorationCompanyView;

    public DecorationCompanyPresenterImpl(DecorationCompanyView decorationCompanyView) {
        this.decorationCompanyModel = new DecorationCompanyModelImpl();
        this.decorationCompanyView = decorationCompanyView;
    }

    @Override
    public void loadDatas() {
        decorationCompanyModel.loadDatasFlashView(new DecorationCompanyModel.CallbackFlashView() {
            @Override
            public void loadSuccess(ResponseFlashView responseFlashView) {
                decorationCompanyView.loadFlashViewSuccess(responseFlashView);
            }

            @Override
            public void loadFailed(Exception e) {
                decorationCompanyView.loadFlashViewFailed(e);
            }
        });
        decorationCompanyModel.loadDatasFitmentLive(new DecorationCompanyModel.CallbackFitmentLive() {
            @Override
            public void loadSuccess(ResponseFitmentLive responseFitmentLive) {
                decorationCompanyView.loadFitmentLiveSuccess(responseFitmentLive);
            }

            @Override
            public void loadFailed(Exception e) {
                decorationCompanyView.loadFitmentLiveFailed(e);
            }
        });

    }
}
