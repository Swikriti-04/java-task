package com.example.sftp_integration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
public class FileProcessor {

    public void processFile(File file) {
        try {
            log.info("File received: {}", file.getName());

            // Read content
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            log.info("Content:\n{}", content);

            // Write to processed folder
            File processed = new File("./processed/" + file.getName());
            java.nio.file.Files.writeString(processed.toPath(), content);

            // Delete original from local download dir
            file.delete();

            log.info("Processed and moved to processed/");
        }
        catch (Exception e) {
            log.error("Error processing file", e);
        }
    }
}
