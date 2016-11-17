/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_3;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author User
 */
public class View implements WeatherObserver{
    
    HashMap<LocalDate,Vector<Integer>> temperatura;
    HashMap<LocalDate,Vector<Integer>> humidade;
    HashMap<LocalDate,Vector<Integer>> pressao_atm;
    HashMap<LocalDate,Vector<Integer>> audio;
    HashMap<LocalDate,Vector<Integer>> luminosidade;
    
    public View(HashMap<LocalDate,Vector<Integer>> temperatura,HashMap<LocalDate,Vector<Integer>> humidade
    ,HashMap<LocalDate,Vector<Integer>> pressao_atm,HashMap<LocalDate,Vector<Integer>> audio    
    ,HashMap<LocalDate,Vector<Integer>> luminosidade){
        this.temperatura=temperatura;
        this.humidade=humidade;
        this.pressao_atm=pressao_atm;
        this.audio=audio;
        this.luminosidade=luminosidade;
    }
    
    @Override
    public void update(int id, Vector<Integer> values){
        mostra_temperatura();
        mostra_max_minimo(LocalDate.now(), 0);
        mostra_max_minimo(LocalDate.now(), 1);
        mostra_max_minimo(LocalDate.now(), 2);
        mostra_max_minimo(LocalDate.now(), 3);
        mostra_max_minimo(LocalDate.now(), 4);
        mostra_presao_atm();
        mostra_humidade();
        mostra_media(LocalDate.now(),0);
        mostra_ultimos_dias(0,2);
    }
    
    public void mostra_temperatura(){
        int i = -100;
        if (temperatura.containsKey(LocalDate.now())){
            int size = this.temperatura.get(LocalDate.now()).size();
            i = this.temperatura.get(LocalDate.now()).elementAt(size-1);
        }
        System.out.println("Tempertura Actual: " + i);
    }

    public void mostra_humidade(){
        int value = -100;
        if (humidade.containsKey(LocalDate.now())){
            int size = this.humidade.get(LocalDate.now()).size();
            value = this.humidade.get(LocalDate.now()).elementAt(size-1);
        }
        System.out.println("Humidade Actual: " + value);
    }

    public void mostra_presao_atm(){
        int value = -100;
        if (pressao_atm.containsKey(LocalDate.now())){
            int size = this.pressao_atm.get(LocalDate.now()).size();
            value = this.pressao_atm.get(LocalDate.now()).elementAt(size-1);
        }
        System.out.println("pressao atmosférica actual: " + value);
    }

    public void mostra_audio(){
        int value = -100;
        if (audio.containsKey(LocalDate.now())){
            int size = this.audio.get(LocalDate.now()).size();
            value = this.audio.get(LocalDate.now()).elementAt(size-1);
        }
        System.out.println("Audio actual: " + value);
    }

    public void mostra_luminusidade(){
        int value = -100;
        if (luminosidade.containsKey(LocalDate.now())){
            int size = this.luminosidade.get(LocalDate.now()).size();
            value = this.luminosidade.get(LocalDate.now()).elementAt(size-1);
        }
        System.out.println("Audio actual: " + value);
    }

    /**
     * Funcionalidade: mostra a média da temperatura para um determinado dia
     * @param data dia a considerar para a média
     * @param sensor sensor a calcular: 0 temperatura
     */
    public void mostra_media(LocalDate data, int sensor){

        switch (sensor) {
            case 0: //temperatura
                if (false != this.temperatura.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : this.temperatura.get(data)) {
                        sum += val;
                    }

                    System.out.println("Média temperatura: " + sum/this.temperatura.get(data).size());
                }
                break;
            case 1: //temperatura
                if (false != this.humidade.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : this.humidade.get(data)) {
                        sum += val;
                    }

                    System.out.println("Média humidade: " + sum/this.humidade.get(data).size());
                }
                break;
        }
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos de um determinado sensor para um determinado dia.
     * @param data dia a considerar para recolher o valor máximo e minímo
     * @param sensor valor do sensor a recolher: temperatura, humidade, pressão atm, audio, luminosidade
     */
    public void  mostra_max_minimo(LocalDate data, int sensor){

        switch (sensor) {
            case 0: //temperatura
                if ( false != this.temperatura.containsKey(data)){
                Vector<Integer> v = this.temperatura.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max temperatura: "+max+" Min temperatura: "+min);
                }
                break;
            case 1: //humidade
                if ( false != this.humidade.containsKey(data)){
                    Vector<Integer> v = this.humidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max humidade: "+max+" Min humidade: "+min);
                }
                break;
            case 2: //pressão atmosférica
                if ( false != this.pressao_atm.containsKey(data)){
                    Vector<Integer> v = this.pressao_atm.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max pressão atmosférica: "+max+" Min pressão atmosférica: "+min);
                }
                break;
            case 3: //audio
                if ( false != this.audio.containsKey(data)){
                    Vector<Integer> v = this.audio.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max Audio: "+max+" Min Audio: "+min);
                }
                break;
            case 4: //luminosidade
                if ( false != this.luminosidade.containsKey(data)){
                    Vector<Integer> v = this.luminosidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    System.out.println("Max Luminosidade: "+max+" Min Luminosidade: "+min);
                }
                break;
            default:
                break;
        }
    }

    /**
     * Mostrar dos ultimos X dias os valores máximos e minumos de um sensor
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    public void mostra_ultimos_dias(int sensor, int dias) {

        int dias_counter = dias-1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();
        Vector max_min_values = new Vector();
        switch (sensor) {
            case 0: //temperatura
                LocalDate today = LocalDate.now();
                while (dias_counter >= 0) {

                    if (false != this.temperatura.containsKey(today.minusDays(dias_counter))) {
                        Vector<Integer> temp_values = this.temperatura.get(today.minusDays(dias_counter));
                        max_min_values.add(Collections.max(temp_values));
                        max_min_values.add(Collections.min(temp_values));
                        last_values.put(today.minusDays(dias_counter), max_min_values);

                    }
                    dias_counter -= 1;
                }
                break;
        }
        System.out.println("Valores máximos e mínimos: "+last_values.toString());
    }
}
