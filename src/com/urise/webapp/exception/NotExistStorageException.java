package com.urise.webapp.exception;

/**
 * Created by Pavlo on 12/06/2017.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
