/* Word Frequency Counter
Read a text file and count the frequency of each word using a HashMap. Ignore case and punctuation.
Example:
Input: "Hello world, hello Java!" → Output: {hello=2, world=1, java=1}
 */
package com.map_interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
public class WordFrequencyCounter {

    public static void main(String[] args) {
        try {
            String path = "D:\\Week_04\\Day_02\\src\\main\\java\\com\\map_interface\\TextFile.txt";
            FileReader fr= new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                HashMap<String,Integer>mp=new HashMap<>();
                s= s.toLowerCase();
                String []arr=s.split("[ ,!.]+");
                for(String it:arr){
                    mp.put(it,mp.getOrDefault(it,0)+1);
                }
                System.out.println("frequency of words in given string is:"+mp);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
