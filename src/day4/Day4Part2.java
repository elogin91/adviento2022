package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day4Part2 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia4.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            String line;
            int repeatSections = 0;

            while((line=br.readLine())!=null) {

                System.out.println(line);
                String[] ranges = line.split(",");
                String[] firstNumbers = ranges[0].split("-");
                //firstNumbers [0] y firstNumbers [1]
                String[] secondNumbers = ranges[1].split("-");
                //secondNumbers [0] y secondNumbers [1]

                if(Integer.parseInt(firstNumbers[0])>=Integer.parseInt(secondNumbers[0]) && Integer.parseInt(firstNumbers[0])<=Integer.parseInt(secondNumbers[1])) {
                    repeatSections++;
                }
                else if(Integer.parseInt(firstNumbers[1])>=Integer.parseInt(secondNumbers[0]) && Integer.parseInt(firstNumbers[1])<=Integer.parseInt(secondNumbers[1])) {
                    repeatSections++;
                }
                else if(Integer.parseInt(firstNumbers[0])<=Integer.parseInt(secondNumbers[0]) && Integer.parseInt(firstNumbers[1])>=Integer.parseInt(secondNumbers[0])) {
                    repeatSections++;
                }
                else if(Integer.parseInt(firstNumbers[0])<=Integer.parseInt(secondNumbers[1]) && Integer.parseInt(firstNumbers[1])>=Integer.parseInt(secondNumbers[1])) {
                    repeatSections++;
                }
            }
            System.out.println(repeatSections);
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