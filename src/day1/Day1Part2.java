package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Day1Part2 {
    public static void main(String[] args) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("C:\\Users\\xesa\\OneDrive\\Escritorio\\Adviento\\dia1.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int acumuladorCalorias=0;
            int [] acumulacionGrande =  new int[3];
            while((linea=br.readLine())!=null) {
                System.out.println(linea);
                if (!linea.equals("")) {
                    acumuladorCalorias = acumuladorCalorias + Integer.parseInt(linea);
                } else {
                    if (acumulacionGrande[0] < acumuladorCalorias) {
                        acumulacionGrande[0] = acumuladorCalorias;
                        Arrays.sort(acumulacionGrande);

                    }
                    acumuladorCalorias = 0;
                }
            }
            for(int i = 0; i< acumulacionGrande.length ; i++) {
                System.out.println("---"+ acumulacionGrande[i]);
            }
            int sum= Arrays.stream(acumulacionGrande).sum();
            System.out.println(sum);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos

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