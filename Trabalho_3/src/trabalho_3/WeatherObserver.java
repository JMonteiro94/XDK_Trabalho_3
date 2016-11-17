/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_3;

/**
 *
 * @author User
 */
import java.util.Vector;

public interface WeatherObserver {
    void update(int id, Vector<Integer> values);
    //void update();
}
