package chapter17;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID=69773164131L;
	private int id;
	private String username;
	//private String note;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	 


	/*public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
