import java.util.HashMap;

/**
 * Created by WOLF_SKiFF_SSS on 02.03.2016.
 */
public class Vigenere {
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;
    Vigenere[] ciphers;

    public Vigenere(int key) {
        theKey = key;
        alphabet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    public Vigenere(int[] key) {
        ciphers = new Vigenere[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new Vigenere(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            Vigenere thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            Vigenere thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }
}
