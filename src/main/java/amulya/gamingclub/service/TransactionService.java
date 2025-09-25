package amulya.gamingclub.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amulya.gamingclub.Dtos.PlayGameDto;
import amulya.gamingclub.entities.Game;
import amulya.gamingclub.entities.Member;
import amulya.gamingclub.entities.Transaction;
import amulya.gamingclub.repository.GameRepository;
import amulya.gamingclub.repository.MemeberRepository;
import amulya.gamingclub.repository.TransactionRepository;

@Service
public class TransactionService {
   @Autowired TransactionRepository transactionRepository;
   @Autowired GameRepository gameRepo;
   @Autowired MemeberRepository memberRepo;
   
   public Transaction playGame(PlayGameDto gameDto) {
	   Member member = memberRepo.findById(gameDto.getMember_id()).get();
	   Game game = gameRepo.findById(gameDto.getGame_id()).get();
	   
	   Transaction transaction = new Transaction();
	   transaction.setMember(member);
	   transaction.setDateTime(LocalDateTime.now());
	   transaction.setAmount(game.getAmount());
	   transaction.setGames(game);
	   transactionRepository.save(transaction);
	   
	   member.setBalance(member.getBalance() - game.getAmount());
	   memberRepo.save(member);
	   
	   return transaction;
   }
}
