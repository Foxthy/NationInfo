package com.example.nationinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//    boolean isloading = false;
//    boolean isLastPage = false;
//    public int current = 0;
//    int total;
//    List<Country> mlistCountry;
//    AdapterCountry countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        CountryAsyncTask countryAsyncTask = new CountryAsyncTask(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        countryAsyncTask.execute();




//        recyclerView.addOnScrollListener(new ScrollListenr(layoutManager) {
//            @Override
//            public void loadMoreItem() {
//                isloading =true;
//                current +=10;
//                loadNextPage(countries);
//            }
//
//            @Override
//            public boolean isloading() {
//                return isloading;
//            }
//
//            @Override
//            public boolean isLastPage() {
//                return isLastPage;
//            }
//        });
//
//    }
//
//    private void loadNextPage(List<Country> countries) {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                List<Country> list = ;
//                countries.addAll(list);
//                countryAdapter.notifyDataSetChanged();
//
//                isloading = false;
//                if (current == total) isLastPage = true;
//                Log.d("CCC","current: "+current+"");
//            }
//        }, 2000);
//
//
    }


}
