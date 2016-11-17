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
import java.time.LocalDate;
import java.util.*;

public class WeatherStation implements WeatherObserver {


    /**  Data objects
     *
     * Registos do valor de temperaturas
     * Registos do valor de humidade
     * Registos do valor de pressão atmosférica
     * Registos de audio
     * Registos de luminosidade
     * */

    HashMap<LocalDate,Vector<Integer>> temperatura;
    HashMap<LocalDate,Vector<Integer>> humidade;
    HashMap<LocalDate,Vector<Integer>> pressao_atm;
    HashMap<LocalDate,Vector<Integer>> audio;
    HashMap<LocalDate,Vector<Integer>> luminosidade;
    View view;
    
    public WeatherStation() {

        this.humidade = new HashMap<LocalDate,Vector<Integer>>();
        this.temperatura = new HashMap<LocalDate,Vector<Integer>>();
        this.audio = new HashMap<LocalDate,Vector<Integer>>();
        this.luminosidade = new HashMap<LocalDate,Vector<Integer>>();
        this.pressao_atm = new HashMap<LocalDate,Vector<Integer>>();
        
    }

    /**
     * A estção meteriologica recebe updates dos sensores e armazena os valores na estrutura de dados respectiva.
     * @param id identificador do sensor XDK
     * @param values parametros lidos pelo sensor
     *               posição 0 : temperatura
     *               posição 1 : humidade
     *               posição 2 : pressão atmosféria
     *               posição 3 : audio
     *               posição 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values){

        switch (id) {
            case 1: // XDK exterior

                if (this.temperatura.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = temperatura.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(0));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(0));
                    temperatura.put(LocalDate.now(), new_vector);
                }
                if (this.humidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = humidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(1));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(1));
                    humidade.put(LocalDate.now(), new_vector);
                }

                if (this.pressao_atm.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = pressao_atm.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(2));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(2));
                    pressao_atm.put(LocalDate.now(), new_vector);
                }

                if (this.audio.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = audio.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(3));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(3));
                    audio.put(LocalDate.now(), new_vector);
                }
                if (this.luminosidade.get(LocalDate.now()) != null){
                    Vector<Integer> val_temp = luminosidade.get(LocalDate.now());
                    Iterator<Integer> iterator = values.iterator();
                    val_temp.add(values.elementAt(4));
                } else
                {
                    Vector<Integer> new_vector  =  new Vector<Integer>();
                    new_vector.add(values.elementAt(4));
                    luminosidade.put(LocalDate.now(), new_vector);
                }
                
                
            case 2: // XDK interior
                ;
                break;
            default:
                // ignore ;
                break;
        }
        view=new View(temperatura,humidade,pressao_atm,audio,luminosidade);
        view.update(1,values);
    }

/*
    public static void main(String args[]) {

        // Create a hash map
        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        // simular a recepção de valores
        iot.update(1, xdk1_reading_1);
        iot.update(1, xdk1_reading_2);
    }
*/
}
