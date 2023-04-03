package com.ekene.simplespringbootproject.user;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("ekene.com")
public class AppuserController {
 private AppuserService appuserService;
 @PostMapping("/signup")
    public ResponseEntity<Response> signUp(@RequestBody AppUser appUser){
        return ResponseEntity.ok(Response.builder()
                        .craeatedat(LocalDate.now())
                        .data(Map.of("signed up user",appuserService.CreateUser(appUser)))
                        .status(HttpStatus.CREATED)
                        .statuscode(HttpStatus.CREATED.value())
                .build());
    }
    @GetMapping("/viewall")
    public List<AppUser> getallusers(){
     return appuserService.getAllUser(30);
    }
    @GetMapping("/view/{email}")
    public AppUser getuserbyemail(@PathVariable("email") String email){
     return appuserService.getadduserbyname(email).get();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateusercredentials(@PathVariable("id") Integer id,@RequestBody Request request){
     return ResponseEntity.ok(Response.builder()
                     .craeatedat(LocalDate.now())
                     .status(HttpStatus.CONTINUE)
                     .statuscode(HttpStatus.CONTINUE.value())
                     .data(Map.of("updated user info",appuserService.Update(id,request)))
             .build());
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id ){
     appuserService.delete(id);
     return "user deleted";
    }
}
