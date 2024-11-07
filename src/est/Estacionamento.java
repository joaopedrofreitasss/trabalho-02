package est;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> veiculos;

    public Estacionamento(int numVagas) {
        vagas = new ArrayList<>();
        veiculos = new ArrayList<>();

        // Criando vagas de diferentes tamanhos (pequeno, médio, grande)
        for (int i = 1; i <= numVagas; i++) {
            String tamanho = (i % 3 == 0) ? "grande" : (i % 2 == 0) ? "médio" : "pequeno";
            vagas.add(new Vaga(i, tamanho));
        }
    }

    // Método para cadastrar um novo veículo
    public void cadastrarVeiculo(String placa, String modelo, String tamanho) {
        Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso! Placa: " + placa);
    }

    // Método para buscar vaga disponível que seja compatível com o tamanho do veículo
    public Vaga buscarVagaDisponivel(String tamanhoVeiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.vagaCompatível(tamanhoVeiculo)) {
                return vaga;
            }
        }
        return null;
    }

    // Registrar a entrada de um veículo
    public boolean registrarEntrada(String placa, String horaEntrada) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                // Verificar vaga compatível
                Vaga vaga = buscarVagaDisponivel(veiculo.getTamanho());
                if (vaga != null) {
                    veiculo.registrarEntrada(horaEntrada);
                    vaga.ocupar();
                    veiculo.setNumeroVaga(vaga.getNumero());
                    System.out.println("Veículo " + placa + " estacionado na vaga " + vaga.getNumero());
                    return true;
                } else {
                    System.out.println("Não há vaga disponível ou vaga compatível para o veículo " + placa);
                    return false;
                }
            }
        }
        System.out.println("Veículo não encontrado.");
        return false;
    }

    // Registrar a saída de um veículo
    public boolean registrarSaida(String placa, String horaSaida) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.registrarSaida(horaSaida);
                double valor = veiculo.calcularValor();
                System.out.println("Veículo " + placa + " saiu. Valor a pagar: R$ " + valor);
                Vaga vaga = getVagaPorNumero(veiculo.getNumeroVaga());
                if (vaga != null) {
                    vaga.liberar();
                    System.out.println("Vaga " + vaga.getNumero() + " liberada.");
                    return true;
                }
            }
        }
        System.out.println("Veículo não encontrado.");
        return false;
    }

    // Método para buscar uma vaga por número
    public Vaga getVagaPorNumero(int numeroVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero() == numeroVaga) {
                return vaga;
            }
        }
        return null;
    }

    // Gerar relatório de vagas ocupadas
    public void gerarRelatorioVagasOcupadas() {
        System.out.println("Vagas Ocupadas:");
        boolean encontrouVagaOcupada = false;
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                Veiculo veiculo = getVeiculoPorVaga(vaga.getNumero());
                if (veiculo != null) {
                    System.out.println("Vaga " + vaga.getNumero() + " - Tamanho da vaga: " + vaga.getTamanho() + " - Placa do veículo: " + veiculo.getPlaca());
                    encontrouVagaOcupada = true;
                }
            }
        }
        if (!encontrouVagaOcupada) {
            System.out.println("Não há vagas ocupadas no momento.");
        }
    }

    // Método auxiliar para obter o veículo pela vaga
    public Veiculo getVeiculoPorVaga(int numeroVaga) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNumeroVaga() == numeroVaga) {
                return veiculo;
            }
        }
        return null;
    }

    // Gerar histórico de veículos
    public void gerarRelatorioHistorico() {
        System.out.println("Histórico de Permanência dos Veículos:");
        boolean encontrouHistorico = false;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getHoraEntrada() != null && veiculo.getHoraSaida() != null) {
                System.out.println("Placa: " + veiculo.getPlaca() +
                        " | Entrada: " + veiculo.getHoraEntrada() +
                        " | Saída: " + veiculo.getHoraSaida() +
                        " | Valor Pago: R$ " + veiculo.calcularValor());
                encontrouHistorico = true;
            }
        }
        if (!encontrouHistorico) {
            System.out.println("Não há veículos no histórico.");
        }
    }

    // Exibir todos os veículos cadastrados
    public void listarVeiculos() {
        System.out.println("Veículos cadastrados:");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo veiculo : veiculos) {
            System.out.println("Placa: " + veiculo.getPlaca() + " | Modelo: " + veiculo.getModelo() + " | Tamanho: " + veiculo.getTamanho());
        }
    }
}
