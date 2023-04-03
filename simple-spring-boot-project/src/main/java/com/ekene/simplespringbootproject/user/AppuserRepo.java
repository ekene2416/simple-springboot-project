package com.ekene.simplespringbootproject.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppuserRepo extends JpaRepository<AppUser, Integer> {


   Optional<AppUser> findByemail(String email);

   @Modifying
   @Transactional
   @Query("update AppUser s set s.views = ?1 where s.email =?2")
    void upadateviews(Integer count, String email);
}
