package br.com.alura.AluraClass.modelos;

import br.com.alura.AluraClass.excecao.ErroDeCEP;

public class ValidaCEP extends Throwable {

    public void validar(String cep) throws ErroDeCEP {
        // Passo opcional: Verifica se é nulo ou vazio antes
        if (cep == null || cep.isEmpty()) {
            throw new ErroDeCEP ("O CEP não pode ser vazio.");
        }

        // Dica: Remove traços ou pontos para contar apenas os números
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        if (cepLimpo.length() != 8) {
            throw new ErroDeCEP("O número de caracteres é incompatível. O CEP deve ter 8 dígitos.");
        }

        System.out.println("CEP válido: " + cepLimpo);
    }
}