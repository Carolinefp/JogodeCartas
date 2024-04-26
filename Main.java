import java.util.List;

public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        
        baralho.embaralhar();
        
        int numJogadores = 4;
        int numCartasPorJogador = 9;
        
        List<Jogador> jogadores = baralho.distribuirCartas(numJogadores, numCartasPorJogador);
        
        for (int i = 0; i < numJogadores; i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println("Mão do jogador " + jogador.getNome() + ":");
            for (Carta carta : jogador.getMao()) {
                System.out.println(carta);
            }
            System.out.println();
        }
        
        Jogador jogador1 = jogadores.get(0);
        Carta cartaDescartada = jogador1.descartar(0);
        System.out.println("Jogador " + jogador1.getNome() + " descartou a carta: " + cartaDescartada);
        
        Carta novaCarta = jogador1.comprar(baralho);
        System.out.println("Jogador " + jogador1.getNome() + " comprou a carta: " + novaCarta);
    }
}