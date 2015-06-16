/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author allan
 */
public class Time {
    private ArrayList<Jogador> time;

    public Time() {
        this.time = new ArrayList<>();
    }

    public Time(ArrayList<Jogador> time) {
        this.time = time;
    }

    public ArrayList<Jogador> getTime() {
        return time;
    }

    public void setTime(ArrayList<Jogador> time) {
        this.time = time;
    }
            
    public ArrayList<Jogador> getJogadores(){
        return time;
    }
    
    public void addJogador(int numero, String nome){
        time.add(new Jogador(numero, nome));
    }
            
    public ArrayList<Jogador> ordena(JogadorComparator comparador){
        Collections.sort(time, comparador);
        return time;
    }        
}
