package org.ps.entity.repo;

import org.junit.Assert;
import org.junit.Test;
import org.ps.entity.ContactPerson;
import org.ps.entity.Image;
import org.ps.entity.Member;
import org.ps.entity.enums.Location;
import org.ps.entity.enums.MemberType;
import org.ps.entity.enums.RelationshipType;
import org.ps.mps.MpsApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by vepa on 22/9/17.
 */
public class TestMemberRepo extends MpsApplicationTests {

  @Autowired
  MemberRepo memberRepo;

  @Autowired
  ContactPersonRepo contactPersonRepo;

  @Transactional
  @Test public void testSaveMember(){

    Member member = new Member();
    member.setName("Sam 1");
    member.setAddress("Melbourne 1");
    member.setDeceased(false);
    member.setDob(Timestamp.from(Instant.now()));
    member.setGender("M");
    member.setMemberType(MemberType.ADMIN);
    member.setLocation(Location.LOCATION_1);

    Member member2 = new Member();
    member2.setName("Sam 1");
    member2.setAddress("Melbourne 1");
    member2.setDeceased(false);
    member2.setDob(Timestamp.from(Instant.now()));
    member2.setGender("M");
    member2.setMemberType(MemberType.ADMIN);
    member2.setLocation(Location.LOCATION_1);

    Image image = new Image();
    image.setName("abcd.jpg");
    image.setUniqueId("Llkjsdlkjfskldjfl987jxvxcvkn");

    member.addImage(image);


    ContactPerson contactPerson = new ContactPerson();
    contactPerson.setEmail("aa@b.c");
    contactPerson.setAddress("Pint cook 1");
    contactPerson.setName("John 1");
    contactPerson.setPhone("02893840234");
    contactPerson.setRelationshipType(RelationshipType.RALATIVE);
    contactPerson.addMember(member);
    member.setContactPerson(contactPerson);
    memberRepo.save(member);

    Image image2 = new Image();
    image2.setName("XYZSD.jpg");
    image2.setUniqueId("987fdss8n9sd");
    member2.addImage(image2);
    member2.setContactPerson(contactPersonRepo.findOne(contactPerson.getId()));
    contactPerson.addMember(member2);
    memberRepo.save(member2);

    Assert.assertNotNull(member.getId());
    Assert.assertNotNull(member2.getId());
  }
}
