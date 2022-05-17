package com.example.nationinfo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountryAsyncTask extends AsyncTask<List<Country>,List<Country>,List<Country>> {
    private Activity activity;



    public CountryAsyncTask(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected List<Country> doInBackground(List<Country>... lists) {
        return getData();
    }

    private List<Country> getData() {
        List<Country> countryList = new ArrayList<>();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(localeVN);

        URL url = null;
        try {

            url = new URL("http://api.geonames.org/countryInfoJSON?username=texward");
            Log.d("AAA",url.toString());
            InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
            Log.d("AAA","OKe");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            bufferedReader.close();
            JSONArray jsonArray = new JSONObject(builder.toString()).getJSONArray("geonames");
           //   total = jsonArray.length();
           //  Log.d("CCC","total: "+total+"");
            for (int i =0; i< 10;i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String countrycode = jsonObject.getString("countryCode");
                Bitmap Logo = BitmapFactory.decodeStream(new URL("http://img.geonames.org/flags/x/" + countrycode.toLowerCase() + ".gif").openStream());
               // Bitmap map = BitmapFactory.decodeStream(new URL("http://img.geonames.org/flags/x/" + countrycode.toLowerCase() + ".gif").openStream());

                  Bitmap map = BitmapFactory.decodeStream(new URL("http://img.geonames.org/img/country/250/" + countrycode + ".png").openStream());
                String countryName = jsonObject.getString("countryName");

                String population = numberFormat.format(jsonObject.getLong("population"));
                String areaInSqKm = numberFormat.format(jsonObject.getDouble("areaInSqKm"));
                Country country = new Country(Logo,map,countryName,population,areaInSqKm);

                countryList.add(country);
                publishProgress(countryList);

            }
            return countryList;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("AAA",e.toString());
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countryList;
    }

    @Override
    protected void onProgressUpdate(List<Country>... values) {
        super.onProgressUpdate(values);


    }

    @Override
    protected void onPostExecute(List<Country> countries) {
        super.onPostExecute(countries);
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recycleview);
        AdapterCountry countryAdapter = new AdapterCountry(countries,activity);
        recyclerView.setAdapter(countryAdapter);

    }
}