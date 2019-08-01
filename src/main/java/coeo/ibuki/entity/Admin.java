package coeo.ibuki.entity;

public class Admin {
	private Long adminId;
	private String loginName;
	private String loginPassword;
	private String adminNickName;
	private Byte locked;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getAdminNickName() {
		return adminNickName;
	}
	public void setAdminNickName(String adminNickName) {
		this.adminNickName = adminNickName;
	}
	public Byte getLocked() {
		return locked;
	}
	public void setLocked(Byte locked) {
		this.locked = locked;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", adminNickName=").append(adminNickName);
        sb.append(", locked=").append(locked);
        sb.append("]");
        return sb.toString();
    }
	
}
