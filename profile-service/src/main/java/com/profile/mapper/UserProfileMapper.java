package com.profile.mapper;

import com.profile.dto.request.ProfileCreationRequest;
import com.profile.dto.response.UserProfileReponse;
import com.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileReponse toUserProfileReponse(UserProfile entity);
}
