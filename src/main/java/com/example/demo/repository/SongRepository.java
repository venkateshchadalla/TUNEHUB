package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.entities.Users;

public interface SongRepository extends JpaRepository<Song, Integer> {

	public Song findByName(String name);

	//public Users findByEmail(String email);
}
