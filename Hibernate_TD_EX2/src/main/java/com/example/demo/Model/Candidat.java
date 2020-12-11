package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.sun.istack.NotNull;

@Entity
public class Candidat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
@NotNull
String nom;
@NotNull
String prenom;
@NotNull
String adresse;
@NotNull
String tel;
@NotNull
int age;

@ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "candidats")
private Set<Candidat> posts = new HashSet<>();
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel
			+ ", age=" + age + "]";
}



}
