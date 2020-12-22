package com.harbor.common.service;

import com.harbor.common.domain.User;

/**
 * @author harborGao
 * @create 2020/11/6
 */
public interface UserService {
    User findUser(String userName);
    int addUser(User user);
}
