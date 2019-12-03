package vn.edu.usth.usthweathernew;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private File file;
    private String filename = "mikrokomos.mp3";
    private String filepath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        Log.i(TAG, "This is onCreate");

        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        adapter.setResource(getApplicationContext());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setPageMargin(15);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        
        filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/vn.edu.usth.usthweathernew/files/";
        writeExternal();
        MediaPlayer mediaPlayer= new MediaPlayer();
        try {
            mediaPlayer.setDataSource(filepath+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
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
