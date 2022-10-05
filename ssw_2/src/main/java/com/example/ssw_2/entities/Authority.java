package com.example.ssw_2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "authorities")
@Getter
@Setter
public class Authority {

  @Id
  private int id;
  private String name;
  private boolean role;

  @ManyToMany(mappedBy = "authorities")
  private Set<User> users;
}
