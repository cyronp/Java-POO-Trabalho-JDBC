package dao;

import model.Imovel;
import util.Factory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    public void inserir(Imovel imovel) {
        String sql = "INSERT INTO imoveis (endereco, tipo, quartos, banheiros, area, valor_aluguel, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Factory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, imovel.getEndereco());
            statement.setString(2, imovel.getTipo());
            statement.setInt(3, imovel.getQuartos());
            statement.setInt(4, imovel.getBanheiros());
            statement.setDouble(5, imovel.getArea());
            statement.setDouble(6, imovel.getValor_aluguel());
            statement.setBoolean(7, imovel.isDisponivel());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Imovel> listarTodos() {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM imoveis";

        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Imovel i = new Imovel();
                i.setId(rs.getInt("id_imovel"));
                i.setEndereco(rs.getString("endereco"));
                i.setTipo(rs.getString("tipo"));
                i.setQuartos(rs.getInt("quartos"));
                i.setBanheiros(rs.getInt("banheiros"));
                i.setArea(rs.getDouble("area"));
                i.setValor_aluguel(rs.getInt("valor_aluguel"));
                i.setDisponivel(rs.getBoolean("disponivel"));
                imoveis.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imoveis;
    }

    // Relatório: imóveis disponíveis
    public List<Imovel> listarDisponiveis() {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM imoveis WHERE disponivel = 1";

        try (Connection conn = Factory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Imovel i = new Imovel();
                i.setId(rs.getInt("id_imovel"));
                i.setEndereco(rs.getString("endereco"));
                i.setTipo(rs.getString("tipo"));
                i.setQuartos(rs.getInt("quartos"));
                i.setBanheiros(rs.getInt("banheiros"));
                i.setArea(rs.getDouble("area"));
                i.setValor_aluguel(rs.getInt("valor_aluguel"));
                i.setDisponivel(rs.getBoolean("disponivel"));
                imoveis.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imoveis;
    }
}