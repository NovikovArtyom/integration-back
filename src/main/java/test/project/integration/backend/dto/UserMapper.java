package test.project.integration.backend.dto;

import lombok.experimental.UtilityClass;
import org.apache.catalina.User;
import test.project.integration.backend.entity.UserEntity;

@UtilityClass
public class UserMapper {
    public static UserDto toUserDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFullName(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.getRole()
        );
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        return new UserEntity(
                userDto.getId(),
                userDto.getFullName(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getRole()
        );
    }
}
