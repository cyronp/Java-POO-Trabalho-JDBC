import dao.ClienteDAO;
import dao.ImovelDAO;
import dao.ContratoDAO;
import model.Cliente;
import model.Imovel;
import model.Contrato;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        String opcao;

        do {
            System.out.println("\n===== SISTEMA IMOBILIÁRIA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Imóvel");
            System.out.println("4 - Listar Imóveis");
            System.out.println("5 - Listar Imóveis Disponíveis");
            System.out.println("6 - Cadastrar Contrato");
            System.out.println("7 - Listar Contratos");
            System.out.println("8 - Listar Contratos Ativos");
            System.out.println("9 - Relatório: Clientes com mais contratos");
            System.out.println("10 - Relatório: Contratos vencendo em 30 dias");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.next();
            sc.nextLine();

            switch (opcao) {
                case "1":
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
                    break;

                case "2":
                    clienteDAO.listarTodos().forEach(cli ->
                            System.out.println(cli.getId() + " - " + cli.getNome())
                    );
                    break;

                case "3":
                    Imovel i = new Imovel();
                    System.out.print("Endereço: ");
                    i.setEndereco(sc.nextLine());
                    System.out.print("Tipo: ");
                    i.setTipo(sc.nextLine());
                    System.out.print("Quartos: ");
                    i.setQuartos(sc.nextInt());
                    System.out.print("Banheiros: ");
                    i.setBanheiros(sc.nextInt());
                    System.out.print("Área (m²): ");
                    i.setArea(sc.nextDouble());
                    System.out.print("Valor Aluguel: ");
                    i.setValor_aluguel(sc.nextInt());
                    sc.nextLine();
                    i.setDisponivel(true);
                    imovelDAO.inserir(i);
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;

                case "4":
                    imovelDAO.listarTodos().forEach(im ->
                            System.out.println(im.getId() + " - " + im.getEndereco() + " (" + im.getTipo()+ ") R$" + im.getValor_aluguel())
                    );

                case "5":
                    imovelDAO.listarDisponiveis().forEach(im ->
                            System.out.println(im.getId() + " - " + im.getEndereco() + " (" + im.getTipo() + ") R$" + im.getValor_aluguel())
                    );
                    break;

                case "6":
                    Contrato ctr = new Contrato();
                    System.out.print("ID Cliente: ");
                    ctr.setId_cliente(sc.nextInt());
                    System.out.print("ID Imóvel: ");
                    ctr.setId_imovel(sc.nextInt());
                    System.out.print("Valor do Aluguel: ");
                    ctr.setValor(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Data Início (Ano-Mes-Dia): ");
                    ctr.setData_inicio(sc.nextLine());
                    System.out.print("Data Fim (Ano-Mes-Dia): ");
                    ctr.setData_fim(sc.nextLine());
                    ctr.setAtivo(true);
                    contratoDAO.inserir(ctr);
                    System.out.println("Contrato cadastrado com sucesso!");
                    break;

                case "7":
                    contratoDAO.listarTodos().forEach(ct ->
                            System.out.println("Contrato " + ct.getId() + " - Cliente " + ct.getId_cliente() + " - Imóvel " + ct.getId_imovel())
                    );

                case "8":
                    contratoDAO.listarAtivos().forEach(ct ->
                            System.out.println("Contrato " + ct.getId() + " - Cliente " + ct.getId_cliente() + " - Imóvel " + ct.getId_imovel())
                    );
                    break;

                case "9":
                    contratoDAO.clientesComMaisContratos();
                    break;

                case "10":
                    contratoDAO.listarExpirando30Dias().forEach(ct ->
                            System.out.println("Contrato " + ct.getId() + " expira em " + ct.getData_fim())
                    );
                    break;

                case "0":
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));

        sc.close();
    }
}
