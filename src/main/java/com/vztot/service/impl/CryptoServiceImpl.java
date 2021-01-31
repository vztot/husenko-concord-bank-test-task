package com.vztot.service.impl;

import com.vztot.service.CryptoService;
import com.vztot.util.AESUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int KEY_SIZE = 256;

    private SecretKey key;
    private IvParameterSpec ivParameterSpec;

    @PostConstruct
    private void getKeyAndIvParameterSpec() throws NoSuchAlgorithmException {
        key = AESUtil.generateKey(KEY_SIZE);
        ivParameterSpec = AESUtil.generateIv();
    }

    @Override
    public String encrypt(String input) throws NoSuchAlgorithmException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        return AESUtil.encrypt(ALGORITHM, input, key, ivParameterSpec);
    }

    @Override
    public String decrypt(String input) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        return AESUtil.decrypt(ALGORITHM, input, key, ivParameterSpec);
    }
}
