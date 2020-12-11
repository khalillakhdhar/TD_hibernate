package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.Model.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

@Entity
public class Formation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
@NotNull
String titre;
@Column(nullable = true,length = 100)
String description;
@Column(nullable = false,unique = true,length = 30)
String formateur;
@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
})
@JoinTable(name = "formation_candidat",
joinColumns = { @JoinColumn(name = "formation_id") },
inverseJoinColumns = { @JoinColumn(name = "candidat_id") })
private Set<Candidat> tags = new HashSet<>();

private Candidat candidats;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getFormateur() {
	return formateur;
}
public void setFormateur(String formateur) {
	this.formateur = formateur;
}


public Set<Candidat> getTags() {
	return tags;
}
public void setTags(Set<Candidat> tags) {
	this.tags = tags;
}
public Candidat getCandidats() {
	return candidats;
}
public void setCandidats(Candidat candidats) {
	this.candidats = candidats;
}
@Override
public String toString() {
	return "Formation [id=" + id + ", titre=" + titre + ", description=" + description + ", formateur=" + formateur
			+ "]";
}






}
