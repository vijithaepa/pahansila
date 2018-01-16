package org.ps.entity.enums;

/**
 * Created by vepa on 26/9/17.
 */
public enum MemberType {
  ADMIN(0), EMPLOYEE(1), RESIDENT(2);

  private int order;

  MemberType(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

}
