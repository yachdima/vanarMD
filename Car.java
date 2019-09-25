/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestreamtoarrayapp;

/**
 *
 * @author yachmenev
 */
class Car {
    String model;
    Integer year;
    Integer km;
    Integer price;
    // добавить конструктор и toString()
    // БОНУС - валидировать данные (вдруг отрицательный год или прайс)
    
    public Car(String model,int year,int km,int price){
        this.model = model;
        this.year = year;
        this.km = km;
        this.price = price;
    } 
    
    @Override
    public String toString(){
        return ". CAR: "+model+" "+year+" "+km+"km "+price+"USD";
    }
}
