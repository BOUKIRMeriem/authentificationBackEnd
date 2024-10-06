package com.example.authentification.Service;

import com.example.authentification.Entity.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> getAll();
    UserEntity delete(int id);

}
