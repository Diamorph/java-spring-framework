package com.diamorph.datingapi.controllers;

import com.diamorph.datingapi.entities.Interest;
import com.diamorph.datingapi.entities.UserAccount;
import com.diamorph.datingapi.exeptions.UserAccountNotFound;
import com.diamorph.datingapi.repositories.InterestRepository;
import com.diamorph.datingapi.repositories.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserAccountController {

    private UserAccountRepository userAccountRepository;
    private InterestRepository interestRepository;

    @PostMapping("/users/register-user")
    public UserAccount registerUser(@RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }


    @PostMapping("/interest/update")
    public Interest updateInterest(@RequestBody Interest interest) {
        int userAccountId = interest.getUserAccountId();
        UserAccount userAccount = userAccountRepository.findById(userAccountId).orElse(null);
        if (null == userAccount) {
            throw new UserAccountNotFound("User account not found, id: " + userAccountId);
        }
        interest.setUserAccount(userAccount);
        return interestRepository.save(interest);
    }

    @GetMapping("/users/get/all")
    public List<UserAccount> getUsers() {
        return userAccountRepository.findAll();
    }

    @DeleteMapping("/interest/delete/{id}")
    public void deleteInterest(@PathVariable("id") int id) {
        interestRepository.deleteById(id);
    }

    @GetMapping("/users/matches/{id}")
    public List<UserAccount> findMatches(@PathVariable("id") int id) {
        UserAccount userAccount = userAccountRepository.findById(id).orElse(null);
        if (null == userAccount) {
            throw new UserAccountNotFound("User account not found, id: " + id);
        }
        return userAccountRepository.findMatches(
            userAccount.getAge(),
            userAccount.getCity(),
            userAccount.getCountry(),
            userAccount.getId()
        );
    }


}
