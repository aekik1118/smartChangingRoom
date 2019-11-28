package com.study.cbnu.smart_changing_room.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class FileUploadResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
