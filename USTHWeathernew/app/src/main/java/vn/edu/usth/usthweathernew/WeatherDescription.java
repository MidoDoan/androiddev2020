package vn.edu.usth.usthweathernew;

import android.content.Context;
import android.content.res.TypedArray;

public class WeatherDescription {
    Context context;
    int[] imageArray;

    public void setResource(Context context) {
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    String[] weather;

    public void setWeather() {
        weather = getContext().getResources().getStringArray(R.array.weather_description);
    }

    public void setImageArr() {
        TypedArray tArray = getContext().getResources().obtainTypedArray(R.array.weather_icon);
        int count = tArray.length();
        imageArray = new int[count];
        for (int i = 0; i < imageArray.length; i++) {
            imageArray[i] = tArray.getResourceId(i, 0);
        }
        tArray.recycle();
    }

    public int[] getImageArray() {
        return imageArray;
    }

    public String[] getWeather() {
        return weather;
    }

    public int getImageId(int rInt) {
        return imageArray[rInt];
    }

    public String getWeather(int rInt) {
        return weather[rInt];
    }

    public String getTemperatureRange(int rInt) {
        String temp = (10 + rInt) + "\u00B0C" + " - " + (20 + rInt) + "\u00B0C";
        if (weather[rInt].toLowerCase().contains(getContext().getString(R.string.snow)))
            temp = "5\u00B0C - 7\u00B0C";
        return temp;
    }

    public String getTemperature(int rInt) {
        String temp = (10 + rInt) + "\u00B0C";
        if (weather[rInt].toLowerCase().contains(getContext().getString(R.string.snow)))
            temp = "5\u00B0C";
        return temp;
    }
}
