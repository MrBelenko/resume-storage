package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            doDelete(index);
            size--;
        } else {
            throw new NotExistStorageException(uuid);
//            System.out.println("The resume " + uuid + " isn't exist.");
        }
    }
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > -1) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            doSave(r, index);
            size++;
        }

    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
            return;
        }
        throw new NotExistStorageException(resume.getUuid());
//        System.out.println("A resume " + resume + " is absent." +
//                " That's why it can't be update.");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];          //Resume resume = storage[index];
        }
        throw new NotExistStorageException(uuid);
//        System.out.println("A resume " + uuid + " is absent.");
//        return null;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void doDelete(int index);

    protected abstract void doSave(Resume r, int index);

}