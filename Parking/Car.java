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
public class Car {
    private String model;
    // добавить конструктор
    public Car(String model){
        this.model = model;
    }
    // сеттер / геттер
    public String getCar(){
        return model;
    }
    
    public void setCar(String model){
        this.model = model;
    }
    
    // и print() который выводит модель авто в консоль
    public void print(){
        String str = model+"      ";
        System.out.print(str.substring(0,6));
    }
}
