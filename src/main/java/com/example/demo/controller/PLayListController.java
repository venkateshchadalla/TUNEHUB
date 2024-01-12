package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.PlayLIstSevice;
import com.example.demo.Service.SongService;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;

@Controller
public class PLayListController {
	@Autowired
	SongService songService;
	
	@Autowired
	PlayLIstSevice playListService;
	
	@GetMapping("/createPlayLIst")
    public String createPlayList(Model mod)
    {
		List<Song> songList=songService.fetchAllSongs();
		mod.addAttribute("songs",songList);
		return "createPlayList";
    	
    }
	
	@PostMapping("/addPlayList")
    public String addPlayList(@ModelAttribute PlayList playList)
    {
		//updating the play list table
		playListService.addPlayList(playList);
		//updating the play songs table
		List<Song> SongsList=playList.getSongs();
		for(Song s:SongsList)
		{
			s.getPlaylist().add(playList);
			
			songService.updateSong(s);
		}
		return "adminHome";
    }
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model mod) {
		List<PlayList> allPlayLists=playListService.fetchAllPlayList();
		mod.addAttribute("allPlayLists", allPlayLists);
		return "displayPlayLists";
	}
	
}
