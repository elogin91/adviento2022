package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day3Part2 {
    public static void main(String[] args) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File("inputData/dia3.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);


            String firstElf;
            String secondElf;
            String thirdElf;
            char itemRepeat = ' ';
            int point = 0;
            char[] itemValue = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T','U', 'V', 'W', 'X', 'Y', 'Z'};

            while ((firstElf = br.readLine()) != null) {

                System.out.println(firstElf);
                System.out.println(secondElf= br.readLine());
                System.out.println(thirdElf= br.readLine());

                for (int i = 0; i < firstElf.length(); i++) {
                    for (int k = 0; k < secondElf.length(); k++) {
                        if ((firstElf.charAt(i)) == (secondElf.charAt(k))) {
                            for (int l = 0; l < thirdElf.length(); l++) {
                                if ((firstElf.charAt(i)) == (thirdElf.charAt(l))) {
                                    itemRepeat = firstElf.charAt(i);
                                    //Point of Item
                                    for (int j = 0; j < itemValue.length; j++) {
                                        if (itemValue[j] == itemRepeat) {
                                            System.out.println("Letter: " + itemRepeat + "(" + (j + 1) + ")");
                                            point = point + j + 1;
                                            System.out.println(point);
                                            k = secondElf.length();
                                            i = firstElf.length();
                                            l = thirdElf.length();
                                        }
                                    }
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
