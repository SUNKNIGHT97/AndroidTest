package com.minminaya.mediaservice;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.minminaya.mediaservice.service.MediaService;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler mHandler = new Handler();

    private static final String TAG = "MainActivity";
    private MediaService.MyBinder mMyBinder;
    private Button playButton;
    private Button nextButton;
    private Button preciousButton;
    private SeekBar mSeekBar;
    private TextView mTextView;
    //表示当前进度文字
    private SimpleDateFormat time = new SimpleDateFormat("m:ss");
    //“绑定”服务的intent
    Intent MediaServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        MediaServiceIntent = new Intent(this, MediaService.class);


        //判断权限
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        } else {
            //设置路径，准备播放
            bindService(MediaServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
        }
    }

    //获取到权限回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[]permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    bindService(MediaServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
                } else {
                    Toast.makeText(this, "无相应权限，程序将退出", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMyBinder = (MediaService.MyBinder) service;
            mSeekBar.setMax(mMyBinder.getProgress());

            mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //这里很重要，如果不判断是否来自用户操作进度条，会不断执行下面语句块里面的逻辑，然后就会卡顿卡顿
                    //判断是否为用户操作
                    if(fromUser){
                        mMyBinder.seekToPositon(seekBar.getProgress());
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            mHandler.post(mRunnable);

            Log.d(TAG, "Service与Activity已连接");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private void iniView() {
        playButton = (Button) findViewById(R.id.play);
        nextButton = (Button) findViewById(R.id.next);
        preciousButton = (Button) findViewById(R.id.precious);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mTextView = (TextView) findViewById(R.id.text1);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        preciousButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                mMyBinder.playMusic();
                break;
            case R.id.next:
                mMyBinder.nextMusic();
                break;
            case R.id.precious:
                mMyBinder.preciousMusic();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //我们的handler发送是定时1000s发送的，如果不关闭，MediaPlayer release掉了还在获取getCurrentPosition就会爆IllegalStateException错误
        //防止报IllegalStateException错误
        mHandler.removeCallbacks(mRunnable);

        mMyBinder.closeMedia();
        unbindService(mServiceConnection);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mSeekBar.setProgress(mMyBinder.getPlayPosition());
            mTextView.setText(time.format(mMyBinder.getPlayPosition()) + "s");
            mHandler.postDelayed(mRunnable, 1000);
        }
    };

}
