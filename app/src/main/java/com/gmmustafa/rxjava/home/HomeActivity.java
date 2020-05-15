package com.gmmustafa.rxjava.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gmmustafa.rxjava.R;
import com.gmmustafa.rxjava.root.App;
import com.gmmustafa.rxjava.models.Quote;
import com.gmmustafa.rxjava.typefitApi.TypefitService;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Inject
    QuoteAdapter quoteAdapter;

    List<Quote> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();


        KProgressHUD kProgressHUD = KProgressHUD.create(HomeActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();


        //Dependency injection
        HomeComponent homeComponent = DaggerHomeComponent.builder()
                .quoteAdapterModule(new QuoteAdapterModule(data))
                .build();
        homeComponent.Inject(this);
        recyclerView.setAdapter(quoteAdapter);

        //simple injection -
        // quoteAdapter = homeComponent.getQuoteAdapter();


        App app = (App) getApplication();
        TypefitService typefitService = app.getTypefitService();

        typefitService.getQuoteData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Quote>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Quote> value) {
                        for (Quote quote : value) {
                            data.add(new Quote(quote.getAuthor(), quote.getText()));
                            quoteAdapter.notifyDataSetChanged();
                        }
                        kProgressHUD.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(HomeActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                        kProgressHUD.dismiss();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
