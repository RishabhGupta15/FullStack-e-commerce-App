package com.ecom.userservice.service;

import com.ecom.userservice.model.Role;
import com.ecom.userservice.model.User;
import com.ecom.userservice.model.UserSecurityModel;
import com.ecom.userservice.repository.RoleRepository;
import com.ecom.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements  UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByusername(username);
        Role userRole = roleRepository.findByrole(role);
        Collection<Role> userRoles = user.getRoles();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByusername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username);
        if (user == null) throw new UsernameNotFoundException("user not found");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new UserSecurityModel(user);
    }
}
