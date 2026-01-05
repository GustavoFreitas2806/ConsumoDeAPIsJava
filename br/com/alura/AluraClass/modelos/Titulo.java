package br.com.alura.AluraClass.modelos;

import br.com.alura.AluraClass.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class  Titulo implements Comparable<Titulo> {


    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;


    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4) {
            try {
                // Tenta pegar os últimos 4 caracteres (ex: "2018" de "11 Mar 2018")
                String anoLimpo = meuTituloOmdb.year().substring(meuTituloOmdb.year().length() - 4);
                this.anoDeLancamento = Integer.valueOf(anoLimpo);
            } catch (NumberFormatException e) {
                this.anoDeLancamento = 0; // Se falhar, define 0
            }
        } else {
            try {
                this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
            } catch (NumberFormatException e) {
                this.anoDeLancamento = 0; // Se vier "N/A", define 0
            }
        }

        // Verifica se veio "N/A" antes de tentar cortar a String
        if (meuTituloOmdb.runtime().equals("N/A")) {
            this.duracaoEmMinutos = 0;
        } else {
            try {
                // Remove o texto " min" e espaços vazios, deixando só o número
                String duracaoLimpa = meuTituloOmdb.runtime().replace(" min", "").trim();
                this.duracaoEmMinutos = Integer.valueOf(duracaoLimpa);
            } catch (NumberFormatException e) {
                this.duracaoEmMinutos = 0; // Qualquer outro erro vira 0
            }
        }
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " +nome);
        System.out.println("Ano de lançamento: " +anoDeLancamento);
        System.out.println("Duração em minutos: " +duracaoEmMinutos);
        System.out.println("Incluído no plano: " +incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }


    @Override
    public String toString() {
        return "(nome = " + nome +
                ", anoDeLancamento = " + anoDeLancamento + "," +
                " duração = " + duracaoEmMinutos + ")";
    }
}
