package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Day1Part2 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia1.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            String line;
            int accumulatedElfCalories=0;
            int [] fattestThreeElf =  new int[3];
            while((line=br.readLine())!=null) {
                System.out.println(line);
                if (!line.equals("")) {
                    accumulatedElfCalories = accumulatedElfCalories + Integer.parseInt(line);
                } else {
                    if (fattestThreeElf[0] < accumulatedElfCalories) {
                        fattestThreeElf[0] = accumulatedElfCalories;
                        Arrays.sort(fattestThreeElf);
                    }
                    accumulatedElfCalories = 0;
                }
            }
            for(int i = 0; i< fattestThreeElf.length ; i++) {
                System.out.println("---"+ fattestThreeElf[i]);
            }
            int sum= Arrays.stream(fattestThreeElf).sum();
            System.out.println(sum);
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