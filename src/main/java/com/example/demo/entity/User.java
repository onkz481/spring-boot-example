package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter @Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 100 /*, unique = false, updatable = true, insertable = false, columnDefinition = "text"*/)
	private String name;
	
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name = "created_at", nullable = true, updatable = false, insertable = false, columnDefinition = "DATETIME")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", nullable = true, updatable = false, insertable = false, columnDefinition = "DATETIME")
	private LocalDateTime updatedAt;
	
	
	public User() {
	}
	
	public User(String name, String email) {
		this();
		
		this.name = name;
		this.email = email;
	}
}
