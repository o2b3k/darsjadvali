package kg.ksucta.service;

import kg.ksucta.domain.user.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> getByEmail(String username);
}
