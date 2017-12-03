package chapter3.pojo;

import java.io.Serializable;

public class Role implements Serializable  {

	private static final long serialVersionUID = 1098321123L;
	
	private int id ;  //主键
	
	private String username ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
