/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.Comparator;

/**
 *
 * @author allan
 */
public class JogadorComparator implements Comparator<Jogador> {

    private boolean ordena_numero;
    private boolean numero_ascendente;
    private boolean nome_ascendente;
    
    public JogadorComparator() {
        this.ordena_numero = true;
        this.numero_ascendente = true;
        this.nome_ascendente = true;
    }    
    
    public JogadorComparator(boolean ordena_numero, boolean numero_ascendente, boolean nome_ascendente) {
        this.ordena_numero = ordena_numero;
        this.numero_ascendente = numero_ascendente;
        this.nome_ascendente = nome_ascendente;
    }

    public boolean isOrdena_numero() {
        return ordena_numero;
    }

    public void setOrdena_numero(boolean ordena_numero) {
        this.ordena_numero = ordena_numero;
    }

    public boolean isNumero_ascendente() {
        return numero_ascendente;
    }

    public void setNumero_ascendente(boolean numero_ascendente) {
        this.numero_ascendente = numero_ascendente;
    }

    public boolean isNome_ascendente() {
        return nome_ascendente;
    }

    public void setNome_ascendente(boolean nome_ascendente) {
        this.nome_ascendente = nome_ascendente;
    }
    
    private int comparaNumero(Jogador j1, Jogador j2) {
        if(numero_ascendente){
            return (j1.getNumero() - j2.getNumero());
        }else{
            return -(j1.getNumero() - j2.getNumero());
        }
    }

    private int comparaNome(Jogador j1, Jogador j2) {
        if(nome_ascendente){
            return j1.getNome().compareTo(j2.getNome());
        }else{
            return -(j1.getNome().compareTo(j2.getNome()));
        }
    }

    @Override
    public int compare(Jogador j1, Jogador j2) {
        int comp;
        if (ordena_numero) {
            comp = comparaNumero(j1, j2);
            if (comp == 0) comp = comparaNome(j1, j2);
        } else {
            comp = comparaNome(j1, j2);
            if (comp == 0) comp = comparaNumero(j1, j2);
        }
        return comp;
    }
}
