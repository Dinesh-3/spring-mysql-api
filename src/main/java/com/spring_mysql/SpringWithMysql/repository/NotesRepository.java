package com.spring_mysql.SpringWithMysql.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring_mysql.SpringWithMysql.model.Notes;

public interface NotesRepository extends CrudRepository<Notes,Integer>{
    
}

