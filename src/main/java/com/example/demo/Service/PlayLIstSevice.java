package com.example.demo.Service;

import java.util.List;

import com.example.demo.entities.PlayList;

public interface PlayLIstSevice {

	public void addPlayList(PlayList playList);

	public List<PlayList> fetchAllPlayList();

}
