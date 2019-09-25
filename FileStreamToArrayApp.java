/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestreamtoarrayapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yachmenev
 */
public class FileStreamToArrayApp {
    public static Car[] cars;
    
    public static void main(String[] args) throws IOException {
            
        String filename = "cars.txt";
        loadFileToArray(filename);
        printArrayData();
    }
    
    public static void loadFileToArray( String filename ) throws FileNotFoundException, IOException {
            
        File file = new File(filename);
          Scanner scanner = new Scanner(file);
          scanner.useDelimiter(System.getProperty("line.separator"));
          
          ArrayList<Car> garage = new ArrayList<>();
          
       
          while(scanner.hasNext()){
            String line = scanner.next();
            String[] words = line.split(" ");
      
            Car car = new Car(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]));
            garage.add(car);
       
            }
        scanner.close();
        
        cars = new Car[garage.size()];
        garage.toArray(cars);
    }

    public static void printArrayData() {
      
        int i = 1;
        for(Car cars: cars){
            System.out.println(i+cars.toString());
            i++;
        }
    }
}
