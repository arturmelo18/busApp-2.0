package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import db.DB;

public class User {

	Connection conn = null;
	PreparedStatement pst = null;

	private Integer id;
	private String name;
	private String email;
	private Integer password;

	public User(Integer id, String name, String email, Integer password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	public String toString() {
		return "User name: " + name + ". User email" + email;
	}
}
