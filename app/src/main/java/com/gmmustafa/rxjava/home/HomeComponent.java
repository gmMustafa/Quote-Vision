package com.gmmustafa.rxjava.home;

import com.gmmustafa.rxjava.root.AppComponent;

import dagger.Component;

@Component(modules = {QuoteAdapterModule.class}/*,dependencies = {AppComponent.class}*/)
public interface HomeComponent {
   // QuoteAdapter getQuoteAdapter();
    void Inject(HomeActivity homeActivity);
}
