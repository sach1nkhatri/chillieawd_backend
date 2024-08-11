package impl;

import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepo;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User saveUser(User user) {
        user.setDate(LocalDateTime.now()); // Set the current date and time
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
