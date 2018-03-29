package domain;

public class UserDTO {
	private String uerId;
	private String password;
	private String nickname;
	private String account;
	private String email;
	private String mobile;
	
	public UserDTO(String userId, String password, String nickname, String account, String email, String mobile) {
		this.uerId = userId;
	}
	public String getUerId() {
		return uerId;
	}
	public void setUerId(String uerId) {
		this.uerId = uerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "UserDTO [uerId=" + uerId + ", password=" + password + ", nickname=" + nickname + ", account=" + account
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}

}
