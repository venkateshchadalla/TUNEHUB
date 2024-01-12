package com.example.demo.Service;

import java.util.List;

import com.example.demo.entities.Song;

public interface SongService {

	public void addSong(Song song);
	
	public List<Song> fetchAllSongs();

	public boolean songExists(String name);

	public void updateSong(Song song);

	//public boolean premiumUser(String email);

}
