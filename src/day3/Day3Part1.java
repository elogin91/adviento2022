package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day3Part1 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File("inputData/dia3.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            String firstCompartment;
            String secondCompartment;
            char itemRepeat = ' ';
            int point = 0;
            char[] itemValue = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T','U', 'V', 'W', 'X', 'Y', 'Z'};

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println(firstCompartment = line.substring(0, line.length() / 2));
                System.out.println(secondCompartment = line.substring((line.length() / 2), line.length()));

                for (int i = 0; i < firstCompartment.length(); i++) {
                    for (int k = 0; k < secondCompartment.length(); k++) {
                        if ((firstCompartment.charAt(i)) == (secondCompartment.charAt(k))) {
                            itemRepeat = firstCompartment.charAt(i);
                            //Point of Item
                            for (int j = 0; j < itemValue.length; j++) {
                                if (itemValue[j] == itemRepeat) {
                                    System.out.println("Letter: " + itemRepeat + "(" + (j + 1) + ")");
                                    point = point + j + 1;
                                    System.out.println(point);
                                    k = secondCompartment.length();
                                    i = firstCompartment.length();
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(point);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
