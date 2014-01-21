package com.js.dto;

public class ChangePassword {
	private String username;
	private String dialog_current_password;
	private String dialog_new_password;
	
	public ChangePassword(String username, String dialog_current_password,
			String dialog_new_password) {
		super();
		this.username = username;
		this.dialog_current_password = dialog_current_password;
		this.dialog_new_password = dialog_new_password;
	}
	
	public ChangePassword() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDialog_current_password() {
		return dialog_current_password;
	}

	public void setDialog_current_password(String dialog_current_password) {
		this.dialog_current_password = dialog_current_password;
	}

	public String getDialog_new_password() {
		return dialog_new_password;
	}

	public void setDialog_new_password(String dialog_new_password) {
		this.dialog_new_password = dialog_new_password;
	} 
	
}
