import java.util.HashMap;

/**
 * Created by WOLF_SKiFF_SSS on 02.03.2016.
 */
public class KeyGen {

    static int[] toKey(String s) {
        String alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";

        int[] key = new int[s.length()];
        HashMap<Character, Integer> list = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            list.put(c, i);
        }
        for (int i = 0; i < s.length(); i++) {
            key[i] = list.get(s.charAt(i));
        }
        return key;
    }
}
