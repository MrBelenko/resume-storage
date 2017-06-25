package com.urise.webapp.exception;

/**
 * Created by Pavlo on 12/06/2017.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}
