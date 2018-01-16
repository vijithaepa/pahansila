package org.ps.entity.repo;

import org.junit.Assert;
import org.junit.Test;
import org.ps.entity.Image;
import org.ps.mps.MpsApplicationTests;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

/**
 * Created by vepa on 22/9/17.
 */
public class TestImageRepo extends MpsApplicationTests {

  @Autowired
  ImageRepo imageRepo;

  @Autowired
  UserRepo userRepo;

  @Autowired
  ActivityRepo activityRepo;

  @Test public void testAddImage() {

    Image image = new Image();
    image.setName("abcd.jpg");
    image.setUniqueId("Llkjsdlkjfskldjfl987jkn");

    imageRepo.save(image);
    Assert.assertNotNull(image.getId());
  }
}
