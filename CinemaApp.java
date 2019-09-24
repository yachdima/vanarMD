/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemaapp;

import java.util.Scanner;


/**
 *
 * @author yachmenev
 */
public class CinemaApp {

    
        
    public static void main(String[] args) {
        
        // карта расположения сидений в кинозале
        // -1 -> место занято
        // 0  -> место свободно
        // 1  -> место зарезервировано
        int[][] room = {
          {-1, 0, 0, 0, 0, 0, 0,-1 },
          { 0, 0, 0, 1, 1, 1, 0, 0},
          { 0, 0, 0, 0, 0, 0, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 0 },
          { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        // цены для каждого ряда в зале
        int[]   price = {
          100,
          100,
          75,
          75,
          50
        };
        
        Scanner in = new Scanner(System.in);
        
        do{
            System.out.print("Row: ");
            int r = in.nextInt() - 1;
            while(r >= room.length){
               System.out.print("Max row = "+room.length+" please repeat: "); 
               r = in.nextInt() - 1;
            }
            
            System.out.print("Seat: ");
            int m = in.nextInt() - 1;
            while(m >= room[r].length){
               System.out.print("Max seat = "+room[r].length+" please repeat: "); 
               m = in.nextInt() - 1;
            }
            
            int r_r = room[r][m];
            
            if(r_r == 0){
                System.out.println("Svobodno");
                System.out.println("Price: " + price[r]);
                System.out.print("Accept?(Y/N) ");
                String s1 = in.next();
                if(s1.equals("Y")){
                    room[r][m] = 1;
                    
                }
            }
            else{
                System.out.println("Zaneato!");
            }
            
            int free = 0;
            for(int i = 0; i < room.length; i++){
               for (int j = 0; j < room[i].length; j++) { 
                   System.out.print(" " + room[i][j] + " ");
                   if(room[i][j] == 0)
                        free++; 
               }
               System.out.println();
            }
            
            System.out.println("Free: " + free);
       
            System.out.print("Continue?(Y/N) ");
            String s = in.next();
            if(s.equals("N")) break;
            
        } while(true);
        
    }
    
}
