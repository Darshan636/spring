package amulya.gamingclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amulya.gamingclub.Dtos.PlayGameDto;
import amulya.gamingclub.entities.Transaction;
import amulya.gamingclub.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired TransactionService transactionService;
	
	@PostMapping("/play")
	public Transaction play(@RequestBody PlayGameDto gameDto) {
		return transactionService.playGame(gameDto);
	}
}
