package com.gmmustafa.rxjava.typefitApi;

import com.gmmustafa.rxjava.models.Quote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QuoteAPI {
    @GET("quotes")
    Observable<List<Quote>> getQuotesData();
}
