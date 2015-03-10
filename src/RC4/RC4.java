/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RC4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author fariz.ikhwantri - 1106002330
 * @author muhammad.hanif.naufal - 1106053653
 */
public class RC4 {

    private byte[] S = new byte[256];
    private byte[] T = new byte[256];
    private int keylen;

    public RC4(byte[] key) {

        keylen = key.length;
        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i;
            T[i] = key[i % keylen];
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + T[i]) & 0xFF;
            S[i] ^= S[j];
            S[j] ^= S[i];
            S[i] ^= S[j];
        }

    }

    public byte[] encrypt(byte[] plaintext) {
        byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            S[i] ^= S[j];
            S[j] ^= S[i];
            S[i] ^= S[j];
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            ciphertext[counter] = (byte) (plaintext[counter] ^ k);
        }
        return ciphertext;
    }

    public byte[] decrypt(byte[] ciphertext) {
        return encrypt(ciphertext);
    }

    public byte[] getS() {
        return S;
    }

    public void setS(byte[] S) {
        this.S = S;
    }

    public byte[] getT() {
        return T;
    }

    public void setT(byte[] T) {
        this.T = T;
    }
    
    
}
