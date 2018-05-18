package pl.dawidbronczak.spring.schoolRegistry.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import pl.dawidbronczak.spring.schoolRegistry.annotation.PasswordMatcher;

@PasswordMatcher
public class UserDTO {
	
	@NotEmpty
	@Size(min = 3, max = 30)
	private String firstname;
	
	@NotEmpty
	@Size(min = 3, max = 30)
	private String lastname;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String passwordConfirm;
	
	public UserDTO() {
		super();
	}

	public UserDTO(@NotEmpty @Size(min = 3, max = 30) String firstname,
			@NotEmpty @Size(min = 3, max = 30) String lastname, @NotEmpty @Email String email,
			@NotEmpty String password, @NotEmpty String passwordConfirm) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
