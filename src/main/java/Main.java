import dao.ClienteDAO;
import dao.ImovelDAO;
import dao.ContratoDAO;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();


        MenuManager menu = new MenuManager(sc, clienteDAO, imovelDAO, contratoDAO);

        try {
            menu.iniciar(); // inicia o menu principal
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

}
