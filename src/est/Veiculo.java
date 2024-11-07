package est;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private String horaEntrada;
    private String horaSaida;
    private int numeroVaga;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void registrarEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void registrarSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public double calcularValor() {
        if (horaEntrada == null || horaSaida == null) {
            return 0;
        }

        int horas = Integer.parseInt(horaSaida.split(":")[0]) - Integer.parseInt(horaEntrada.split(":")[0]);
        if (horas < 1) {
            return 5.0;
        } else if (horas <= 3) {
            return 10.0;
        } else {
            return 15.0;
        }
    }
}
