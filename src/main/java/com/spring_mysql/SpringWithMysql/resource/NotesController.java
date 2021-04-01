package com.spring_mysql.SpringWithMysql.resource;

import java.util.*;

import com.spring_mysql.SpringWithMysql.model.Notes;
import com.spring_mysql.SpringWithMysql.repository.NotesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class NotesController {

    @Autowired
    private NotesRepository ticket;

    @PostMapping("/notes")
    public Notes addTicket(@RequestBody Notes t) {
        ticket.save(t);
        return t;
    }

    @GetMapping("/notes")
    public List<Notes> getTickets() {
        List<Notes> allNotes = (List<Notes>) ticket.findAll();
        return allNotes;
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Notes> updateData(@RequestBody Notes note, @PathVariable int id) {

        Notes existData = ticket.findById(id).orElse(null);

        if (existData != null) {
            try {
                existData.setTitle(note.title);
                existData.setDescription(note.description);
                existData.setModified();
            } catch (Exception e) {
                System.err.println(e);
            }
            ticket.save(existData);
        }else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Notes> deleteDataById(@PathVariable int id) {
        ticket.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/notes/{id}")
    public Notes getDataById(@PathVariable int id) {
        return ticket.findById(id).orElse(null);
    }
}
