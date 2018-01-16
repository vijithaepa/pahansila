package org.ps.entity;

import org.ps.entity.enums.UserRole;

import javax.persistence.*;

/**
 * Created by vepa on 21/9/17.
 */
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRole role;

  @Column(name = "active", nullable = false)
  private Boolean active;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;

    User user = (User) o;

    if (!id.equals(user.id)) return false;
    if (!name.equals(user.name)) return false;
    if (!email.equals(user.email)) return false;
    if (!address.equals(user.address)) return false;
    if (!passwordHash.equals(user.passwordHash)) return false;
    if (role != user.role) return false;
    return active.equals(user.active);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + email.hashCode();
    result = 31 * result + address.hashCode();
    result = 31 * result + passwordHash.hashCode();
    result = 31 * result + role.hashCode();
    result = 31 * result + active.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", passwordHash='" + passwordHash + '\'' +
            ", role=" + role +
            ", active=" + active +
            '}';
  }
}
