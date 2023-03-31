package Abstractions.DataAccess.Repositories;

import Abstractions.Entities.BaseEntity;
import Abstractions.DataAccess.Storage.Storage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class GenericRepository<T extends BaseEntity> implements IGenericRepository<T> {
    protected List<T> collection;
    final protected Storage storage;
    public GenericRepository(Storage storage, String collectionName) {
        this.storage = storage;
        var deserializedCollection = storage.getCollectionOfName (collectionName);

        if (deserializedCollection == null) collection = new ArrayList<> ();
        else collection = deserializedCollection;
    }
    public Optional<T> getById(UUID id) {
        var entity = collection.stream().filter(x -> x.getId().equals(id)).findFirst();

        return entity;
    }
    public List<T> getAll() {
        return collection;
    }
    public void insert(T entity) {
        collection.add(entity);
        storage.saveChanges (collection);
    }
    public void update(T entity) {
        var index = collection.indexOf (entity);
        collection.set (index, entity);
        storage.saveChanges (collection);
    }
}
