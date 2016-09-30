package com.dharam.elearning.user.service;

import org.springframework.stereotype.Service;

import com.dharam.elearning.generic.service.GenericService;
import com.dharam.elearning.user.bean.User;

@Service
public class UserService extends GenericService<User> implements IUserService{

}
