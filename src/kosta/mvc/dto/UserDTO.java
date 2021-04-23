package kosta.mvc.dto;

public class UserDTO {
	private String userId;

	public UserDTO() {}
	
	public UserDTO(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
