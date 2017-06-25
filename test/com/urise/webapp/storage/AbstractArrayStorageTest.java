package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavlo on 18/06/2017.
 */
public abstract class AbstractArrayStorageTest extends  AbstractStorageTest  {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
//        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
//        } catch (StorageException e) {
//            Assert.fail();
//        }
        storage.save(new Resume("Overflow"));
    }
}