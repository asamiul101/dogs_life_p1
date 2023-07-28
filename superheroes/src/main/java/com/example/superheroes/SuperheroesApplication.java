package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	@Autowired
	HeroRepository heroRepository;
	public static void main(String[] args) {

		SpringApplication.run(SuperheroesApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		List<Hero> heroes = heroRepository.findAll();
		for (Hero hero: heroes) {
			System.out.println(hero);
		}

		List<Hero> heroes2 = heroRepository.findTop3ByOrderByNameDesc();
		for (Hero hero: heroes2) {
			System.out.println(hero);
		}

		List<Hero> heroes3 = heroRepository.findHeroesNameStartingWithLetter("C%");
		for (Hero hero: heroes3) {
			System.out.println(hero);
		}
	}
}
