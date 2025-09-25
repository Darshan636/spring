package amulya.gamingclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amulya.gamingclub.entities.Member;

@Repository
public interface MemeberRepository   extends JpaRepository<Member, Integer>{
   Member findMemberByPhone(String phone);
}
