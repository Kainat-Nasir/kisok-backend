package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.persistence.entity.User;
import com.conurets.parking_kiosk.persistence.repository.UserRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Getter
@Component
public class PKValidationUtil {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public PKValidationUtil(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean currentPasswordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }



    public void validateEmailAddress(String emailAddress) throws PKException {
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);

        if (user.isPresent()) {
            throw new PKException(1000, "Email address already exists");
        }
    }
}
