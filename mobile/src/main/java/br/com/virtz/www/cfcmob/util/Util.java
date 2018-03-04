package br.com.virtz.www.cfcmob.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String serialize(Object obj) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(obj);
            so.flush();
            // This encoding induces a bijection between byte[] and String (unlike UTF-8)
            return bo.toString("ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Deserialize any object
     * @param str
     * @param cls
     * @return
     */
    public static <T> T deserialize(String str, Class<T> cls) {
        // deserialize the object
        try {
            // This encoding induces a bijection between byte[] and String (unlike UTF-8)
            byte b[] = str.getBytes("ISO-8859-1");
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            return cls.cast(si.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
