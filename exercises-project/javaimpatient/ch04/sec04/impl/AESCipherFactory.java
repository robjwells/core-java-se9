package javaimpatient.ch04.sec04.impl;

import javaimpatient.ch04.sec04.Cipher;

public class AESCipherFactory {
    public static Cipher provider() { return new AESCipher(); }
}
