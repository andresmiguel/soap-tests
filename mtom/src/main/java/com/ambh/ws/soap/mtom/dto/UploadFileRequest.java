package com.ambh.ws.soap.mtom.dto;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "UploadFileRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadFileRequest {

    @XmlElement(name = "file", required = true)
    private DataHandler file;
    @XmlElement(name = "name", required = true)
    private String name;

    public DataHandler getFile() {
        return file;
    }

    public void setFile(DataHandler file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
