package com.ekene.simplespringbootproject.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppuserRepoTest {

    @Autowired
    private AppuserRepo appuserRepo;
    @Test
    public void upadate (){
        int count = 0;
        count++;
        appuserRepo.upadateviews(count,"envisn;nininsio;ni");
    }
}