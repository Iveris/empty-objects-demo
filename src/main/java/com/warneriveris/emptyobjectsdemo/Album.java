package com.warneriveris.emptyobjectsdemo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String artist;
    private String title;

    public Album(String artist, String title){
        setArtist(artist);
        setTitle(title);
    }

    @Override
    public String toString(){
        return String.format("%s\t\t%s", getArtist(), getTitle());
    }
}
