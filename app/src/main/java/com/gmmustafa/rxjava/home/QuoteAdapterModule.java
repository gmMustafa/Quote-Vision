package com.gmmustafa.rxjava.home;

import com.gmmustafa.rxjava.models.Quote;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class QuoteAdapterModule {
    List<Quote> data;

    public QuoteAdapterModule(List<Quote> data) {
        this.data = data;
    }

    @Provides
    QuoteAdapter providesquoteAdapter() {
        return new QuoteAdapter(data);
    }

    ;
}
