package main.java.com.imobiliaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        Proprietario p1 = new Proprietario("Lucas", "91111-2222", "123.456.789-00");
        Proprietario p2 = new Proprietario("Carol", "92222-3333", "999.999.999-88");
        Proprietario p3 = new Proprietario("Ana", "93333-4444", "111.444.564-44");
        Proprietario p4 = new Proprietario("Marcos", "94444-5555", "555.555.555-33");
        Proprietario p5 = new Proprietario("Maria", "97777-7777", "222.777.777-66");


        service.cadastrarCasa("Rua M", 81, p1, "Média");
        service.cadastrarCasa("Rua I", 201, p2, "Grande");
        service.cadastrarApt("Rua K", 47, p3, "Pequeno");
        service.cadastrarApt("Rua J", 404, p4, "Médio");
        service.cadastrarApt("Rua V", 29, p5, "Grande");

        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarImovel(sc, service);
                case 2 -> deletarImovel(sc, service);
                case 3 -> alterarStatus(sc, service);
                case 4 -> calcularAluguel(sc, service);
                case 5 -> service.listarImoveis();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\n.... MENU ....");
        System.out.println("1 - Cadastrar imóvel");
        System.out.println("2 - Deletar imóvel");
        System.out.println("3 - Alterar status do imóvel");
        System.out.println("4 - Calcular aluguel");
        System.out.println("5 - Listar todos os imóveis");
        System.out.println("0 - Sair");
    }

    private static void cadastrarImovel(Scanner sc, Service service) {
        System.out.print("Tipo do imóvel (Casa/Apartamento): ");
        String tipo = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do proprietário: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        Proprietario novoProp = new Proprietario(nome, telefone, cpf);

        if (tipo.equalsIgnoreCase("Casa")) {
            System.out.print("Tamanho (Pequena/Média/Grande): ");
            String tamanho = sc.nextLine();
            service.cadastrarCasa(endereco, numero, novoProp, tamanho);
        } else if (tipo.equalsIgnoreCase("Apartamento")) {
            System.out.print("Tamanho (Pequeno/Médio/Grande): ");
            String tamanho = sc.nextLine();
            service.cadastrarApt(endereco, numero, novoProp, tamanho);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void deletarImovel(Scanner sc, Service service) {
        System.out.print("ID do imóvel a deletar: ");
        int id = sc.nextInt();
        service.removerImovel(id);
    }

    private static void alterarStatus(Scanner sc,Service service) {
        System.out.print("ID do imóvel: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Deseja alugar ou liberar? ");
        String opcao = sc.nextLine();

        boolean estaAlugado;
        if (opcao.equalsIgnoreCase("Alugar")) {
            estaAlugado = true;
        } else if (opcao.equalsIgnoreCase("Liberar")) {
            estaAlugado = false;
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        service.alterarStatus(id, estaAlugado);
    }

    private static void calcularAluguel(Scanner sc, Service service) {
        System.out.print("ID do imóvel: ");
        int id = sc.nextInt();

        System.out.print("Quantidade de meses: ");
        int meses = sc.nextInt();

        service.calcularAluguel(id, meses);
    }
}
