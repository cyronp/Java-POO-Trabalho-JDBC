package dao;

import model.Contrato;
import util.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContratoDAO {
    public void inserir(Contrato contrato) {
        String sql = "INSERT INTO contratos (id_cliente,id_imovel,valor,data_inicio,data_fim,ativo) VALUES (?,?,?,?,?,?)";
        try (Connection connection = Factory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, contrato.getId_cliente());
            statement.setInt(2, contrato.getId_imovel());
            statement.setDouble(3, contrato.getValor());
            statement.setString(4, contrato.getData_inicio());;
            statement.setString(5, contrato.getData_fim());;
            statement.setBoolean(6,contrato.isAtivo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Contrato> listarTodos() {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM contratos";

        try (Connection connection = Factory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id_contrato"));
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setId_imovel(rs.getInt("id_imovel"));
                c.setValor(rs.getDouble("valor"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_fim(rs.getString("data_fim"));
                c.setAtivo(rs.getBoolean("ativo"));
                contratos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }

    // Relatório: contratos ativos
    public List<Contrato> listarAtivos() {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM contratos WHERE ativo = 1";

        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id_contrato"));
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setId_imovel(rs.getInt("id_imovel"));
                c.setValor(rs.getDouble("valor"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_fim(rs.getString("data_fim"));
                c.setAtivo(rs.getBoolean("ativo"));
                contratos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }

    // Relatório: contratos expirando em 30 dias
    public List<Contrato> listarExpirando30Dias() {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM contratos WHERE ativo = 1 AND date(data_fim) <= date('now', '+30 days')";

        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id_contrato"));
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setId_imovel(rs.getInt("id_imovel"));
                c.setValor(rs.getDouble("valor"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_fim(rs.getString("data_fim"));
                c.setAtivo(rs.getBoolean("ativo"));
                contratos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contratos;
    }

    // Relatório: clientes com mais contratos
    public void clientesComMaisContratos() {
        String sql = "SELECT id_cliente, COUNT(*) as qtd FROM contratos GROUP BY id_cliente ORDER BY qtd DESC";

        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Cliente ID: " + rs.getInt("id_cliente") + " - Contratos: " + rs.getInt("qtd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

