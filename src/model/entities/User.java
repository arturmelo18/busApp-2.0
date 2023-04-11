package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {

	private Integer id;
	private String name;
	private String email;
	private Integer password;

	Scanner sc = new Scanner(System.in);

	List<User> users = new ArrayList<>();

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
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
	}

	public List<User> getUsers() {
		return users;
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
