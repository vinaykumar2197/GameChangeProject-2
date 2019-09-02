package com.vinaykumar.gamechangesns2;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.vinaykumar.gamechangesns2.viewmodel.CommentViewModel;

/**
 * Created by admin on 02-Sep-19.
 */

public class MyViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application mApplication;
    private Object[] mParams;

    public MyViewModelFactory(Application application, Object... params) {
        mApplication = application;
        mParams = params;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass == CommentViewModel.class) {
            return (T) new CommentViewModel(mApplication, (String) mParams[0]);
        } else {
            return super.create(modelClass);
        }
    }
}