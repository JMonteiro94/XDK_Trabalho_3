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
public class XDK extends Thread{
    
    View view;
    WeatherStation ws;
    Vector<Integer> valores;
            
    public XDK(WeatherStation ws,Vector<Integer> valores){
        this.view=view;
        this.ws=ws;
        this.valores=valores;
    }
    
    @Override
    public void run() {
            
        //view.update(1,valores);
        ws.update(1,valores);
    }
}
