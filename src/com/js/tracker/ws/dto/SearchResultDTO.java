package com.js.tracker.ws.dto;

import java.util.List;
import java.util.Map;

public class SearchResultDTO {	
	String username;
	String totalhours;
	String noDays;
	List<UserDateWiseDTO>list;
	
	public String getNoDays() {
		return noDays;
	}
	public void setNoDays(String noDays) {
		this.noDays = noDays;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTotalhours() {
		return totalhours;
	}
	public void setTotalhours(String totalhours) {
		this.totalhours = totalhours;
	}
	public List<UserDateWiseDTO> getList() {
		return list;
	}
	public void setList(List<UserDateWiseDTO> list) {
		this.list = list;
		if(list!=null){
			this.noDays=""+list.size();
		}else {
			this.noDays="0";
		}
		
	}
	
}