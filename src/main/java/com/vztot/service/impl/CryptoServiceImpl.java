package com.vztot.service.impl;

import com.vztot.service.CryptoService;
import com.vztot.util.AESUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;

    private SecretKey key;
    private IvParameterSpec ivParameterSpec;

    @PostConstruct
    @SneakyThrows
    private void getKeyAndIvParameterSpec() {
        key = AESUtil.generateKey(KEY_SIZE);
        ivParameterSpec = AESUtil.generateIv();
    }

    @Override
    public String encrypt(String input) {
        return AESUtil.encrypt(ALGORITHM, input, key, ivParameterSpec);
    }

    @Override
    public String decrypt(String input) {
        return AESUtil.decrypt(ALGORITHM, input, key, ivParameterSpec);
    }
}
