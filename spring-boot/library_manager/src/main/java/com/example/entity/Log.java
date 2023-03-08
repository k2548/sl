package com.example.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="logs")
public class Log {
	@Id
	 @SequenceGenerator(name = "LIBRARY_ID_GENERATOR", sequenceName = "LIBRARY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBRARY_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "library_id")
    private Integer libraryId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name="rent_date")
    private LocalDateTime rentDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Column(name="return_to_date")
    private LocalDateTime returnDueDate;

    @ManyToOne
    @JoinColumn(name = "library_id", insertable = false, updatable = false)
    private Library library;

    public Library getLibrary() {
        return this.library;
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(Integer LibraryId) {
        this.libraryId = LibraryId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRentDate(LocalDateTime rentDate) {
    	this.rentDate = rentDate;
    }

    public LocalDateTime getRentDate() {
    	return this.rentDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
    	this.returnDate = returnDate;
    }

    public LocalDateTime getReturnDate() {
    	return this.returnDate;
    }

    public void setReturnDueDate(LocalDateTime returnDueDate) {
    	this.returnDueDate = returnDueDate;
    }

    public LocalDateTime getDate() {
    	return this.returnDueDate;
    }


}
