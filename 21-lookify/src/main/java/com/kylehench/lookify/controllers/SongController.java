package com.kylehench.lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.lookify.models.Song;
import com.kylehench.lookify.services.SongService;

@Controller
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
    private SongService service;
    
    // view songs
    @GetMapping
    public String viewAll(HttpSession session, Model model) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	// add songs
    	List<Song> songs = service.readAll();
    	model.addAttribute("songs", songs);
    	return "songs.jsp";
    }
    
    // view song
    @GetMapping("/{id}")
    public String view(@PathVariable("id") long id, HttpSession session, Model model) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	Song song = service.read(id);
    	model.addAttribute("song", song);
    	return "songs_id.jsp";
    }
    
	// new song
    @GetMapping("/new")
    public String nouveau(@ModelAttribute("newSong") Song newSong, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	return "songs_new.jsp";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result,
    		HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	if (result.hasErrors()) return "songs_new.jsp";
    	service.create(newSong);
    	return "redirect:/songs";
    }
    
    // edit song
    @GetMapping("/{id}/edit")
    public String edit(HttpSession session, Model model, @PathVariable("id") long id) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	Song song = service.read(id);
    	model.addAttribute("song", song);
    	return "songs_edit.jsp";
    }
    @PutMapping("/update")
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result,
    		HttpSession session, Model model) {
    	if (result.hasErrors()) return "songs_edit.jsp";
    	service.update(song);
    	return "redirect:/songs";
    }

    // destroy song
    @GetMapping("/{id}/destroy")
    public String destroy(@PathVariable("id") long id, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	service.delete(id);
    	return "redirect:/songs";
    }
    
    // search song by artist
    @PostMapping("/search")
    public String searchArtist(HttpSession session, Model model,
    		@RequestParam("artist") String artist) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	List<Song> songs = service.readByArtist(artist);
    	model.addAttribute("songs", songs);
    	model.addAttribute("searchArtist", artist);
    	return "songs_search_artist.jsp";
    }
    
    // get top 10
    @GetMapping("/top")
    public String top(HttpSession session, Model model) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	model.addAttribute("topSongs", service.topTen());
    	return "songs_top.jsp";
    }
}
