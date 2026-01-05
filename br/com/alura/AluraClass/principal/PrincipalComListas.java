package br.com.alura.AluraClass.principal;

import br.com.alura.AluraClass.modelos.Filme;
import br.com.alura.AluraClass.modelos.Serie;
import br.com.alura.AluraClass.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme favorito = new Filme("The Matrix", 2001);
        favorito.avalia(9);

        Filme meuFilme = new Filme("O poderoso chefão", 2002);
        favorito.avalia(9);

        var filmeDoPaulo = new Filme("dogville", 2025);
        favorito.avalia(9);

        Filme outroFilme = new Filme("Avatar", 2023);
        Serie lost = new Serie("Lost", 2000);

        Filme f1 = filmeDoPaulo;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("jacqueline");

        System.out.println("Lista de titulos");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenação por ano");
        System.out.println(lista);


    }
}
