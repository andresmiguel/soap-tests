package com.ambh.ws.soap.mtom.ws;

import com.ambh.ws.soap.mtom.dto.DownloadFileRequest;
import com.ambh.ws.soap.mtom.dto.UploadFileRequest;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;

public class FileWsImpl implements FileWs {

    private String outputFolder;

    public FileWsImpl(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    @Override
    public void upload(UploadFileRequest uploadFileRequest) {

        try (InputStream inputStream = uploadFileRequest.getFile().getInputStream();
             OutputStream outputStream = new FileOutputStream(new File(outputFolder + uploadFileRequest.getName()))) {
            byte[] b = new byte[100000];
            int bytesRead;

            while ((bytesRead = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DataHandler download(DownloadFileRequest downloadFileRequest) {
        return new DataHandler(new FileDataSource(outputFolder + downloadFileRequest.getName()));
    }

}
