package com.kylehench.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min = 2, max = 255, message="Name must be between 2 and 255 characters.")
	private String name;
	
	// created at and updated at
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	
	// relationship with Ninja
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninja> ninja;

	public Dojo() {}
	
	public Dojo(String name, List<Ninja> ninja) {
		this.name = name;
		this.ninja = ninja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public List<Ninja> getNinja() {
		return ninja;
	}

	public void setNinja(List<Ninja> ninja) {
		this.ninja = ninja;
	}

	@PrePersist
	protected void onCreate(){
	    this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updated_at = new Date();
	}

}
