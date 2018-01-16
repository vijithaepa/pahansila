package org.ps.entity.repo;

import org.junit.Test;
import org.ps.entity.Activity;
import org.ps.entity.Image;
import org.ps.entity.enums.ActivityType;
import org.ps.mps.MpsApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by vepa on 22/9/17.
 */
public class TestActivityRepo extends MpsApplicationTests {

  @Autowired
  UserRepo userRepo;

  @Autowired
  ActivityRepo activityRepo;

  @Test public void testSaveActivity() {

    Activity activity = new Activity();
    activity.setActive(true);
    activity.setActivityDate(Timestamp.from(Instant.now()));
    activity.setCreatedTime(Timestamp.from(Instant.now()));
    activity.setActivityType(ActivityType.ACTIVITY);
    activity.setCreatedUser(userRepo.findOne(1L));
    activity.setDescription("Activity 01");
    activity.setExpireOn(Timestamp.from(Instant.now()));
    activity.setTitle("Activity_01");

    Image image = new Image();
    image.setName("abcd.jpg");
    image.setUniqueId("Llkjsdlkjfskldjfl987jkn");
    activity.addImage(image);

    activityRepo.save(activity);
  }
}
