/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingobjectsapp;

/**
 *
 * @author yachmenev
 */
public class ParkingObjectsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // для начала - доделайте код классов Parking, Car
        // а потом код этого метода так чтобы
        Parking lux_parking = new Parking(); // создан был новый обьект парковки
        // припарковать 2 авто
        Car my_car = new Car("BMW 7");
        Car friend_car = new Car("BMW 5");
        lux_parking.parkCar(my_car,"1A");
        lux_parking.parkCar(friend_car,"1C");

        // попытка припарковать на занятое место - сообщение об ошибке
        Car wrong_car = new Car("FIAT");
        lux_parking.parkCar(wrong_car,"1A"); // "Place "1A" Taken!" - так должо выводится

        // печатаем карту
        lux_parking.printMap();
        // так выглядит результат
        // -------------------
        // | BMW 7  | 0      |
        // -------------------
        // -------------------
        // | 0      | 0      |
        // -------------------
        // -------------------
        // | BMW 5  | 0      |
        // -------------------
    }
    
}

