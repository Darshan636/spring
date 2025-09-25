package amulya.gamingclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amulya.gamingclub.entities.Game;
import amulya.gamingclub.repository.GameRepository;

@Service
public class GameService {
     
	@Autowired
	private GameRepository gameRepository;
	
	public Game saveGame( Game game) {
		return gameRepository.save(game);
	}
	
	public List<Game> getAllGames(){
		return gameRepository.findAll();
	}
	
	public Game getGame(int id) {
		Optional<Game> existingGame = gameRepository.findById(id);
		if(existingGame.isPresent()) {
			return existingGame.get();
		}
		return null;
	}
	
	
	public Game updateGame(int id, Game game) {
		Optional<Game> existingGame = gameRepository.findById(id);
        if(existingGame.isPresent()) {
        	Game oldGame = existingGame.get();
        	
        	oldGame.setName(game.getName());
        	oldGame.setDescription(game.getDescription());
        	oldGame.setAmount(game.getAmount());
        	return gameRepository.save(oldGame);
        }
        return null;
	}
	
	public boolean deleteGame(int id) {
		Optional<Game> game = gameRepository.findById(id);
		if(game.isPresent()) {
			gameRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
		
	
	
}
