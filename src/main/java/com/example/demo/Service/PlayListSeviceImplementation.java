package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PlayList;
import com.example.demo.repository.PlayListRepository;

@Service
public class PlayListSeviceImplementation implements PlayLIstSevice{
    @Autowired
	PlayListRepository playRepo;
	@Override
	public void addPlayList(PlayList playList) {

		playRepo.save(playList);
	}
	@Override
	public List<PlayList> fetchAllPlayList() {
		return playRepo.findAll();
	}

}
