package com.ekene.simplespringbootproject.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AppuserService {
    private final AppuserRepo appuserRepo;
    public AppUser CreateUser(AppUser appUser){
        appUser.setViews(0);
        return appuserRepo.save(appUser);
    }
    public List<AppUser> getAllUser(int limit){
        Pageable allowedpage =  PageRequest.of(0,limit);
        Page<AppUser> allusers = appuserRepo.findAll(allowedpage);
        return allusers.toList();
    }
    public Optional<AppUser> getadduserbyname(String email){
        AppUser appUser =  appuserRepo.findByemail(email).orElseThrow(
                ()-> new IllegalStateException("user not found"));
        Integer count = appUser.getViews();
        count++;
        appuserRepo.upadateviews(count,appUser.getEmail());
        return appuserRepo.findByemail(email);

    }

    public AppUser Update(Integer id,Request request) {
        AppUser appUser = appuserRepo.findById(id)
                .orElseThrow(()-> new IllegalStateException("user with id not found"));
        appUser.setFirstname(request.getFirstname());
        appUser.setLastname(request.getLastname());
        appUser.setEmail(request.getEmail());
        return appuserRepo.save(appUser);

    }

    public void delete(Integer id) {
        AppUser appUser = appuserRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("user not found"));
        appuserRepo.delete(appUser);
    }
}
