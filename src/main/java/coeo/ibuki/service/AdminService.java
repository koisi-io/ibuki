package coeo.ibuki.service;

import coeo.ibuki.entity.Admin;

public interface AdminService {
	
	Admin login(String userName, String password);
	
	Admin getUserDetailById(Long loginUserId);
	
	Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword);
	
	Boolean updateName(Long loginUserId, String loginUserName, String nickName);
	
}
