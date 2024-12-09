package com.xworkz.repository;

import com.xworkz.entity.LoginEntity;
import com.xworkz.entity.UserLoginEntity;

public interface UserLoginRepository {

    public String loginByEmail(UserLoginEntity userLoginEntity);

}
