package est;

public class Vaga {
    private int numero;
    private String tamanho;
    private boolean disponivel;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocupar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    public boolean vagaCompatível(String tamanhoVeiculo) {
        // Vaga compatível: Vaga pequena só aceita carros pequenos, e assim por diante
        if (this.tamanho.equals("pequeno") && !tamanhoVeiculo.equals("pequeno")) {
            return false;
        }
        if (this.tamanho.equals("médio") && (tamanhoVeiculo.equals("grande"))) {
            return false;
        }
        return true;
    }
}

