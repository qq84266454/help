package com.huatec.helpcircledemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huatec.helpcircledemo.BaseActivity;
import com.huatec.helpcircledemo.R;
import com.huatec.helpcircledemo.adapter.LocalRecyclerAdapter;
import com.huatec.helpcircledemo.adapter.OnItemClickListener;
import com.huatec.helpcircledemo.data.Song;
import com.huatec.helpcircledemo.model.LocalIView;
import com.huatec.helpcircledemo.music.MusicPlaylist;
import com.huatec.helpcircledemo.presenter.LocalLibraryPresenter;
import com.huatec.helpcircledemo.service.MusicPlayerManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalMusicActivity extends BaseActivity implements LocalIView.LocalMusic {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private MusicPlaylist musicPlayList;
    private LocalLibraryPresenter mLibraryPresenter;
    private LocalRecyclerAdapter mRecyclerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);
        ButterKnife.bind(this);
        mLibraryPresenter = new LocalLibraryPresenter(this, this);
        musicPlayList = new MusicPlaylist();
        mRecyclerAdapter = new LocalRecyclerAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Object item, int position) {
                Log.e("onItemClick: ", "onItemClick: ");
                MusicPlayerManager.get().playQueue(musicPlayList, position);
                gotoSongPlayerActivity();

            }

            @Override
            public void onItemSettingClick(View v, Object item, int position) {

            }
        });
        mLibraryPresenter.requestMusic();
    }

    @Override
    public void getLocalMusic(List<Song> songs) {
        musicPlayList.setQueue(songs);
        musicPlayList.setTitle("本地歌曲");
        mRecyclerAdapter.setData(songs);
    }

    public boolean gotoSongPlayerActivity() {
        if (MusicPlayerManager.get().getPlayingSong() == null) {
            showToast(R.string.music_playing_none);
            return false;
        }
        PlayingActivity.open(this);
        return true;
    }

    private void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

}
