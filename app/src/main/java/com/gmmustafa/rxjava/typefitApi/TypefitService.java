package com.gmmustafa.rxjava.typefitApi;

import com.gmmustafa.rxjava.models.Quote;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class TypefitService {
    Gson gson;
    Retrofit retrofit;

    public TypefitService(Gson gson, Retrofit retrofit) {
        this.gson = gson;
        this.retrofit = retrofit;
    }

    public Observable<List<Quote>> getQuoteData(){
        QuoteAPI quoteAPI = retrofit.create(QuoteAPI.class);
        return quoteAPI.getQuotesData();
    }
}
