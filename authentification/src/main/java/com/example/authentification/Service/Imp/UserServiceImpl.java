package com.example.authentification.Service.Imp;

import com.example.authentification.Entity.UserEntity;
import com.example.authentification.Repository.UserRepository;
import com.example.authentification.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity delete(int id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));
        userRepository.delete(user);
        return user;
    }


}
