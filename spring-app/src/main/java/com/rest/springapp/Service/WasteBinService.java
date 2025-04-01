package com.rest.springapp.Service;

import com.rest.springapp.entities.User;
import com.rest.springapp.entities.WasteBin;
import com.rest.springapp.repository.UserRepository;
import com.rest.springapp.repository.WasteBinRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WasteBinService {

    private final WasteBinRepository wasteBinRepository;
    private final UserRepository userRepository;

    public WasteBinService(WasteBinRepository wasteBinRepository, UserRepository userRepository) {
        this.wasteBinRepository = wasteBinRepository;
        this.userRepository = userRepository;
    }

    public WasteBin createWasteBin(String location, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User with ID " + userId + " not found");
        }

        WasteBin wasteBin = new WasteBin();
        wasteBin.setLocation(location);
        wasteBin.setUser(userOptional.get()); // ✅ Set the user before saving

        return wasteBinRepository.save(wasteBin);
    }
}
