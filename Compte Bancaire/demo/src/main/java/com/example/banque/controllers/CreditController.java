package com.example.banque.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.entities.Credit;
import com.example.banque.services.CreditService;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getCreditById(@PathVariable Long id) {
        Credit credit = creditService.findById(id);
        if (credit != null) {
            return ResponseEntity.ok(credit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public List<Credit> getAllCredits() {
        return creditService.findAll();
    }

    @PostMapping("")
    public Credit createCredit(@RequestBody Credit credit) {
        return creditService.save(credit);
    }

    @PutMapping("/{id}")
    public Credit updateCredit(@PathVariable("id") Long id, @RequestBody Credit credit) {
        return creditService.save(credit);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable("id") Long id, @RequestBody Credit credit) {
        creditService.delete(credit);
    }
}
