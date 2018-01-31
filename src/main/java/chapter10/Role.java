package chapter10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="role")
public class Role {

	@Value("1")
	private int id;
	
	@Value("总经理")
	private String rolename;
	
	@Value("备注总经理")
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
