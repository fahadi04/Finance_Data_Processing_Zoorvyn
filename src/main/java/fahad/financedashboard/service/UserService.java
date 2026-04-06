package fahad.financedashboard.service;

import fahad.financedashboard.entity.User;
import fahad.financedashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository
                .findById(id)
                .orElseThrow();

        existing.setName(user.getName());
        existing.setRole(user.getRole());
        existing.setActive(user.isActive());

        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
