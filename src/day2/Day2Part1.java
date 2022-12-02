package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day2Part1 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia2.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);

            String line;
            int accumulatedOfPoints=0;
            String player1Option;
            String player2Option;

            while((line=br.readLine())!=null) {
                System.out.println(line);
                System.out.println(player1Option= line.substring(0,1));
                System.out.println(player2Option= line.substring(line.length()-1));
                //ROCK
                if(player2Option.equals("X")){
                    if(player1Option.equals("A")){
                        accumulatedOfPoints=accumulatedOfPoints+4;
                    }
                    else if(player1Option.equals("B")){
                        accumulatedOfPoints=accumulatedOfPoints+1;
                    }
                    else{
                        accumulatedOfPoints=accumulatedOfPoints+7;
                    }
                }
                //PAPER
                if(player2Option.equals("Y")){
                    if(player1Option.equals("A")){
                        accumulatedOfPoints=accumulatedOfPoints+8;
                    }
                    else if(player1Option.equals("B")){
                        accumulatedOfPoints=accumulatedOfPoints+5;
                    }
                    else{
                        accumulatedOfPoints=accumulatedOfPoints+2;
                    }
                }
                //SCISSOR
                if(player2Option.equals("Z")){
                    if(player1Option.equals("A")){
                        accumulatedOfPoints=accumulatedOfPoints+3;
                    }
                    else if(player1Option.equals("B")){
                        accumulatedOfPoints=accumulatedOfPoints+9;
                    }
                    else{
                        accumulatedOfPoints=accumulatedOfPoints+6;
                    }
                }
            }
            System.out.println(accumulatedOfPoints);
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