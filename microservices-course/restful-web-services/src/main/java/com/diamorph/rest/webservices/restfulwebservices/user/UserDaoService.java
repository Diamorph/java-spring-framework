package com.diamorph.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(users.size() + 1, "Adam", LocalDate.of(2000, 10, 15)));
        users.add(new User(users.size() + 1, "Eve", LocalDate.of(2005, 10, 15)));
        users.add(new User(users.size() + 1, "Jim", LocalDate.of(2010, 10, 15)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
