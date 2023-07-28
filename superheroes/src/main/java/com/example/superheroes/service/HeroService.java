package com.example.superheroes.service;

import com.example.superheroes.model.Hero;
import com.example.superheroes.repository.HeroRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @PostConstruct
    public void init(){
        System.out.println("Hero Website has been created!!!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Hero Website will be destroyed");
    }

    public List<Hero> getHeroesStartingWithLetter(String letter){
        String letterParam = letter + "%";
        List<Hero> heroes = heroRepository.findHeroesNameStartingWithLetter(letterParam);
        return heroes;
    }

    public List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

    public List<Hero> getLastThreeHeroesByName(){
        return heroRepository.findTop3ByOrderByNameDesc();
    }

    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }
}
