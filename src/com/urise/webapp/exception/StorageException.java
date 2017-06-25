package com.urise.webapp.exception;

/**
 * Created by Pavlo on 12/06/2017.
 */
public class StorageException extends RuntimeException {
    private final String uuid;

//    public StorageException(String uuid) {
//        this.uuid = uuid;
//    }

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
