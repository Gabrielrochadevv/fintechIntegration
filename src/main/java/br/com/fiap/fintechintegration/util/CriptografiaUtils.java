package br.com.fiap.fintechintegration.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtils {

    public static String criptografar(String dssenha)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(dssenha.getBytes("ISO-8859-1"));

        BigInteger hash = new BigInteger(1, md.digest());

        return hash.toString(16);

    }
}
