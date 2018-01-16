package org.ps.entity.repo;

import org.ps.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vepa on 22/9/17.
 */
public interface ImageRepo extends JpaRepository<Image, Long> {
}
