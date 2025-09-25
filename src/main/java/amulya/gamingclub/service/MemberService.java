package amulya.gamingclub.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amulya.gamingclub.Dtos.MembershipDto;
import amulya.gamingclub.entities.Collection;
import amulya.gamingclub.entities.Member;
import amulya.gamingclub.entities.Recharge;
import amulya.gamingclub.entities.Transaction;
import amulya.gamingclub.repository.CollectionRepository;
import amulya.gamingclub.repository.MemeberRepository;
import amulya.gamingclub.repository.RechargeRepository;
import amulya.gamingclub.repository.TransactionRepository;

@Service
public class MemberService {
      
	@Autowired private MemeberRepository memberRepository;
	@Autowired private RechargeRepository rechargeRepo;
	@Autowired private CollectionRepository collectionRepo;
	@Autowired private TransactionRepository transactionRepo;
	
	public Member createMembership(MembershipDto memberDto) {
		 Member member = new Member();
		 member.setName(memberDto.getName());
		 member.setBalance(memberDto.getFees());
		 member.setPhone(memberDto.getPhone());
		 memberRepository.save(member);
		 
		 Recharge recharge = new Recharge();
		 recharge.setMember(member);
		 recharge.setAmount(memberDto.getFees());
		 recharge.setDateTime(LocalDateTime.now());
		 rechargeRepo.save(recharge);
		 
		 Optional<Collection> collectionOpt = collectionRepo.findCollectionByDate(LocalDate.now());
		 if(collectionOpt.isPresent()) {
			 Collection collection = collectionOpt.get();
			 collection.setAmount(collection.getAmount() + memberDto.getFees());
			 collectionRepo.save(collection);
		 }else {
			 
			 Collection collection = new Collection();
			 collection.setDate(LocalDate.now());
			 collection.setAmount(memberDto.getFees());
			 collectionRepo.save(collection);
		 }		 
		 return member;		
	}
	
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	
	public Map<String, Object> searchMember(String phone){
		
		Member member = memberRepository.findMemberByPhone(phone);
		
		List<Recharge> recharge = rechargeRepo.findRechargeByMemberId(member.getId());
		List<Transaction> transactions = transactionRepo.findTransactionByMemberId(member.getId());
		
		Map<String, Object> response =  new HashMap<String, Object>();
		response.put("member_details", member);
		response.put("recharge_history", recharge);
		response.put("transaction_history",transactions);
		
		return response;
		
	}
	
	
	
	
	
	
	
}
