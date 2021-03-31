package com.cg.creditcardbillpayment.services;

import com.cg.creditcardbillpayment.entities.User;

public interface UserService {
	public User signIn(User user);

	public User signOut(User user);

	public User changePassword(long id, User user);
}
