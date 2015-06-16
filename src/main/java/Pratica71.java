
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.Jogador;
import utfpr.ct.dainf.if62c.pratica.JogadorComparator;
import utfpr.ct.dainf.if62c.pratica.Time;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Template de projeto de programa Java usando Maven.
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica71 {

    public static void main(String[] args) {
        Time time1 = new Time();
        int n_jogadores;
        int numero;
        String nome;
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero de jogadores:");
        while(true){
            if (scanner.hasNextInt()) {
                n_jogadores = scanner.nextInt();
                break;
            }else{
                System.out.println("Valor invalido. Digite o numero de jogadores:");
                scanner.next();
            }
        }
        for (int i = 0; i < n_jogadores; i++) {
            System.out.println("Digite o numero do novo jogador:");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
            } else {
                while (true) {
                    System.out.println("Numero invalido. Digite o numero do novo jogador:");
                    scanner.next();
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        break;
                    }
                }
            }
            System.out.println("Digite o nome do novo jogador:");
            nome = scanner.next();
            time1.addJogador(numero, nome);
        }
        JogadorComparator comparador = new JogadorComparator(true, true, false) {
        };
        List<Jogador> ordenados = time1.ordena(comparador);
        String format = "%3d %-20s";
        System.out.println("Escalacao do time:");
        System.out.println("Num Nome");
        for (Jogador j : ordenados) {
            System.out.println(String.format(format, j.getNumero(), j.getNome()));
        }
        while (true) {
            System.out.println("Digite o numero do novo jogador:");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero == 0) {
                    break;
                }
            }else {
                while (true) {
                    System.out.println("Numero invalido. Digite o numero do novo jogador:");
                    scanner.next();
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        break;
                    }
                }
            }
            System.out.println("Digite o nome do novo jogador:");
            nome = scanner.next();
            if (ordenados.get(ordenados.size() - 1).getNumero() < numero) {
                ordenados.add(new Jogador(numero, nome));
            } else {
                int i = 0;
                for (Jogador j : ordenados) {
                    if (j.getNumero() == numero) {
                        j.setNome(nome);
                        break;
                    } else if (j.getNumero() > numero) {
                        ordenados.add(i, new Jogador(numero, nome));
                        break;
                    }
                    i++;
                }
            }
            System.out.println("Escalacao do time:");
            System.out.println("Num Nome");
            for (Jogador j : ordenados) {
                System.out.println(String.format(format, j.getNumero(), j.getNome()));
            }
        }
    }
}
