package com.mycompany.tickproject.models;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by apple on 09.07.14.
 */
public class FileUploadForm {
    private List<MultipartFile> files;

    private List<String> sectionsId;

    //Getter and setter methods
    public List<MultipartFile> getFiles(){
        return this.files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }


    public List<String> getSectionsId() { return this.sectionsId; }

    public void setSectionsId (List<String> sectionsId) { this.sectionsId = sectionsId; }
}
