package com.ambh.ws.soap.mtom.ws;

import com.ambh.ws.soap.mtom.dto.DownloadFileRequest;
import com.ambh.ws.soap.mtom.dto.UploadFileRequest;
import org.apache.cxf.feature.Features;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "FileWs")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public interface FileWs {

    void upload(@WebParam(name = "uploadFileRequest") UploadFileRequest uploadFileRequest);
    DataHandler download(@WebParam(name = "downloadFileRequest") DownloadFileRequest downloadFileRequest);
}
