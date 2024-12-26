package bg.softuni.mobilele.models.mappers;

import bg.softuni.mobilele.models.dtos.UserRegisterDTO;
import bg.softuni.mobilele.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);

}
