package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day5Part3 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File ("inputData/dia5test.txt");
            fr = new FileReader (file);
            br = new BufferedReader(fr);
            int boxToMove=0;
            int originColum = 0;
            int destinationColum = 0;


            String line;
            List<List<String>> port = new ArrayList<>(List.of(
                    new ArrayList<>(List.of("Z","N")),
                    new ArrayList<>(List.of("M", "C", "D")),
                    new ArrayList<>(List.of("P"))
            ));

            while((line=br.readLine())!=null) {
                if(!line.equals("")) {
                    List <String> movingBoxes = new ArrayList<>();
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

                            movingBoxes.add(port.get(originColum-1).get(port.get(originColum-1).size()-1));
                            port.get(originColum-1).remove(port.get(originColum-1).size()-1);
                        }

                        for (int j =boxToMove; j >0; j--) {
                            port.get(destinationColum - 1).add(movingBoxes.get(j-1));
                        }
                        System.out.println(port);
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