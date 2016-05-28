import com.sun.xml.internal.ws.api.config.management.policy.ManagedClientAssertion;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import java.util.*;

/**
 * Created by WOLF_SKiFF_SSS on 02.03.2016.
 */
public class VigenereBreaker{

   private static String sliceString(String message, int whichSlice, int totalSlices) {
        int length = message.length();
        int lengthOfKey = totalSlices;
        String answer = "";
        for(int start = whichSlice;start<length;start +=lengthOfKey){
            answer = answer + message.charAt(start);
        }
        return answer;
    }

    /*public  List<String> text_divide(String answer,int keyLen){
        List<String> Y = new ArrayList<>();
        for(int i=0;i<)
        return Y;
    }*/



   public  List<String> text_divide (String a){
        List<String> Y = new ArrayList<>();
        //k - ДЛИНА КЛЮЧА 1<k<5
        for(int i = 0, k = 3; i<k;i++) {
            Y.add(sliceString(a,i,k));

        }
        return Y;
    }


    /*public static Map<Map<Character,Double>,Integer> N (List<String>Y){
        FreqCounter fc = new FreqCounter();
        Map<Map<Character,Double>,Integer> NY = new HashMap<>();
        for(String s : Y){
           // System.out.println(fc.LeCount(s));
            if(NY.keySet().contains(fc.LeCount(s))) {
                NY.put(fc.LeCount(s), NY.get(fc.LeCount(s))+1);
            }else{
                NY.put(fc.LeCount(s),1);
            }
        }
        return NY;
    }*/
    public static Map<Character,Double> n (List<String> Y){
        Map<Character,Double> NY = new HashMap<>();
        for(String s : Y) {
            for(int i = 0 ; i < s.length(); i ++){
                char c = s.charAt(i);
                if(NY.keySet().contains(c)){
                    NY.put(c,NY.get(c)+1);
                }else {
                    NY.put(c,1.0);
                }
            }
        }
        return NY;
    }
    public double IY(List<String> Y){
        double total = 0;
        List<Double> LeCount = new ArrayList<>();//сумма  каждой буквы во всех строках
        Map<Character,Double> NY = new HashMap<>();
        //List<Double> NK = new ArrayList<>();
        List<Integer>Ylen = new ArrayList<>();//длина входящих строк
        double NK = 0;
        double I = 0;
        for(String s : Y){
            Ylen.add(s.length());
            NY = n(Y);
        }
        for(double i : NY.values()){
           //System.out.println(i);
            LeCount.add(i);
        }
        for(double i : LeCount){
            NK = NK +(i * (i-1));
            //NK.add(i * (i-1));
            System.out.println(NK);
        }

        for (int i : Ylen){
            I = NK/(i * (i-1));
            //System.out.println("I " + I);
            System.out.println(i);
            total +=I;

        }
        System.out.println(Ylen);
        return total/32;
    }
    /** Выводит строку и кол-во букв**/
   /* public static Map<Map<Character,Double>,String> N (List<String>Y){
        FreqCounter fc = new FreqCounter();
        Map<Map<Character,Double>,String> NY = new HashMap<>();
        for(String s : Y){
            // System.out.println(fc.LeCount(s));
            if(NY.keySet().contains(fc.LeCount(s))) {
                NY.put(fc.LeCount(s), NY.get(fc.LeCount(s))+1);
            }else{
                NY.put(fc.LeCount(s),s);
            }
        }
        return NY;
    }*/

 /*  public void IY (List<String> Y) {
       Map<Map<Character,Double>,Integer> NY = new HashMap<>();
       List<Set<Map<Character,Double>>> map = new ArrayList<>();
       double total = 0;
       int NK = 0;
       for (int i = 0; i < Y.size();) {
            NY = N(Y);
            break;
       }
       for (Iterator it = NY.entrySet().iterator(); it.hasNext();){
           Map.Entry entry = (Map.Entry) it.next();
           //System.out.println("Key: " + entry.getKey());
       }
       for (int i = 0 ; i < NY.size(); ){
           map.add(0,NY.keySet());
           break;
       }
       for (NY.keySet())


        System.out.println(map);
    }*/



}
