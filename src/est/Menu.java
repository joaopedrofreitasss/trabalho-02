package est;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo um número maior de vagas
        System.out.println("Digite o número de vagas no estacionamento:");
        int numVagas = scanner.nextInt();

        Estacionamento estacionamento = new Estacionamento(numVagas);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Registrar entrada");
            System.out.println("3 - Registrar saída");
            System.out.println("4 - Relatório de vagas ocupadas");
            System.out.println("5 - Histórico de veículos");
            System.out.println("6 - Listar todos os veículos cadastrados");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer para ler a linha de texto corretamente

            switch (opcao) {
                case 1:
                    
                	System.out.println("Digite a placa do veículo:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo do veículo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite o tamanho do veículo (pequeno, médio, grande):");
                    String tamanho = scanner.nextLine();
                    estacionamento.cadastrarVeiculo(placa, modelo, tamanho);
                    
                    break;
                    
                case 2:
                	
                    System.out.println("Digite a placa do veículo:");
                    placa = scanner.nextLine();
                    System.out.println("Digite a hora de entrada (HH:mm):");
                    String horaEntrada = scanner.nextLine();
                    estacionamento.registrarEntrada(placa, horaEntrada);
                    
                    break;
                    
                case 3:
                   
                	System.out.println("Digite a placa do veículo:");
                    placa = scanner.nextLine();
                    System.out.println("Digite a hora de saída (HH:mm):");
                    String horaSaida = scanner.nextLine();
                    estacionamento.registrarSaida(placa, horaSaida);
                    
                    break;
                    
                case 4:
                   
                	estacionamento.gerarRelatorioVagasOcupadas();
                    
                	break;
                    
                case 5:
                	
                    estacionamento.gerarRelatorioHistorico();
                    
                    break;
                    
                case 6:
                   
                	estacionamento.listarVeiculos(); // Exibir todos os veículos cadastrados
                    
                    break;
                    
                case 7:
                   
                	System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
