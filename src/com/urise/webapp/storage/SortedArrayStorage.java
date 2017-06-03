package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Pavlo on 21/05/2017.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doDelete(int index) {
        for (int i = index; i < size ; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected void doSave(Resume r, int index) {
        if (size == 0){
            storage[0] = r;
        }else {
            int insertIdx = -index - 1;
            for (int i = 0; i < size - insertIdx; i++) {
                storage[size - i] = storage[size - i - 1];
            }
            storage[insertIdx] = r;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
