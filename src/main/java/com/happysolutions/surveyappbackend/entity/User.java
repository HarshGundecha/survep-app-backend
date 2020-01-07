package com.happysolutions.surveyappbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity(name = "myuser")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@UniqueElements
	@Column(nullable=false, unique = true)
	@NotNull
	@NotBlank
	private String username;

	@Column(nullable=false)
	@NotNull
	@NotBlank
	private String name;

	@Column(nullable=false, unique = true)
	@Email
	@NotNull
	@NotBlank
	private String email;

	@Column(nullable=false)
	@NotNull
	@NotBlank
	private String password;

	//@JsonIgnore
	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

	public User(User user, Long followData[]) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
		this.setCreatedAt(user.getCreatedAt());
		this.setUpdatedAt(user.getCreatedAt());
		this.setPassword(user.getPassword());
	}
}