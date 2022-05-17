package com.trantor.app.controller;

import com.trantor.app.encryptor.EncryptorB;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class AppController {

    private final EncryptorB encryptorB;

    private static final String PUBLIC_KEY_FILE = "D:\\EncryptorB\\NASA FCU.asc";
    private static final String INPUT_FILE_NAME = "D:\\EncryptorB\\textFileToEncrypt.txt";
    private static final String OUTPUT_FILE_NAME = "D:\\EncryptorB\\EncryptedFile.bpg";

    @GetMapping
    public ResponseEntity<String> getFile() throws Exception {


        encryptorB.encrypt(PUBLIC_KEY_FILE, INPUT_FILE_NAME, OUTPUT_FILE_NAME);

        System.out.println("File Encrypted successfully");


        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

}
