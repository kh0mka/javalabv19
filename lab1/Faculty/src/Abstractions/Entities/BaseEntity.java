package Abstractions.Entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseEntity implements Serializable {
   private UUID id;

   public BaseEntity()
   {
      id = UUID.randomUUID();
   }
   public UUID getId()
   {
      return  id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BaseEntity)) return false;
      BaseEntity object = (BaseEntity) o;

      return id.equals(object.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
