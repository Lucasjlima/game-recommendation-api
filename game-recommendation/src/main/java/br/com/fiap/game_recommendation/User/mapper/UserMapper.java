package br.com.fiap.game_recommendation.User.mapper;

import br.com.fiap.game_recommendation.User.dto.request.UserRequest;
import br.com.fiap.game_recommendation.User.dto.response.UserResponse;
import br.com.fiap.game_recommendation.User.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toUser(UserRequest request) {

        return User
                .builder()
                .username(request.username().toLowerCase())
                .password(request.password())
                .build();
    }



    public static UserResponse toUserResponse(User user) {

        return UserResponse
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
