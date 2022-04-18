package com.kylehench.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.lookify.models.Song;
import com.kylehench.lookify.repositories.SongRepository;

@Service
public class SongService {
		
	@Autowired
	private SongRepository repository;
	
	// create
    public Song create(Song newObject) {
        newObject.setId(null);
    	return repository.save(newObject);
    }
    
    // read
    public Song read(Long id) {
        Optional<Song> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Song> readAll() {
        return repository.findAll();
    }
    // update
    public Song update(Song object) {
    	return repository.save(object);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Song> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
	// search by artist name
	public List<Song> readByArtist(String artist) {
		return repository.findByArtistContaining(artist);
	}
	// get top 10 songs
	public List<Song> topTen() {
		return repository.getTopTen();
	}
}