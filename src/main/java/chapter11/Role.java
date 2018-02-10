package chapter11;

import org.springframework.stereotype.Component;

@Component
public class Role {

	private int id;
	private String rolename;
	private String note;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
