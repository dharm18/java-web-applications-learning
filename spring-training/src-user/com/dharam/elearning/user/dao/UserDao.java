package com.dharam.elearning.user.dao;

import org.springframework.stereotype.Repository;

import com.dharam.elearning.generic.dao.GenericDao;
import com.dharam.elearning.user.bean.User;

@Repository
public class UserDao extends GenericDao<User> implements IUserDao{

}
