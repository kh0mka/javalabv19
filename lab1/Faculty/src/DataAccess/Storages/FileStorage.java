package DataAccess.Storages;
import Abstractions.Entities.BaseEntity;
import Abstractions.DataAccess.Storage.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStorage implements Storage<List<BaseEntity>>, Abstractions.DataAccess.Storage.FileStorage {
    private static final String FILE_EXTENSION = ".ser";
    private static final Logger LOGGER = Logger.getLogger(FileStorage.class.getName());

    @Override
    public List<BaseEntity> getCollectionOfName(String collectionName) {
        String collectionPath = collectionName + FILE_EXTENSION;
        List<BaseEntity> deserializedObject = new ArrayList<>();

        try (var objectInputStream = new ObjectInputStream(new FileInputStream(new File(collectionPath)))) {
            deserializedObject = (List<BaseEntity>) objectInputStream.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Exception while reading collection: " + collectionName, e);
        }

        return deserializedObject;
    }

    public void saveChanges(List<BaseEntity> data) {
        String collectionPath = data.get(0).getClass().getSimpleName() + FILE_EXTENSION;

        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(collectionPath))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception while saving changes for collection: " + data.get(0).getClass().getSimpleName(), e);
        }
    }

    @Override
    public void createCollectionFiles(String[] collectionNames) {
        for (var collectionName : collectionNames) {
            createFileIfNotExists(collectionName);
        }
    }

    private void createFileIfNotExists(String collectionName) {
        var fileNameWithExtension = collectionName + FILE_EXTENSION;
        var file = new File (fileNameWithExtension);

        if (!file.exists ()) {
            try {
                if (file.createNewFile ()) {
                    LOGGER.log (Level.INFO, "File for collection created: " + collectionName);
                } else {
                    LOGGER.log (Level.WARNING, "Couldn't file for collection: " + collectionName);
                }
            } catch (IOException e) {
                LOGGER.log (Level.SEVERE, "Error creating file for collection: " + collectionName);
            }
        }
    }
}
