package org.ps.entity;

import org.ps.entity.enums.RelationshipType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vepa on 22/9/17.
 */
@Entity
public class ContactPerson {
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

  @Column(name = "phone", nullable = false)
  private String phone; // TODO: should be one to many numbers

  @Enumerated(EnumType.STRING)
  private RelationshipType relationshipType;

  @OneToMany(mappedBy = "contactPerson", cascade = CascadeType.ALL)
  private Set<Member> member = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public RelationshipType getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(RelationshipType relationshipType) {
    this.relationshipType = relationshipType;
  }

  public Set<Member> getMember() {
    return member;
  }

//  public void setMember(Set<Member> member) {
//    this.member = member;
//  }

  public void addMember(Member member) {
    if(this.member == null)
      this.member = new HashSet<>();
    this.member.add(member);
    member.setContactPerson(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ContactPerson)) return false;

    ContactPerson that = (ContactPerson) o;

    if (!id.equals(that.id)) return false;
    if (!name.equals(that.name)) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (!phone.equals(that.phone)) return false;
    return relationshipType == that.relationshipType;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + phone.hashCode();
    result = 31 * result + relationshipType.hashCode();
    return result;
  }
}
