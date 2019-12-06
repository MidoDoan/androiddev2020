package vn.edu.usth.usthweathernew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

//import android.support.design.widget.TabLayout;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    HomeFragmentPagerAdapter adapter;
    ViewPager pager;
    private File file;
    private String filename = "mikrokomos.mp3";
    private String filepath;

    URL url;

    {
        try {
            url = new URL("https://ictlab.usth.edu.vn/wp-content/uploads/logos/usth.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        Log.i(TAG, "This is onCreate");

        adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        adapter.setResource(getApplicationContext());
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setPageMargin(15);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);


        filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/vn.edu.usth.usthweathernew/files/";
        writeExternal();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mikrokomos);
//        try {
//            mediaPlayer.setDataSource(filepath+filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mediaPlayer.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_button:
                AsyncTask<String,Integer,Bitmap> task = new AsyncTask<String,Integer,Bitmap>() {
                    Bitmap bitmap;
                    HttpURLConnection connection;
                    @Override
                    protected Bitmap doInBackground(String... strings) {
                        try {
                            Thread.sleep(2000);
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setDoInput(true);
                            connection.connect();
                            int response = connection.getResponseCode();
                            Log.i("USTHWeather", "The response is: " + response);
                            InputStream is = connection.getInputStream();
                            bitmap = BitmapFactory.decodeStream(is);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        connection.disconnect();
                        return bitmap;
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        Toast.makeText(getApplicationContext(),"Refresh", Toast.LENGTH_SHORT).show();
                        for(int i=0;i<3;i++){
                        WeatherAndForecastFragment weatherAndForecastFragment = (WeatherAndForecastFragment) adapter.instantiateItem(pager, i);
                        ForecastFragment forecastFragment = (ForecastFragment) weatherAndForecastFragment.getChildFragmentManager().findFragmentById(R.id.scroll);
                        ImageView logo = (ImageView) forecastFragment.getView().findViewById(R.id.symbol);
                        logo.setImageBitmap(bitmap);
                        }

                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                    }

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }

                };
                task.execute();
                return true;
            case R.id.action_setting:
                startActivity(new Intent(WeatherActivity.this, PrefActivity.class));
                return true;
            default:
                super.onOptionsItemSelected(item);
                return false;
        }

    }


    private void writeExternal() {
        try {
            InputStream is = getApplicationContext().getResources().openRawResource(R.raw.mikrokomos);
            file = new File(filepath + filename);
            file.createNewFile();
            OutputStream fout = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            while (true) {
                int bytesRead = is.read(buffer);
                if (bytesRead == -1)
                    break;
                fout.write(buffer, 0, bytesRead);
            }
            fout.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "This is onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "This is onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "This is onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "This is onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "This is onResume");
    }
}
