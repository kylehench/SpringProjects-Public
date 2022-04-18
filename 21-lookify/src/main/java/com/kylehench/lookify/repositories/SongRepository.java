package com.kylehench.lookify.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kylehench.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	// this method retrieves all the songs from the database
    List<Song> findAll();
    
    // search by artist
    List<Song> findByArtistContaining(@Param("artist") String artist);
    
    @Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true) 
	List<Song> getTopTen();
}