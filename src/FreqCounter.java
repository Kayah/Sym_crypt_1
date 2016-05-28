
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by WOLF_SKiFF_SSS on 28.02.2016.
 */
public class FreqCounter {
    HashMap<Character, Double> letterCount ;

    static String read() throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(new FileInputStream("data/text_clear.txt"),"Cp1251");
        while(in.hasNext())
            sb.append(in.nextLine() + "\r\n");
        in.close();
        return sb.toString().toLowerCase();
    }

    public Map<Character,Double> LeCount(String text) {
        String alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя ";
        for (int k = 0; k < alphabet.length(); k++){
           char letter = alphabet.charAt(k);
            letterCount = new HashMap<Character, Double>();
            for (int i = 0; i < text.length(); ++i) {
                char c = text.charAt(i);
                /*   Для подсчета без пробелов - убрать комментарии   */
                //if (Character.isLetter(c)) {
                    if (letterCount.containsKey(c)) {
                        letterCount.put(c, letterCount.get(c) + 1);

                    } else {
                        letterCount.put(c, 1.0);
                    }
                }

            //}
           // if (letterCount.get(letter) == null){}
          // else{
                // System.out.println("Число повторов буквы "+ letter +" - "+letterCount.get(letter));
          // }
        }
        return letterCount;
    }

    public Map<Character,Double>  LeFreq(Map<Character,Double>map)throws Exception{//Map<Character,Double>
        FreqCounter fc = new FreqCounter();
        HashMap<Character,Double> l = new HashMap<>();
        int count = 0;
        double freq = 0;
        map = fc.LeCount(read());
        for(Double a :map.values()){
            count += a;
        }
        System.out.println("Всего букв в тексте - " + count);
        for(Map.Entry entry : map.entrySet() ){
            Character key = (Character) entry.getKey();
            Double value = (Double) entry.getValue();
            freq = (double) value/count;
            l.put(key,freq);
            System.out.println("Частота буквы "+ "'" + key + "'" + " в тексте " + "\t" + freq);

        }
        return l;
    }

    public HashMap<String,Double> BeCount(List<String> be) {
        HashMap<String,Double> map = new HashMap<>();
        String a = null;
        int count = 0;
        for(String s : be){
            count ++;
            if(map.keySet().contains(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1.0);
            }
           // System.out.println(map.get(s) + "\t"+s + "\t" + count);
        }
        return map;
    }
    private static double log2(double a) {
        return Math.log(a) / Math.log(2);
    }

    public double entropy (Map<String,Double> map){
        double n = 0;
        double H = 0;
        for (Double i : map.values()){
            n+=i;
        }
        for(Map.Entry en : map.entrySet()){
            double p = (double)en.getValue() / n;
            H += p * log2(p);
        }
        return -H/2;
    }
    public double LeEntropy (Map<Character,Double> map){
        double k = 0;
        double H = 0;
        for (Double i : map.values()){
            k+=i;
        }
        for(Map.Entry en : map.entrySet()){
            double p = (double)en.getValue() / k;
            H += p * log2(p);
        }
        return -H;
    }

    public HashMap<String,Double> BeFreq(HashMap<String,Double> s)throws Exception{
        HashMap<String,Double> l = new HashMap<>();
        FreqCounter fc = new FreqCounter();
        int count = 0;
        double freq = 0;
        for(Double a :s.values()){
            count += a;
        }
        System.out.println("Все биграмм в тексте - " + count);
        for(Map.Entry entry : s.entrySet()) {
            String key = (String) entry.getKey();
            Double value = (Double) entry.getValue();
            freq = (double) value / count;
            l.put(key,freq);
           // System.out.println("Частота биграмм - " + "'" + key + "'" + " в тексте " + "\t" + freq + " \t");
        }
      //  for(Map.Entry en : l.entrySet() ){
          //  System.out.println(en);
        //}
        return l;
    }

    static List<String> getFromString(String s){
        char mas[] = s.toCharArray();
        List<String> list = new ArrayList<>();
        if(mas.length % 2 == 1 ){

            for (int i = 0 ; i< mas.length-2 ; i=i+1 ){
                list.add(mas[i]+""+mas[i+1]);
            }
            list.add(mas[mas.length-1]+"");
        }
        else {
            for (int i = 0 ; i< mas.length-1 ; i=i+1){
                list.add(mas[i]+""+mas[i+1]);
            }
        }
        return list;
    }

    public static void main(String[] args)throws Exception{
        FreqCounter fc = new FreqCounter();
        String key = "Баг";
        Vigenere vg = new Vigenere(KeyGen.toKey(key.toLowerCase()));
        VigenereBreaker vb = new VigenereBreaker();


        //try{//fc.LeCount(read());
            /*Рабочий Метод ! fc.LeFreq(fc.LeCount(read()));
            //fc.BeCount(getFromString(read()));
           /* Рабочий метод for(String s : getFromString(read())){
                System.out.println(s);
            }*/
            //fc.BeFreq(fc.BeCount(getFromString(read())));
            //fc.LeFreq(fc.LeCount(read()));
           // System.out.println(fc.entropy(fc.BeCount(getFromString(read()))));
            //System.out.println(fc.LeEntropy(fc.LeCount((read()))));

            String a = "ьиччеэыившырхруътщьиьэечжмлэеыуацузнукуъепуиьномщдшщйишцухлщъепуиьумчртыучшжехыиъэоьусэрмжэахсеьумчртыучшщегуфыщвлширьиччеэыившыргияыылшгцьпщьомгияыонлнуквхщтщыочплкгияыонлнукиылсгуфыщвжнашуяъыичрнкртькопунуэоэсехыиъэооыаяучрькуфкцйчпщитщбыртршикьхрчыльиччеэыившоощшуярщнашуярпишьтнрншжмьющрьтнщвлншучсъщсщмочквцклщьььумчртыучшщегуфыщвлширхлйвацооыутчлдщцжршсщарлшяэзскнсрхррэещмеучиьэоыщнлчи";
            String z = "хлрь б пюкьы дшхтц цобнрюё";
            int counter = 0;

        //System.out.println(vb.text_divide(z));
        //System.out.println((vb.IY(vb.text_divide(z))));
       for(String s : vb.text_divide(a)) {
            counter ++;
            //System.out.println(vb.n(vb.text_divide(s))); //Для строк "s" из "а" выводит частоту букв
            System.out.println((vb.IY(vb.text_divide(s))));//Выводит Y для каждой строки
            //double value = vb.IY(vb.text_divide(s));
        /*System.out.println(vb.text_divide(a));*//** Узнать количество букв и какие строки при ключе 5 */
        System.out.println(vb.n(vb.text_divide(s)));
        }
        //System.out.println(vb.text_divide(a));

       // System.out.println(vb.n(vb.text_divide(a)));
        //System.out.println(vb.IY(vb.text_divide(a)));
       // vb.IY(vb.text_divide(a));

        //}catch (IOException e){
         //  throw new RuntimeException(e);
        //}
    }
}
