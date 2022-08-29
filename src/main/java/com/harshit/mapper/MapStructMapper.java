package com.harshit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.harshit.dto.UpdateUserInfoDto;
import com.harshit.entity.User;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapStructMapper {
    User userUpdateDtoToUser(UpdateUserInfoDto updateUserInfoDto);
}
