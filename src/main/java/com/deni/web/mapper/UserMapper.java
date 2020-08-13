package com.deni.web.mapper;

import com.deni.web.domain.User;
import com.deni.web.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDTO userDTO);
}
