package io.github.bbortt.qdrakeboo.authorizationserver.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Table
@Entity
public class GrantType extends AbstractAuditingEntity {

  private static final long serialVersionUID = 1L;

  public static final String CACHE_NAME = "grant-type-cache";

  @Id
  @Type(type = "pg-uuid")
  @GeneratedValue(generator = "grant-type-uuid")
  @GenericGenerator(name = "grant-type-uuid",
      strategy = "io.github.bbortt.qdrakeboo.authorizationserver.domain.postgresql.PostgreSQLUUIDGenerationStrategy")
  @Column(nullable = false, unique = true, columnDefinition = "uuid")
  private UUID uuid;

  @NotEmpty
  @Size(max = 16)
  @Column(nullable = false, unique = true)
  private String name;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object == this) {
      return true;
    }
    if (object.getClass() != getClass()) {
      return false;
    }
    GrantType grantType = (GrantType) object;
    return new EqualsBuilder().appendSuper(super.equals(object)).append(uuid, grantType.uuid)
        .append(name, grantType.name).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(uuid).append(name)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append(uuid).append(name).build();
  }
}
