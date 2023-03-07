package ru.putilin.springbootrest.repository;

import org.springframework.stereotype.Repository;
import ru.putilin.springbootrest.Authorities;

import java.util.List;

@Repository
public class UserRepository {

    private final List<Authorities> authorities;

    public UserRepository(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        authorities.add(Authorities.DELETE);
        return authorities;

    }
}
