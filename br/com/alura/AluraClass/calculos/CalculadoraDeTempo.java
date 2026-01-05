package br.com.alura.AluraClass.calculos;
import br.com.alura.AluraClass.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal () {
        return this.tempoTotal;
    }

//    public void inclui (Filme f) {
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui (Serie f) {
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }

    public void inclui (Titulo titulo) {
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
