package com.weijun.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Product product;

    @Inject
    Factory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerFactoryActivityComponent.create().inject(this);
        Log.e("test", product.hashCode() + "");
        Log.e("test", factory.hashCode() + ":"+ factory.product.hashCode());
    }
}
