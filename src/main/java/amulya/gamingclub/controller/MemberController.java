package amulya.gamingclub.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amulya.gamingclub.Dtos.MembershipDto;
import amulya.gamingclub.entities.Member;
import amulya.gamingclub.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
     @Autowired MemberService memberService;
     
   @PostMapping("/create")
   public Member membership(@RequestBody MembershipDto member) {
	   return memberService.createMembership(member);
   }
   
   @GetMapping("/all")
   public List<Member> getAll(){
	   return memberService.getAllMembers();
   }
   
   @GetMapping("/search/{phone}")
   public Map<String, Object> search(@PathVariable String phone){
	   return memberService.searchMember(phone);
   }
   
}