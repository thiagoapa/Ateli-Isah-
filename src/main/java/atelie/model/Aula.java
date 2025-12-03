package atelie.model;

public class Aula {
    private int idAula;
    private String tema;
    private String dataHora;
    private int vagasDisponiveis;
    private int vagasTotais;

    public Aula(String tema, String dataHora, int vagasTotais) {
        this.tema = tema;
        this.dataHora = dataHora;
        this.vagasTotais = vagasTotais;
        this.vagasDisponiveis = vagasTotais;
    }

    // Getters y Setters
    public int getIdAula() { return idAula; }
    public void setIdAula(int idAula) { this.idAula = idAula; }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public int getVagasDisponiveis() { return vagasDisponiveis; }
    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getVagasTotais() { return vagasTotais; }
    public void setVagasTotais(int vagasTotais) { this.vagasTotais = vagasTotais; }

    public boolean reservarVaga() {
        if (vagasDisponiveis > 0) {
            vagasDisponiveis--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + idAula + " | Tema: " + tema +
                " | Data/Hora: " + dataHora +
                " | Vagas: " + vagasDisponiveis + "/" + vagasTotais;
    }
}