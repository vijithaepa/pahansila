package org.ps.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Parent class for entities with having images {@link Image}.
 *
 * Created by vepa on 22/9/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntityWithImage {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Image> images = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Image> getImages() {
    return images;
  }

  public void addImage(Image image) {
    if(this.images == null)
      this.images = new HashSet<>();
    this.images.add(image);
    image.setEntity(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EntityWithImage)) return false;

    EntityWithImage that = (EntityWithImage) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return images != null ? images.equals(that.images) : that.images == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (images != null ? images.hashCode() : 0);
    return result;
  }
}
