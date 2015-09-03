package co.romulo.comida.auth.crypto;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

public class PasswordCryptographer {

    public static final PasswordCryptographer defaultPasswordCryptographer = new PasswordCryptographer();

    public String crypt(String unencrytedPassword) {
        return sha256Hex(unencrytedPassword).toUpperCase();
    }
}
