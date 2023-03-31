package Abstractions.DataAccess.Repositories;

import Abstractions.Entities.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGenericRepository<T extends BaseEntity> {
    Optional<T> getById(UUID id);
    List<T> getAll();
    void insert(T entity);
    void update(T entity);
}
