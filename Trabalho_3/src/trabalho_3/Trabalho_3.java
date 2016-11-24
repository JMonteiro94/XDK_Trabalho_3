/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_3;

import java.util.Vector;

/**
 *
 * @author User
 */
public class Trabalho_3 {

    public static void main(String[] args) {
        
        View view;
        WeatherStation iot = new WeatherStation();
        XDK xdk;
        Thread t,t1;
        xdk=new XDK(iot);
        // Create a hash map
        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);
        //xdk=new XDK(iot,view);
        //xdk=new XDK(iot,xdk1_reading_1);
        //t=new Thread(xdk);
        //t.start();
        
        xdk.updateModel(xdk1_reading_1);
        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);
        //xdk=new XDK(iot,xdk1_reading_2);
        //t1=new Thread(xdk);
        //t1.start();
        
        xdk.updateModel(xdk1_reading_2);
        xdk.resetView();
    }
    
}
