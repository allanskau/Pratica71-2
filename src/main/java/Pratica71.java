
import com.sun.org.apache.bcel.internal.Repository;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;
import utfpr.ct.dainf.if62c.pratica.Time;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica71 {
    public static void main(String[] args) {
        Time time1 = new Time();
        int n_jogadores;
        System.out.println("Digite o numero de jogadores:");
        Scanner scanner = new Scanner(System.in);
        n_jogadores = scanner.nextInt();
        //String posicao;
        int numero;
        String nome;
        for(int i = 0; i < n_jogadores; i ++){
            //System.out.println("Digite a posicao do novo jogador:");
            //posicao = scanner.next();
            System.out.println("Digite o numero do novo jogador:");
            numero = scanner.nextInt();
            if(numero < 1 || numero > 24){
                int flag = 0;
                while(flag == 0){
                    System.out.println("umero invalido. Digite o numero do novo jogador:");
                    numero = scanner.nextInt();
                    if(numero > 0 && numero < 25){
                        flag = 1;
                    }
                }
            }
            System.out.println("Digite o nome do novo jogador:");
            nome = scanner.next();
            time1.addJogador(numero, nome);
            //time1.addJogador(posicao, new Jogador(numero, nome));
        }
        /*
        time1.addJogador("zagueiro", new Jogador(4, "lucas"));
        time1.addJogador("goleiro base", new Jogador(1, "juca"));
        time1.addJogador("goleiro reserva", new Jogador(11, "joao"));
        time1.addJogador("lateral esquerdo", new Jogador(4, "jose"));
        time1.addJogador("goleiro substituto", new Jogador(1, "adriano"));
        time1.addJogador("atacante", new Jogador(15, "mario"));
        time1.addJogador("goleiro", new Jogador(1, "fulano"));
        time1.addJogador("lateral direito", new Jogador(14, "mario"));
        Time time2 = new Time(time1.getJogadores());
        /*
        Time time2 = new Time(new HashMap<>());
        time2.addJogador("goleiro", new Jogador(1, "fulano"));
        time2.addJogador("lateral", new Jogador(4, "ciclano"));
        time2.addJogador("atacante", new Jogador(15, "beltrano"));
        */
        JogadorComparator comparador = new JogadorComparator(false, true, false){};
        List<Jogador> ordenados = time1.ordena(comparador);
        String format = "%3d %-20s";
        System.out.println("Escalacao do time:");
        System.out.println("Num Nome");
        for (Jogador j: ordenados) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }
        int flag = 0;
        while(flag == 0){
            //System.out.println("Digite a posicao do novo jogador:");
            //posicao = scanner.next();
            System.out.println("Digite o numero do novo jogador:");
            numero = scanner.nextInt();
            if(numero < 0 || numero > 24){
                int flag2 = 0;
                while(flag2 == 0){
                    System.out.println("umero invalido. Digite o numero do novo jogador:");
                    numero = scanner.nextInt();
                    if(numero > 0 && numero < 25){
                        flag2 = 1;
                    }
                }
            }else if(numero == 0){
                flag = 1;
            }else{
                System.out.println("Digite o nome do novo jogador:");
                nome = scanner.next();
                //time1.addJogador(posicao, new Jogador(numero, nome));
                if(ordenados.get(ordenados.size() - 1).getNumero() < numero){
                    ordenados.add(new Jogador(numero, nome));
                }else{
                    int i = 0;
                    for (Jogador j: ordenados) {
                        if(j.getNumero() == numero){
                            j.setNome(nome);
                            break;
                        }else if(j.getNumero() > numero){
                            ordenados.add(i, new Jogador(numero, nome));
                            break;
                        }
                        i++;
                    }
                }
                System.out.println("Escalacao do time:");
                System.out.println("Num Nome");
                for (Jogador j: ordenados) {
                    System.out.println(String.format(format, j.getNumero(), j.getNome()));
                }
            }
        }
        /*
        Jogador adriano = new Jogador(1, "adriano");
        int pos = Collections.binarySearch(ordenados, adriano, new JogadorComparator(true, false, false));
        if (pos >= 0) {
            System.out.println("Jogador encontrado:");
            System.out.println(String.format(format, ordenados.get(pos).getNumero(), ordenados.get(pos).getNome()));
        } else {
            System.out.println("Jogador não encontrado. Posição: " + (-pos-1));
        }
        */

    }
}
