package Abstractions.DataAccess.Storage;

import Abstractions.Entities.BaseEntity;

import java.io.FileNotFoundException;
import java.util.List;

public interface Storage<TCollection>{
    List<BaseEntity> getCollectionOfName(String collectionName);
    void saveChanges(TCollection data);
    void createCollectionFiles(String[] strings);
}
