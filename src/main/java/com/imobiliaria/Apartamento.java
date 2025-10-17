package main.java.com.imobiliaria;

import java.util.Map;

public class Apartamento extends Imovel {

    private String categoria;

    public Apartamento(String endereco, int numero,Proprietario proprietario,String categoria) {
        super(endereco, numero, proprietario);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCategoria: " + categoria;
    }

    @Override
    public String estaAlugado() {
        if (alugado) {
            return "O apartamento de número " + numero + " está alugado";
        } else {
            return "O apartamento de número " + numero + " está disponível";
        }
    }


    @Override
    public int calcularAluguel(int meses) {
        int valorMensal;

        Map<String, Integer> aluguelPorCategoria = Map.of(
                "Pequeno", 700,
                "Medio", 900,
                "Grande", 1100);

        valorMensal = aluguelPorCategoria.get(categoria);

        return valorMensal * meses;
    }
}
