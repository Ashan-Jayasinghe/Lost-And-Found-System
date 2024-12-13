package com.lostandfoundsystem.LAFS.utility.mappers;

import com.lostandfoundsystem.LAFS.dto.request.UserSaveDTO;
import com.lostandfoundsystem.LAFS.dto.response.UserDetailsDTO;
import com.lostandfoundsystem.LAFS.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //UserSaveDTO --> UserEntity
    User userSaveDTOToUserEntity(UserSaveDTO userSaveDTO);

    UserDetailsDTO UserEntityToUserDetailsDTO(User user);

    List<UserDetailsDTO> UserPageToUserListDTO(Page<User> users);
}
