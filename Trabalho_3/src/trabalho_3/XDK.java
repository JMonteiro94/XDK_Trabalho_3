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
            
    public XDK(WeatherStation ws){
        this.ws=ws;
    }
   
    //@Override
    public void updateModel(Vector<Integer> valores) {
            
        //view.update(1,valores);
        ws.update(1,valores);
        
    }
    
    public void resetView(){
        view=new View(ws.temperatura,ws.humidade,ws.pressao_atm,ws.audio,ws.luminosidade);
        view.update(1,valores);
    }
}
