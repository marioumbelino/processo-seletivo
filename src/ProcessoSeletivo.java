import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");

        List<String> candidatos = selecionarCandidatos();
        
        for (int contador = 0; contador < candidatos.size(); contador++) {
            entrarContato(candidatos.get(contador));
        }
    }

    public static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static void entrarContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado!");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "° tentativa realizada.");
        } else {
            System.out.println("Não conseguimos entrar em contato com o(a) " + candidato);
        }
    }

    public static List<String> selecionarCandidatos() {
        String [] candidatos = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana"};

        List<String> candidatosSelecionados = new ArrayList<>();
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados.size() < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            if (salarioPretendido <= salarioBase) {
                candidatosSelecionados.add(candidato);
            }

            candidatoAtual++;

        }

        System.out.println("Os candidatos selecionados foram: ");
        for (int contador = 0; contador <= 4; contador++) {
            try {
            System.out.println(candidatosSelecionados.get(contador));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Lista finalizada");
                break;
            }
        }

        return candidatosSelecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com uma contra proposta.");
        } else {
            System.out.println("aguardar o resultado dos demais candidatos");
        }
    }
}