package com.fabric.ilearn.authentication;

import com.fabric.ilearn.dao.adm.UserRepository;
import com.fabric.ilearn.dto.adm.principle.UserPrincipleDTO;
import com.fabric.ilearn.mapper.adm.principle.UserPrincipleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPrincipleMapper userPrincipleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipleDTO userPrinciple = userPrincipleMapper.UserToUserPrinciple(userRepository.getByUserName(username));

        if(userPrinciple == null)
            throw new UsernameNotFoundException("user is not found");

        return new CustomUserDetails(userPrinciple);
    }
}
