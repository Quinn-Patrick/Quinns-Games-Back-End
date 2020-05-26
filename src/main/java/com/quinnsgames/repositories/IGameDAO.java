package com.quinnsgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinnsgames.models.GamePanel;

public interface IGameDAO extends JpaRepository<GamePanel, Integer> {

}
