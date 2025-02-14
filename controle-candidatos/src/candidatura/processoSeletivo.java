package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Andrew", "Everton", "João", "Gustavo", "Rodrigo"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do { 
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");
        } while (continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato +" na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("Não conseguimos contato com " + candidato +", número máximo de tentativas " + tentativasRealizadas);
    }   

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirCandidatos() {
        String [] candidatos = {"Andrew", "Everton", "João", "Gustavo", "Rodrigo"};

        System.out.println("Imprimindo candidatos selecionados");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    static void selecaoCandidato() {
        String [] candidatos = {"Andrew", "Everton", "João", "Gustavo", "Rodrigo", "Yuri", "Marcos", "Paulo", "Sheldon", "Tom"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou o sálario de R$%.2f\n", candidato, salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200);
    }

    static void analisarCandidato (double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardar o resultado dos demais candidatos");
        }
    }
}
