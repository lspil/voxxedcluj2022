package com.example.ssw_2.model;

import com.example.ssw_2.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

  private final User user;

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    var authorities= user.getAuthorities();

    List<GrantedAuthority> result = new ArrayList<>();
    for (var a : authorities) {
      if (a.isRole()) {
        result.add(new SimpleGrantedAuthority("ROLE_" + a.getName()));
      } else {
        result.add(new SimpleGrantedAuthority(a.getName()));
      }
    }

    return result;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
