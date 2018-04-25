package com.warframe.tmall.configuration;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author yaojiabin
 * @Description'
 * @date 2018-04-25 15:06
 */
@Component
@Slf4j
public class FastDFSClientWrapper {

    @Value("${fdfs.resHost}")
    private String FASTDFS_IP;

    @Value("${fdfs.storagePort}")
    private String FASTDFS_PORT;

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    // 封装文件完整URL地址
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = "http://" + FASTDFS_IP + ":" + FASTDFS_PORT + "/" + storePath.getFullPath();
        return fileUrl;
    }
}
