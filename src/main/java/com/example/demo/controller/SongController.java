package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.SongService;
import com.example.demo.Service.UsersService;
import com.example.demo.entities.Song;

@Controller
public class SongController {
	@Autowired
	SongService service;
	@Autowired
	UsersService users;

	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.songExists(song.getName());
		if (songStatus == false) {
			service.addSong(song);
			System.out.println("song added");
		} else {
			System.out.println("song already exist");
		}
		return "adminHome";
	}

	@GetMapping("/viewsong")
	public String viewSongs(Model mod) {

		// List<Song> songsList = service.fetchAllSongs();
		mod.addAttribute("songs", service.fetchAllSongs());
		// System.out.println(songsList);
		return "displaySongs";
	}
	
	@GetMapping("/playsong")
	public String playsong(Model mod) {
		
//		boolean premiumUser=false;
//		if(premiumUser==true)
//		{
		mod.addAttribute("songs", service.fetchAllSongs());
		return "displaySongs";
//		}
//		else
//		{
//			return "makepayment";
//		}
		
	}

}
