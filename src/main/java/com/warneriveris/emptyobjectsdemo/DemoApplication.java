package com.warneriveris.emptyobjectsdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AlbumRepo repository) {
		return (args) -> {
			// Create Album and save it to the repository
			String albumTitle = "The Sick, the Dying... and the Dead!";
			repository.save(new Album("Megadeth", albumTitle));

			// Retrieve the album from the repository, but return an empty object if the album is not found
			var emptyAlbum = new Album("", ""); // empty object

			Optional<Album> savedAlbum = repository.findByTitle(albumTitle);
			System.out.println(savedAlbum.orElse(emptyAlbum));

			// Try to retrieve an album that does not exist and test that the emptyAlbum is returned instead
			Optional<Album> nonExistentAlbum = repository.findByTitle("Fake Album Title");
			System.out.println(nonExistentAlbum.orElse(emptyAlbum));
		};
	}
}
