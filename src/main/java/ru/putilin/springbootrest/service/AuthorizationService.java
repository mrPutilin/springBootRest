package ru.putilin.springbootrest.service;

import org.springframework.stereotype.Service;
import ru.putilin.springbootrest.model.Authorities;
import ru.putilin.springbootrest.model.User;
import ru.putilin.springbootrest.repository.UserRepository;
import ru.putilin.springbootrest.advice.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser() + " " + user.getPassword());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
