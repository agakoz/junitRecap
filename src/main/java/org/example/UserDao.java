package org.example;

import java.util.Optional;

public class UserDao {
    public Optional<User> getUserById(String id) {
        // Make database query here
        return Optional.of(new User());
    }

    public void save(User user) throws Exception {
        // Make database query here
    }
}
