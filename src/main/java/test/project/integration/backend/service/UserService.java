package test.project.integration.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.project.integration.backend.dto.UserDto;
import test.project.integration.backend.dto.UserMapper;
import test.project.integration.backend.entity.UserEntity;
import test.project.integration.backend.repository.UserRepository;
import test.project.integration.backend.security.UserDetailsImpl;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден!", username)
        ));
        return UserDetailsImpl.build(userEntity);
    }
}
