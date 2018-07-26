package com.walkinradius.beacon.presenter;

import com.walkinradius.beacon.networking.AndroidNetworking;
import com.walkinradius.beacon.networking.retrofit.RetrofitNetworking;

public class DashboardViewPresenter implements DashboardViewContract.DashboardViewCallbacks {

    private final DashboardViewContract.DashboardView mDashboardView;

    private AndroidNetworking mAndroidNetworking = new RetrofitNetworking();

    public DashboardViewPresenter(DashboardViewContract.DashboardView dashboardView) {
        this.mDashboardView = dashboardView;
    }

    @Override
    public void onActivityCreated() {
        mDashboardView.showProgressBar();
        mAndroidNetworking.getBeaconsInfo(callback);
    }

    private AndroidNetworking.Callback callback = new AndroidNetworking.Callback() {

        @Override
        public void onSuccess(String message) {
            mDashboardView.hideProgressBar();
            mDashboardView.showMessage(message);
        }

        @Override
        public void onFailure(String message) {
            mDashboardView.hideProgressBar();
            mDashboardView.showMessage(message);
        }
    };
}