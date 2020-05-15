package com.gmmustafa.rxjava.root;

import com.gmmustafa.rxjava.typefitApi.TypefitService;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    TypefitService typefitService();

}
