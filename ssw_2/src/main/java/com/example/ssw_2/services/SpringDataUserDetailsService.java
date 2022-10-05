package com.example.ssw_2.services;

import com.example.ssw_2.model.SecurityUser;
import com.example.ssw_2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpringDataUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    var u = userRepository.findUserByUsername(username);
    return u.map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException(":("));
  }
}
