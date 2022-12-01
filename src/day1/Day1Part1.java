package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day1Part1 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia1.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            String line;
            int accumulatedOfElfCalories=0;
            int theBiggestCalories=0;
            while((line=br.readLine())!=null) {
                System.out.println(line);
                if (!line.equals("")) {
                    accumulatedOfElfCalories = accumulatedOfElfCalories + Integer.parseInt(line);
                } else {
                    if (theBiggestCalories < accumulatedOfElfCalories) {
                        theBiggestCalories = accumulatedOfElfCalories;
                    }
                    accumulatedOfElfCalories = 0;
                }
            }
            System.out.println(theBiggestCalories);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}