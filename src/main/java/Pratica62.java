
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
public class Pratica62 {
    public static void main(String[] args) {
        Time time1 = new Time(new HashMap<>());
        time1.addJogador("zagueiro", new Jogador(4, "lucas"));
        time1.addJogador("goleiro base", new Jogador(1, "juca"));
        time1.addJogador("goleiro reserva", new Jogador(11, "joao"));
        time1.addJogador("lateral esquerdo", new Jogador(4, "jose"));
        time1.addJogador("goleiro substituto", new Jogador(1, "adriano"));
        time1.addJogador("atacante", new Jogador(15, "mario"));
        time1.addJogador("goleiro", new Jogador(1, "fulano"));
        time1.addJogador("lateral direito", new Jogador(14, "mario"));
        /*
        Time time2 = new Time(new HashMap<>());
        time2.addJogador("goleiro", new Jogador(1, "fulano"));
        time2.addJogador("lateral", new Jogador(4, "ciclano"));
        time2.addJogador("atacante", new Jogador(15, "beltrano"));
        */
        JogadorComparator comparador = new JogadorComparator(false, true, false){};
        List<Jogador> ordenados = time1.ordena(comparador);
        String format = "%3d %-20s";
        System.out.println("Num Nome");
        for (Jogador j: ordenados) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }
        Jogador adriano = new Jogador(1, "adriano");
        int pos = Collections.binarySearch(ordenados, adriano, comparador);
        if (pos >= 0) {
            System.out.println("Jogador encontrado:");
            System.out.println(String.format(format, ordenados.get(pos).getNumero(), ordenados.get(pos).getNome()));
        } else {
            System.out.println("Jogador não encontrado. Posição: " + (-pos-1));
        }
        

    }
}
