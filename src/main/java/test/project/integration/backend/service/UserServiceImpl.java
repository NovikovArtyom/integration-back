package test.project.integration.backend.service;

import org.springframework.stereotype.Service;
import test.project.integration.backend.dto.UserDto;
import test.project.integration.backend.dto.UserMapper;
import test.project.integration.backend.entity.UserEntity;
import test.project.integration.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registration(UserDto userDto) {
        UserEntity userEntity = UserMapper.toUserEntity(userDto);
        userRepository.save(userEntity);
    }
}
