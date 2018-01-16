package org.ps.entity;

import org.ps.entity.enums.Location;
import org.ps.entity.enums.MemberType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vepa on 22/9/17.
 */
@Entity
@Table(name = "Member")
public class Member extends EntityWithImage{

  @Basic
  private String name;

  @Basic
  private String Address;

  @Basic
  private Date dob;

  @Basic
  private String gender;

  @Column(length = 512)
  private String description;

  @Basic
  private Boolean deceased;

  @Enumerated(EnumType.STRING)
  private Location location;

  @Enumerated(EnumType.STRING)
  @Column(name = "memberType", nullable = false)
  private MemberType memberType;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "contactPerson")
  private ContactPerson contactPerson;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getDeceased() {
    return deceased;
  }

  public void setDeceased(Boolean deceased) {
    this.deceased = deceased;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public ContactPerson getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(ContactPerson contactPerson) {
    this.contactPerson = contactPerson;
  }

  public MemberType getMemberType() {
    return memberType;
  }

  public void setMemberType(MemberType memberType) {
    this.memberType = memberType;
  }
}
