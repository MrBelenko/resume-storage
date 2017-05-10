/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public final static int STORAGE_MAX_LENGTH = 10000;
    Resume[] storage = new Resume[STORAGE_MAX_LENGTH];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size == STORAGE_MAX_LENGTH - 1) {
            System.out.println("The storage is full.");
        }
        if (getIndex(r.getUuid()) > -1) {
            return;
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            Resume resume = storage[index];
            return resume;
        }
        System.out.println("A resume " + uuid + " is absent.");
        return null;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("The resume " + uuid + " isn't exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
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
