package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    User user;
    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int assignPermission() {
        if(user.getRole().equals("admin")) {
            String username = user.getUsername();
            System.out.println("Assign special permissions for user " + username);
            return 1;
        } else {
            System.out.println("Cannot assign permission");
            return -1;
        }
    }

    public List<String> getAllPostsContainingWord(String searchedWord) {
        //implementation
        return new ArrayList<>();
    }

    public int updateUsername(String id, String username) throws Exception{
        User user = userDao.getUserById(id).orElseThrow();
        user.setUsername(username);
        userDao.save(user);
        return 1;
    }
}