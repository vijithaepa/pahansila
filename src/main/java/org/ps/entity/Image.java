package org.ps.entity;

import javax.persistence.*;

/**
 * Created by vepa on 21/9/17.
 */
@Entity
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "uniqueId", nullable = false)
  private String uniqueId;

  @ManyToOne
  @JoinColumn(name = "entity", nullable = false)
  private EntityWithImage entity;

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

  public String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public EntityWithImage getEntity() {
    return entity;
  }

  public void setEntity(EntityWithImage entity) {
    this.entity = entity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Image)) return false;

    Image image = (Image) o;

    if (id != null ? !id.equals(image.id) : image.id != null) return false;
    if (!name.equals(image.name)) return false;
    return uniqueId.equals(image.uniqueId);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + name.hashCode();
    result = 31 * result + uniqueId.hashCode();
    return result;
  }
}
