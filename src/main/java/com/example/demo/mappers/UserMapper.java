package com.example.demo.mappers;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity){
        return UserModel.builder().email(entity.getEmail()).firstName(entity.getFirstName()).lastName(entity.getLastName()).build();
    }

    public static User toEntity(UserModel model){
        User user = new User();
        user.setId(model.getId());
        user.setEmail(model.getEmail());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        return user;
    }

    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toModelPagedList(Page<User> pageEntity){
        return UserPageModel.builder().users(toModelList(pageEntity.getContent())).totalPages(pageEntity.getTotalPages()).totalElements(pageEntity.getNumberOfElements()).build();
    }
}
