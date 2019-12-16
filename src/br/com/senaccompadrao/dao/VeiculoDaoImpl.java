package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class VeiculoDaoImpl {

    protected Connection conn;
    protected PreparedStatement psmt;
    protected ResultSet rs;

    public void salvar(Veiculo veiculo) throws SQLException, Exception {
        String sql = "INSERT INTO veiculo(tipo, modelo, fabricante,"
                + " placa,  valor, ipva, renavan) VALUES(?, ?, ?, ?, ?, ?, ?)";
        conn = FabricaConexao.abrirConexao();
        psmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        psmt.setString(1, veiculo.getTipo());
        psmt.setString(2, veiculo.getModelo());
        psmt.setString(3, veiculo.getFabricante());
        psmt.setString(4, veiculo.getPlaca());
        psmt.setDouble(5, veiculo.getValor());
        psmt.setDouble(6, veiculo.getIpva());
        psmt.setString(7, veiculo.getRenavan());
        psmt.executeUpdate();
        rs = psmt.getGeneratedKeys();
        rs.next();
        veiculo.setId(rs.getInt(1));
    }

    public void alterar(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE veiculo SET tipo = ?, modelo = ?, "
                + "fabricante = ?, placa = ?, valor = ?, ipva = ?"
                + " WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, veiculo.getTipo());
            psmt.setString(2, veiculo.getModelo());
            psmt.setString(3, veiculo.getFabricante());
            psmt.setString(4, veiculo.getPlaca());
            psmt.setDouble(5, veiculo.getValor());
            psmt.setDouble(6, veiculo.getIpva());
            psmt.setInt(7, veiculo.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar veiculo "
                    + e.getMessage());
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir veículo " + e.getMessage());
        }

    }
}
