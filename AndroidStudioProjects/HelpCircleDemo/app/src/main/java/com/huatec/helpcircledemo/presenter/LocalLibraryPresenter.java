package com.huatec.helpcircledemo.presenter;

import android.content.Context;
import android.util.Log;

import com.huatec.helpcircledemo.data.Song;
import com.huatec.helpcircledemo.model.LocalIView;
import com.huatec.helpcircledemo.utils.LocalMusicLibrary;


import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * presenter层进行调用Model
 */
public class LocalLibraryPresenter {

    private LocalIView.LocalMusic mLocalMusic;

    private Context mContext;


    public LocalLibraryPresenter(LocalIView.LocalMusic localMusic, Context context) {
        this.mLocalMusic = localMusic;
        this.mContext = context;
    }

    /***
     * 请求获取本地歌曲
     */
    public void requestMusic(){
        Observable.create(
                new Observable.OnSubscribe<List<Song>>() {

                    @Override
                    public void call(Subscriber<? super List<Song>> subscriber) {
                        List<Song> songs = LocalMusicLibrary.getAllSongs(mContext);
                        Log.e("test",songs.size()+"");
                        subscriber.onNext(songs);
                    }
                }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Song>>() {
                    @Override
                    public void call(List<Song> songs) {
                        if (mLocalMusic != null)
                            mLocalMusic.getLocalMusic(songs);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("call: ", "call: "+throwable.toString());
                    }
                });
    }

}
