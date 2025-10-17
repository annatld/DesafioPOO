package main.java.com.imobiliaria;

public class Casa extends Imovel {

    private String categoria;

    public Casa(String endereco, int numero, Proprietario proprietario, String categoria) {
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
        return super.toString() + "Categoria: " + categoria;
    }

    @Override
    public String estaAlugado() {
        if (alugado) {
            return "A casa está alugada";
        } else {
            return "A casa está disponível";
        }
    }
    @Override
    public int calcularAluguel(int meses) {
        int valorMensal;

        if (categoria.equals("Pequena")) {
            valorMensal = 900;
        } else if (categoria.equals("Media")) {
            valorMensal = 1100;
        } else {
            valorMensal = 1500;
        }

        return valorMensal * meses;
    }
}


