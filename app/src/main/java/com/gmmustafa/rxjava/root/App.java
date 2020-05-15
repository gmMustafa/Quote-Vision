package com.gmmustafa.rxjava.root;

import android.app.Application;

import com.gmmustafa.rxjava.typefitApi.TypefitService;
import com.google.gson.Gson;

import retrofit2.Retrofit;

public class App extends Application {

    AppComponent appComponent;
    public AppComponent getAppComponent() {
        return appComponent;
    }



    public TypefitService getTypefitService() {
        return appComponent.typefitService();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Dependency injection
        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }


}
