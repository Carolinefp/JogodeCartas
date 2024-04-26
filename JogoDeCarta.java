import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.smartcardio.Card;


public JogoDeCartas(int numJogadores, int numCartasPorJogador) {
    this.numJogadores = numJogadores;
    this.numCartasPorJogador = numCartasPorJogador;
    baralho = new Baralho();
    baralho.embaralhar();
    jogadores = baralho.distribuirCartas(numJogadores, numCartasPorJogador);
    jogadorAtual = 0;
    jogoAtivo = true;
}

public void iniciarJogo() {
    while (jogoAtivo) {
        Jogador jogador = jogadores.get(jogadorAtual);
        System.out.println("Jogador " + (jogadorAtual + 1) + "'s turno.");
        System.out.println("Sua mão: " + jogador.getMao());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua jogada:");
        System.out.println("1. Descartar uma carta");
        System.out.println("2. Comprar uma carta do baralho");
        System.out.println("3. Formar conjuntos de três cartas");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Escolha o índice da carta a ser descartada:");
                int indiceDescarte = scanner.nextInt();
                Carta cartaDescartada = jogador.descartar(indiceDescarte);
                System.out.println("Você descartou: " + cartaDescartada);
                break;
            case 2:
                Carta cartaComprada = jogador.comprar(baralho);
                System.out.println("Você comprou: " + cartaComprada);
                break;
            case 3:
                // Implementar a lógica para formar conjuntos de três cartas
                break;
            default:
                System.out.println("Escolha inválida!");
        }

        // Verificar condições de vitória e atualizar jogador atual
        // Implementar lógica de vitória e troca de jogador aqui

        // Exemplo simples: Mudar para o próximo jogador
        jogadorAtual = (jogadorAtual + 1) % numJogadores;
    }
}

    class Carta{
    private int valor;
    private String naipe;

    public Carta (int valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
    }
    public int getValor(){
        return valor;
    }
    public String getNaipe (){
        return naipe;
    }
        
    public String toString (){
    return valor + "de" + naipe;
    }
}

     class Jogador{
        private List
        <Carta> mao;
        String nome;
        
        public Jogador(String nome) {
            mao = new ArrayList<>();
            this.nome = nome;
        }
        
        public void adicionarCarta(Carta carta) {
            mao.add(carta);
        }
        
        public List<Card> getMao() {
            return mao;
        }
        
        public Carta descartar(int indice) {
            return mao.remove(indice);
        }
        
        public Carta comprar(Baralho baralho) {
            Carta cartaComprada = baralho.comprarCarta();
            mao.add(cartaComprada);
            return cartaComprada;
        }
        }

        public class Baralho {
            private List<Integer> cartas;
           
            public Baralho(){
               this.cartas =new ArrayList<>();
               String [] naipes ={"Copas", "Ouros", "Espada", "Paus"};
               for (String naipe : naipes){
       
               for (int valor = 1; valor <=109; valor ++);}
               {
                   this.cartas.add(new Carta (valor,naipe));
               }
            }
        }
            public void embaralhar(){
                Collections.shuffle(this.cartas);
             }

     public List <Jogador> distribuirCartas (int numJogadores, int numCartasPorJogador){
            List<Jogador> jogadores =new ArrayList<>();
            for (int i=0; i < numJogadores; j++){
                Jogador jogador = new Jogador();
                for (int j = 0; j< numCartasPorJogador){
                    jogador.adicionarCarta(cartas.remove(0));
        
                }
                jogadores.add(jogador);
            }
            return jogadores;
        }


 

     public int retirarCartas(){
        if (!this.cartas.isEmpty()){
            return this.cartas.remove(0);
     }
     else {
        throw new IllegalArgumentException ( " O baralho está vazio!");
     }
    }