package com.study.cbnu.smart_changing_room.exception;

public class FileDownloadException extends RuntimeException{
    public FileDownloadException(String message) {
        super(message);
    }

    public FileDownloadException(String message, Throwable cause) {
        super(message, cause);
    }
}

