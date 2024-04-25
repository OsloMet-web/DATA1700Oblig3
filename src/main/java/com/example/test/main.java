package com.example.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class main {



    @PostMapping("/Lagre")
    public void lagreBillett(Billett billett) throws SQLException {
        Database.leggInn(billett);
    }

    @GetMapping("/hentAlle")
    public List<Billett> hentAlle() throws SQLException {
        return Database.hent();
    }

    @GetMapping("/Slett")
    public void slett() throws SQLException {
        Database.slett();

    }





}
