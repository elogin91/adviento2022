package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Part1 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia5.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            int boxToMove=0;
            int originColum = 0;
            int destinationColum = 0;


            String line;
            List<List<String>> port = new ArrayList<>(List.of(
                    new ArrayList<>(List.of("Z", "T", "F","R","W","J","G")),
                    new ArrayList<>(List.of("G", "W", "M")),
                    new ArrayList<>(List.of("J", "N", "H","G")),
                    new ArrayList<>(List.of("J", "R", "C","N","W")),
                    new ArrayList<>(List.of("W", "F", "S","B","G","Q","V","M")),
                    new ArrayList<>(List.of("S", "R", "T","D","V","W","C")),
                    new ArrayList<>(List.of("H", "B", "N","C","D","Z","G", "V")),
                    new ArrayList<>(List.of("S", "J", "N","M","G","C")),
                    new ArrayList<>(List.of("G", "P", "N","W","C","J","D","L"))

            ));

            while((line=br.readLine())!=null) {
                if(!line.equals("")) {
                    if (line.substring(0,4).equals("move")){

                        String[] ranges = line.split(" ");

                        System.out.println(ranges[0]);
                        boxToMove = Integer.parseInt(ranges [1]);
                        originColum = Integer.parseInt(ranges [3]);
                        destinationColum = Integer.parseInt(ranges [5]);

                        System.out.println(boxToMove);
                        System.out.println(originColum);
                        System.out.println(destinationColum);

                        for(int i=boxToMove; i > 0; i--) {
                            String miBox =port.get(originColum-1).get(port.get(originColum-1).size()-1);
                            port.get(originColum-1).remove(port.get(originColum-1).size()-1);
                            port.get(destinationColum-1).add(miBox);
                        }
                    }
                }
            }
            System.out.println(port);
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