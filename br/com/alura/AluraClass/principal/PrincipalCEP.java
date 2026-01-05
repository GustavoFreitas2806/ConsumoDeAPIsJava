package br.com.alura.AluraClass.principal;

import br.com.alura.AluraClass.excecao.ErroDeCEP;
import br.com.alura.AluraClass.modelos.ConsultaCEP;
import br.com.alura.AluraClass.modelos.Endereco;
import br.com.alura.AluraClass.modelos.GeradorDeArquivo;
import br.com.alura.AluraClass.modelos.ValidaCEP;

import java.io.IOException;
import java.util.Scanner;

public class PrincipalCEP {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaCEP consultaCep = new ConsultaCEP();

        System.out.println("Digite um número de CEP para consulta:");
        var cep = leitura.nextLine();

        try {
            ValidaCEP validador = new ValidaCEP();
            validador.validar(cep);

            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (ErroDeCEP e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println("erro genérico: " + e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}