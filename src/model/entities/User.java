package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import model.exception.UserException;

public class User {

	private String name;
	private String email;
	private Integer password;

	Scanner sc = new Scanner(System.in);

	List<User> users = new ArrayList<>();

	public User(String name, String email, Integer password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Speak your password");
		int p = sc.nextInt();
		User u = new User(null, null, p);
		if (getPassword().hashCode() != u.getPassword().hashCode()) {
			throw new UserException("Passwords do not match");
		} else {
			this.name = name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Speak your password");
		int p = sc.nextInt();
		User u = new User(null, null, p);
		if (getPassword().hashCode() != u.getPassword().hashCode()) {
			throw new UserException("Passwords do not match");
		} else {
			this.email = email;
		}
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		System.out.println("Speak your password");
		int p = sc.nextInt();
		User u = new User(null, null, p);
		if (getPassword().hashCode() != u.getPassword().hashCode()) {
			throw new UserException("Passwords do not match");
		} else {
			this.password = password;
		}
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
