package dao;

import model.Cliente;
import util.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome,cpf,telefone,email) VALUES (?,?,?,?)";
        try (Connection connection = Factory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection connection = Factory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
