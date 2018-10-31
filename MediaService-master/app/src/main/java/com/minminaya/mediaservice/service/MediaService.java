package com.minminaya.mediaservice.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class MediaService extends Service {

    private static final String TAG = "MediaService";
    private MyBinder mBinder = new MyBinder();
    //标记当前歌曲的序号
    private int i = 0;
    //歌曲路径
    private String[] musicPath = new String[]{
            Environment.getExternalStorageDirectory().getAbsolutePath() + "/Sounds/a1.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath() + "/Sounds/a2.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath() +  "/Sounds/a3.mp3",
            Environment.getExternalStorageDirectory().getAbsolutePath() +  "/Sounds/a4.mp3"
    };
    //初始化MediaPlayer
    public MediaPlayer mMediaPlayer = new MediaPlayer();


    public MediaService() {
        iniMediaPlayerFile(i);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class MyBinder extends Binder {
        public void playMusic() {
            if (!mMediaPlayer.isPlaying()) {
                //如果未开始播放，start
                mMediaPlayer.start();
            }
            else{
                //如果已开始播放，pause
                mMediaPlayer.pause();
            }
        }
        public void resetMusic() {
            if (!mMediaPlayer.isPlaying()) {
                //如果还没开始播放，就开始
                mMediaPlayer.reset();
                iniMediaPlayerFile(i);
            }
        }
        public void closeMedia() {
            if (mMediaPlayer != null) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
            }
        }
        public void nextMusic() {
            if (mMediaPlayer != null && i < 4 && i >= 0) {
                //切换歌曲reset()很重要很重要很重要，没有会报IllegalStateException
                mMediaPlayer.reset();
                if (i <= 2 && i >= 0) {
                    iniMediaPlayerFile(i + 1);
                } else {
                    iniMediaPlayerFile(0);
                }
                if (i == 3) {
                    i = 0;
                } else {
                    i = i + 1;
                }
                playMusic();
            }
        }
        public void preciousMusic() {
            if (mMediaPlayer != null && i < 4 && i > 0) {
                mMediaPlayer.reset();
                if (i <= 3 && i > 0) {
                    iniMediaPlayerFile(i - 1);
                } else {
                    iniMediaPlayerFile(3);
                }
                if (i == 0) {
                    i = 3;
                } else {
                    i = i - 1;
                }
                playMusic();
            }
        }

        public int getProgress() {

            return mMediaPlayer.getDuration();
        }

        public int getPlayPosition() {

            return mMediaPlayer.getCurrentPosition();
        }

        public void seekToPositon(int msec) {
            mMediaPlayer.seekTo(msec);
        }

    }

    //添加file文件到MediaPlayer对象并且准备播放音频
    private void iniMediaPlayerFile(int dex) {
        //获取文件路径
        try {
            //此处的两个方法需要捕获IO异常
            //设置音频文件到MediaPlayer对象中
            mMediaPlayer.setDataSource(musicPath[dex]);
            //让MediaPlayer对象准备
            mMediaPlayer.prepare();
        } catch (IOException e) {
            Log.d(TAG, "设置资源，准备阶段出错");
            e.printStackTrace();
        }
    }
}
