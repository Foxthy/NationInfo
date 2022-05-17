package com.example.nationinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class Country implements Serializable {
    private   String Logo;
    private   String map;
    private   String countryName;
    private   String population;
    private   String areaInSqKm;



    public Country(Bitmap logo, Bitmap map, String countryName, String population, String areaInSqKm) {
        this.Logo = encodeTobase64(logo);
        this.map = encodeTobase64(map);
        this.countryName = countryName;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
    }

    public Country(String logo, String map, String countryName, String population, String areaInSqKm) {
        Logo = logo;
        this.map = map;
        this.countryName = countryName;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
    }

    public Bitmap getLogobitmap() {
        return decodeBase64(Logo);
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public Bitmap getMapbitmap() {
        return decodeBase64(map);
    }
    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Logo=" + Logo +
                ", map=" + map +
                ", countryName='" + countryName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                '}';
    }
    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.PNG, 90, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
