package com.conurets.parking_kiosk.security.util;

import com.conurets.parking_kiosk.base.exception.PKException;
import com.conurets.parking_kiosk.base.util.PKConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptionCrypt {
    private static String encrypt(String Data, String secret) throws Exception {
        Key key = generateKey(secret);
        Cipher c = Cipher.getInstance(PKConstants.Common.OGLA);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    private static Key generateKey(String secret) {
        byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
        return new SecretKeySpec(decoded, PKConstants.Common.OGLA);
    }

    private static String encodeKey(String str) {
        byte[] encoded = Base64.getEncoder().encode(str.getBytes());
        return new String(encoded);
    }

    public static String decodeKey(String str) {
        byte[] decoded = Base64.getDecoder().decode(str.getBytes());
        return new String(decoded);
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            Key key = generateKey(secret);
            Cipher cipher = Cipher.getInstance(PKConstants.Common.OGLA);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception ignored) {
        }
        return null;
    }

    public static String generateHashPassword(String password) throws PKException {
        try {
            String encodedBase64Key = EncryptionCrypt.encodeKey(PKConstants.Common.ZXRzLmNvbSIsImV4c);
            return encrypt(password, encodedBase64Key);
        } catch (Exception ignored) {
        }
        return null;
    }

    public static String decryptHashPassword(String encrPassword) throws PKException {
        try {
            String encodedBase64Key = EncryptionCrypt.encodeKey(PKConstants.Common.ZXRzLmNvbSIsImV4c);
            return decrypt(encrPassword, encodedBase64Key);
        } catch (Exception ignored) {
        }
        return null;
    }
}