package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {


    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
//        Arrays.fill(storage,null);
        Arrays.fill(storage, 0, size, null);
//        for (int i = 0; i < size; i++) {
//            storage[i] = null;
//        }
        size = 0;
    }

    public void save(Resume r) {
        if (size == STORAGE_LIMIT - 1) {
            System.out.println("The storage is full.");
        }
        if (getIndex(r.getUuid()) > -1) {
            return;
        }
        storage[size] = r;
        size++;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
            return;
        }
        System.out.println("A resume " + resume + " is absent." +
                " That's why it can't be update.");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];          //Resume resume = storage[index];
        }
        System.out.println("A resume " + uuid + " is absent.");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("The resume " + uuid + " isn't exist.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
//        Resume[] resumes = new Resume[size];
//        for (int i = 0; i < size; i++) {    // System.arraycopy(storage, 0, resumes, 0, size);
//            resumes[i] = storage[i];
//        }
//        return resumes;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
