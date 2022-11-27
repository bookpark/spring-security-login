package mini.login.service;

import lombok.RequiredArgsConstructor;
import mini.login.domain.SiteUser;
import mini.login.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SiteUser signUp(String email, String password, String nickname) {
        SiteUser siteUser = new SiteUser();
        siteUser.setEmail(email);
        siteUser.setNickname(nickname);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        siteUser.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(siteUser);
        return siteUser;
    }

}
