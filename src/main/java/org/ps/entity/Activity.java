package org.ps.entity;


import org.ps.entity.enums.ActivityType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by vepa on 21/9/17.
 */
@Entity
@Table(name = "Activity")
public class Activity extends EntityWithImage{

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToOne(targetEntity = User.class)
  private User createdUser;

  @Basic
  private Timestamp createdTime;

  @Basic
  private Timestamp expireOn;

  @Basic
  private Boolean active;

  @Basic
  private Timestamp activityDate;

  @Enumerated(EnumType.STRING)
  private ActivityType activityType;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(User createdUser) {
    this.createdUser = createdUser;
  }

  public Timestamp getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Timestamp createdTime) {
    this.createdTime = createdTime;
  }

  public Timestamp getExpireOn() {
    return expireOn;
  }

  public void setExpireOn(Timestamp expireOn) {
    this.expireOn = expireOn;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Timestamp getActivityDate() {
    return activityDate;
  }

  public void setActivityDate(Timestamp activityDate) {
    this.activityDate = activityDate;
  }

  public ActivityType getActivityType() {

    return activityType;
  }

  public void setActivityType(ActivityType activityType) {
    this.activityType = activityType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Activity)) return false;
    if (!super.equals(o)) return false;

    Activity activity = (Activity) o;

    if (!title.equals(activity.title)) return false;
    if (description != null ? !description.equals(activity.description) : activity.description != null) return false;
    if (createdUser != null ? !createdUser.equals(activity.createdUser) : activity.createdUser != null) return false;
    if (createdTime != null ? !createdTime.equals(activity.createdTime) : activity.createdTime != null) return false;
    if (expireOn != null ? !expireOn.equals(activity.expireOn) : activity.expireOn != null) return false;
    if (active != null ? !active.equals(activity.active) : activity.active != null) return false;
    if (activityDate != null ? !activityDate.equals(activity.activityDate) : activity.activityDate != null)
      return false;
    return activityType == activity.activityType;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + title.hashCode();
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
    result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
    result = 31 * result + (expireOn != null ? expireOn.hashCode() : 0);
    result = 31 * result + (active != null ? active.hashCode() : 0);
    result = 31 * result + (activityDate != null ? activityDate.hashCode() : 0);
    result = 31 * result + (activityType != null ? activityType.hashCode() : 0);
    return result;
  }
}
