/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author allan
 */
public class Time {
    private HashMap<String, Jogador> jogadores;

    public Time() {
    }
    
    public Time(HashMap<String, Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public HashMap<String, Jogador> getJogadores(){
        return jogadores;
    }
    
    public void addJogador(String posicao, Jogador jogador){
        jogadores.put(posicao, jogador);
    }
    
    public List<Jogador> ordena(JogadorComparator comparador){
        List<Jogador> ordenado = new ArrayList<>();           
        for(Map.Entry<String,Jogador> entrada: jogadores.entrySet()){
            Jogador c = entrada.getValue();
            ordenado.add(c);
            //System.out.println(entrada.getKey() + ":" + c);
        }
        Collections.sort(ordenado, comparador);
        return ordenado;
    }
}
