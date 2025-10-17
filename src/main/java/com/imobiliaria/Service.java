package main.java.com.imobiliaria;

import java.util.ArrayList;
import java.util.List;


public class Service {
    private final List<Imovel> imoveisLista = new ArrayList<>();


    public void cadastrarCasa(String endereco, int numero, Proprietario proprietario, String categoria) {
        Casa casa = new Casa(endereco, numero, proprietario, categoria);
        imoveisLista.add(casa);
    }

    public void cadastrarApt(String endereco, int numero, Proprietario proprietario, String categoria) {
        Apartamento apt = new Apartamento(endereco, numero, proprietario, categoria);
        imoveisLista.add(apt);
    }

    public void removerImovel(int id) {
        boolean removido = imoveisLista.removeIf(imovel -> imovel.getId() == id);
        if (removido) {
            System.out.println("Imóvel removido com sucesso!");
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    public void alterarStatus(int id, boolean statusAlugado) {
        for (Imovel imovel : imoveisLista) {
            if (imovel.getId() == id) {
                imovel.setAlugado(statusAlugado);
                System.out.println(statusAlugado
                        ? "Imóvel alugado com sucesso!"
                        : "Imóvel disponibilizado com sucesso!");
                return;
            }
        }
        System.out.println("Imóvel não encontrado!");
    }


    public void calcularAluguel(int id, int meses) {
        for (Imovel imovel : imoveisLista) {
            if (imovel.getId() == id) {
                int total = imovel.calcularAluguel(meses);
                System.out.println("Valor final do aluguel: R$ " + total + " em " + meses + " meses.");
                return;
            }
        }
        System.out.println("Imóvel não encontrado!");
    }

    public void listarImoveis() {
        if (imoveisLista.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
        } else {
            for (Imovel imovel : imoveisLista) {
                System.out.println(".............................");
                System.out.println(imovel);
            }
        }
    }
}
