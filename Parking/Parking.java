/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingobjectsapp;

import java.util.ArrayList;

/**
 *
 * @author yachmenev
 */
public class Parking {
    private byte free_places; // кол-во свободных мест на парковке
    private Car place_1A;
    private Car place_1B;
    private Car place_1C;
    private Car place_2A;
    private Car place_2B;
    private Car place_2C;
    // добавьте конструктор класс 
    // так чтобы он изначально устанавливал кол-во свободных мест в - 6
    public Parking(){
        this.free_places = 6;
    }
    
    // добавьте метод "parkCar(Car c,String place)" который припаркует авто
    // на указанное место - как? просто переданный обьект типа "Car" должен быть назначен 
    // тому свойству "place_XX" имя которого переданно через аргумент "place"
    // например "parking.parkCar(c1,"1B")" должен сначало проверить если это место свободно
    // (будем считать что если свойство равно - null тогда место свободно)
    void parkCar(Car c,String place){
        switch (place){
            case "1A": if (place_1A == null) place_1A = c; else System.out.println("Place \"1A\" Taken!");break;
            case "1B": if (place_1B == null) place_1B = c; else System.out.println("Place \"1B\" Taken!");break;
            case "1C": if (place_1C == null) place_1C = c; else System.out.println("Place \"1C\" Taken!");break;
            case "2A": if (place_2A == null) place_2A = c; else System.out.println("Place \"2A\" Taken!");break;
            case "2B": if (place_2B == null) place_2B = c; else System.out.println("Place \"2B\" Taken!");break;
            case "2C": if (place_2C == null) place_2C = c; else System.out.println("Place \"2C\" Taken!");break;
        }

    }
    
    // добавьте метод который выводит кол-во свободных мест на парковке
    void countParkingFreePlace() {
        ArrayList<Car> plArr = new ArrayList<>();
        plArr.add(place_1A);
        plArr.add(place_1B);
        plArr.add(place_1C);
        plArr.add(place_2A);
        plArr.add(place_2B);
        plArr.add(place_2C);
        
        int counter = 0;
        for(int i=0;i<plArr.size(); i++){
            if(plArr.get(i) == null){
                counter++;
            }
        }
        
        System.out.println(counter);
    }
    
    // добавить метод printMap() который выводит в консоль
    // карту мест таким макаром, где Марка - занято, 0 - свободно (null)
    // -------------------
    // | BMW    | 0      |
    // -------------------
    // -------------------
    // | 0      | 0      |
    // -------------------
    // -------------------
    // | 0      |  Fiat  |
    // -------------------
    
    // * ВНИМАНИЕ для вывода марки в нужном месте использовать car.print()
    void printMap() {
        String delim = "-------------------";
        
        System.out.println(delim);
        System.out.print("| "); printCar(place_1A);System.out.print(" | "); printCar(place_2A);System.out.println(" |");
        System.out.println(delim);
        System.out.println(delim);
        System.out.print("| "); printCar(place_1B);System.out.print(" | "); printCar(place_2B);System.out.println(" |");
        System.out.println(delim);
        System.out.println(delim);
        System.out.print("| "); printCar(place_1C);System.out.print(" | "); printCar(place_2C);System.out.println(" |");
        System.out.println(delim);
    }
    
    public static void printCar(Car car){
        if (car == null){
            System.out.print("0     ");
        }else
            car.print();
    }
}
