package com.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Idea;

public interface IdeaRepo extends JpaRepository< Idea, Integer>{

}
