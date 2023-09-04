package com.example.ludotecatanback.game;

import com.example.ludotecatanback.game.model.Game;
import com.example.ludotecatanback.game.model.GameDto;

import java.util.List;

public interface GameService {

    List<Game> find(String title, Long idCategory);
    void save(Long id, GameDto dto);
}
