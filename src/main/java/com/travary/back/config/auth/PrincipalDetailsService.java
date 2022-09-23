package com.travary.back.config.auth;

import com.travary.back.user.User;
import com.travary.back.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        System.out.println("아이디는 " + identifier);
        User userEntity = userRepository.findByIdentifier(identifier);
        if(userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        System.out.println(identifier + " 을 DB에서 찾을 수 없습니다");
        return null;
    }

}
