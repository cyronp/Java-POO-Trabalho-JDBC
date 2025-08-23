
import dao.ClienteDAO;
import dao.ImovelDAO;
import dao.ContratoDAO;
import model.Cliente;
import model.Imovel;
import model.Contrato;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuManager {
    private final Scanner sc;
    private final ClienteDAO clienteDAO;
    private final ImovelDAO imovelDAO;
    private final ContratoDAO contratoDAO;
    private String telaAtual = "menuPrincipal";

    public MenuManager(Scanner sc, ClienteDAO clienteDAO, ImovelDAO imovelDAO, ContratoDAO contratoDAO) {
        this.sc = sc;
        this.clienteDAO = clienteDAO;
        this.imovelDAO = imovelDAO;
        this.contratoDAO = contratoDAO;
    }

    public void iniciar() throws SQLException {
        while (!telaAtual.equals("sair")) {
            clearScreen();
            switch (telaAtual) {
                case "menuPrincipal":
                    mostrarMenuPrincipal();
                    break;
                case "menuClientes":
                    telaClientes();
                    break;
                case "menuImoveis":
                    telaImoveis();
                    break;
                case "menuContratos":
                    telaContratos();
                    break;
            }
        }
    }

    // ================= MENU PRINCIPAL =================
    private void mostrarMenuPrincipal() throws SQLException {
        imprimirMenuPrincipal();
        String op = sc.nextLine();

        if (processarComandoGlobal(op)) return;

        switch (op) {
            case "1":
                loading();
                telaAtual = "menuClientes";
                break;
            case "2":
                loading();
                telaAtual = "menuImoveis";
                break;
            case "3":
                loading();
                telaAtual = "menuContratos";
                break;
            case "0":
                telaAtual = "sair";
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void imprimirMenuPrincipal() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1 - Clientes");
        System.out.println("2 - Imóveis");
        System.out.println("3 - Contratos");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // ================= CLIENTES =================
    private void telaClientes() throws SQLException {
        imprimirMenuClientes();
        String op = sc.nextLine();

        if (processarComandoGlobal(op)) return;

        switch (op) {
            case "1":
                clearScreen();
                Cliente c = new Cliente();
                System.out.print("Nome: ");
                c.setNome(sc.nextLine());
                System.out.print("CPF: ");
                c.setCpf(sc.nextLine());
                System.out.print("Telefone: ");
                c.setTelefone(sc.nextLine());
                System.out.print("Email: ");
                c.setEmail(sc.nextLine());
                clienteDAO.inserir(c);
                System.out.println("Cliente cadastrado com sucesso!");
                returningMenu();
                break;
            case "2":
                for (Cliente cli : clienteDAO.listarTodos()) {
                    System.out.println(cli.getId() + " - " + cli.getNome());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                returningMenu();
                break;
            case "9":
                returningMenu();
                telaAtual = "menuPrincipal";
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void imprimirMenuClientes() {
        System.out.println("===== MENU CLIENTES =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("9 - Voltar");
        System.out.print("Escolha: ");
    }

    // ================= IMÓVEIS =================
    private void telaImoveis() throws SQLException {
        imprimirMenuImoveis();
        String op = sc.nextLine();

        if (processarComandoGlobal(op)) return;

        switch (op) {
            case "1":
                clearScreen();
                Imovel i = new Imovel();
                System.out.print("Endereço: ");
                i.setEndereco(sc.nextLine());
                System.out.print("Tipo: ");
                i.setTipo(sc.nextLine());
                System.out.print("Quartos: ");
                i.setQuartos(leInt());
                System.out.print("Banheiros: ");
                i.setBanheiros(leInt());
                System.out.print("Área (m²): ");
                i.setArea(leDouble());
                System.out.print("Valor Aluguel: ");
                i.setValor_aluguel(leDouble());
                sc.nextLine();
                i.setDisponivel(true);
                imovelDAO.inserir(i);
                System.out.println("Imóvel cadastrado com sucesso!");
                returningMenu();
                break;

            case "2":
                for (Imovel im : imovelDAO.listarTodos()) {
                    System.out.println(im.getId() + " - " + im.getEndereco() + " R$" + im.getValor_aluguel());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                returningMenu();
                break;
            case "9":
                returningMenu();
                telaAtual = "menuPrincipal";
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void imprimirMenuImoveis() {
        System.out.println("===== MENU IMÓVEIS =====");
        System.out.println("1 - Cadastrar Imóvel");
        System.out.println("2 - Listar Imóveis");
        System.out.println("9 - Voltar");
        System.out.print("Escolha: ");
    }

    // ================= CONTRATOS =================
    private void telaContratos() throws SQLException {
        imprimirMenuContratos();
        String op = sc.nextLine();

        if (processarComandoGlobal(op)) return;

        switch (op) {
            case "1":
                clearScreen();
                Contrato ct = new Contrato();
                System.out.print("ID Cliente: ");
                ct.setId_cliente(leInt());
                System.out.print("ID Imóvel: ");
                ct.setId_imovel(leInt());
                System.out.print("Valor do Aluguel: ");
                ct.setValor(leDouble());
                sc.nextLine();
                System.out.print("Data Início (Ano-Mes-Dia): ");
                ct.setData_inicio(sc.nextLine());
                System.out.print("Data Fim (Ano-Mes-Dia): ");
                ct.setData_fim(sc.nextLine());
                ct.setAtivo(true);
                contratoDAO.inserir(ct);
                System.out.println("Contrato cadastrado com sucesso!");
                returningMenu();
                break;

            case "2":
                for (Contrato ct2 : contratoDAO.listarTodos()) {
                    System.out.println(ct2.getId() + " - Cliente " + ct2.getId_cliente() + " / Imóvel " + ct2.getId_imovel());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                returningMenu();
                break;
            case "9":
                returningMenu();
                telaAtual = "menuPrincipal";
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void imprimirMenuContratos() {
        System.out.println("===== MENU CONTRATOS =====");
        System.out.println("1 - Cadastrar Contrato");
        System.out.println("2 - Listar Contratos");
        System.out.println("9 - Voltar");
        System.out.print("Escolha: ");
    }

    // ================= FUNÇÕES AUXILIARES =================
    private boolean processarComandoGlobal(String op) {
        if (op.equalsIgnoreCase("sair")) {
            telaAtual = "sair";
            return true;
        }
        return false;
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Não foi possível limpar a tela.");
        }
    }

    private void loading() {
        clearScreen();
        System.out.println("Carregando...");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }

    private void returningMenu() {
        System.out.println("\nVoltando ao menu...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clearScreen();
    }
    private int leInt() {
        int valor = -1;
        while (valor < 0) {
            try {
                valor = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
        return valor;
    }

    private double leDouble() {
        double valor = -1;
        while (valor < 0) {
            try {

                valor = sc.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
            }
        }
        return valor;
    }

    }

