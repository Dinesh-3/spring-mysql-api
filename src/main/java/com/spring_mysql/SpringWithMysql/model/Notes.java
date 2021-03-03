package com.spring_mysql.SpringWithMysql.model;

import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter
@Setter
public class Notes {

	@Id
	@GeneratedValue
	public int id;

    public String title;
    public String description;
    public String createdAt;
    public String updatedAt;
    public Boolean status;
    public Boolean modified;
	
	public Notes(String title, String description) {
        super();
		this.title = title;
		this.description = description;
        this.createdAt = this.getCurrentDate();
        this.updatedAt = this.getCurrentDate();
        this.status = false;
        this.modified = false;

	}
    public Notes () {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCurrentDate(){
        return LocalDateTime.now().toString();
    }

    public void setModified() {
        this.modified = true;
        this.updatedAt = this.getCurrentDate();
    }
}

