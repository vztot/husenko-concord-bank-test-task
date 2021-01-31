package com.vztot.service.impl;

import com.vztot.dao.UserRepository;
import com.vztot.exception.DataProcessingException;
import com.vztot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String getUserFioById(Long id) {
        return userRepository.getUserFioById(id).orElseThrow(
                () -> new DataProcessingException("Can't find user with id: " + id));
    }
}
