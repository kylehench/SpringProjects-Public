package com.kylehench.javadojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.javadojooverflow.models.Tag;
import com.kylehench.javadojooverflow.repositories.TagRepository;


@Service
public class TagService {
		
	@Autowired
	private TagRepository repository;
	
	// create
    public Tag create(Tag newTag) {
    	return repository.save(newTag);
    }
    
    // read
    public Tag read(Long id) {
        Optional<Tag> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Tag> readAll() {
        return repository.findAll();
    }
    
    // read by name
    public Tag readByName(String name) {
    	return repository.findByNameIs(name);
    }
    
    // update
    public Tag update(Tag o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Tag> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
	
	// process tags submission
	public ArrayList<Tag> tagsSubmission(String tagsString) {
		// Create a List of Strings using the 'tagsString' String, which contains the tags the user has entered
		String[] tagsArray = tagsString.trim().split(",");
		// Create a new ArrayList that we will populate with individual Tag objects
		ArrayList<Tag> result = new ArrayList<>();
		
		// If we find more than 3 tags, we return null because we can only have up to 3 tags
		if(tagsArray.length>3) return null;
		
		// Using a for loop, we iterate through the 'splitTags' and create new Tag objects for each one that does not exist in our database
		for(String s: tagsArray) {
			// First we remove spaces before and after the tag String and convert the tag to all lower case characters
			s = s.trim().toLowerCase();
			// Continue if empty
			if (s.length()==0) continue;
			// We make sure the Tag object does not exist and that the tag String is at least one character long
			Tag tag = this.readByName(s);
			if(tag==null) {
				// If the Tag object is not found, we add a new Tag object to our result ArrayList and save in database
				Tag newTag = new Tag(s);
				result.add(newTag);
			} else {
				// If the object is found, we simply add it to the result ArrayList
				result.add(tag);
			}
		}
		return result;
	}

}
