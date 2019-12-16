package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Caminhao;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaminhaoDaoImpl extends VeiculoDaoImpl implements CaminhaoDao, Serializable {

    private Caminhao caminhao;
    private PreparedStatement psmt;
    private ResultSet rs;

    @Override
    public void salvar(Object object) throws SQLException, Exception {
        caminhao = (Caminhao) object;
        super.salvar(caminhao);
        String sql = "INSERT INTO caminhao (qtdEixo, idVeiculo)"
                + "VALUES (?, ?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, caminhao.getQtdEixo());
            psmt.setInt(2, caminhao.getId());
            psmt.executeUpdate();
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException, Exception {
        caminhao = (Caminhao) object;
        super.alterar(caminhao);
        String sql = "UPDATE caminhao SET qtdEixo = ? WHERE idveiculo = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, caminhao.getQtdEixo());
            psmt.setInt(2, caminhao.getId());
            psmt.executeUpdate();
        } finally {
            FabricaConexao.fecharConexao(conn, psmt);
        }
    }

    @Override
    public void excluir(int id) throws SQLException {
        super.excluir(id);
    }

    @Override
    public Object pesquisarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM caminhao c INNER JOIN veiculo v ON c.idveiculo = v.id "
                + "WHERE c.idveiculo = ? ";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            caminhao = new Caminhao();
            rs.next();
            caminhao.setId(id);
            caminhao.setTipo(rs.getString("tipo"));
            caminhao.setModelo(rs.getString("modelo"));
            caminhao.setFabricante(rs.getString("fabricante"));
            caminhao.setPlaca(rs.getString("placa"));
            caminhao.setValor(rs.getDouble("valor"));
            caminhao.setIpva(rs.getDouble("ipva"));
            caminhao.setRenavan(rs.getString("renavan"));
            
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return caminhao;
    }

    @Override
    public List pesquisarPorModelo(String modelo) throws SQLException {
        String sql = "SELECT * FROM caminhao c INNER JOIN veiculo v ON c.idveiculo = v.id "
                + "WHERE v.modelo = ?";
        List<Caminhao> caminhoes = new ArrayList<>();
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, modelo);
            rs = psmt.executeQuery();
            while (rs.next()) {
                caminhao = new Caminhao();
                caminhao.setId(rs.getInt("id"));
                caminhao.setTipo(rs.getString("tipo"));
                caminhao.setModelo(rs.getString("modelo"));
                caminhao.setFabricante(rs.getString("fabricante"));
                caminhao.setPlaca(rs.getString("placa"));
                caminhao.setValor(rs.getDouble("valor"));
                caminhao.setIpva(rs.getDouble("ipva"));
                caminhao.setRenavan(rs.getString("renavan"));
                caminhoes.add(caminhao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por modelo " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return caminhoes;
    }
}
    