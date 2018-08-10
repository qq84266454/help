package com.huatec.helpcircledemo.model;



import com.huatec.helpcircledemo.data.Song;

import java.util.List;

/**
 * 本地视图的接口
 */
public interface LocalIView {


    interface LocalMusic{
        //获取本地歌曲
        void getLocalMusic(List<Song> songs);
    }

    interface LocalAlbum{
        void getLocalAlbum(List<String> albums);
    }


}
