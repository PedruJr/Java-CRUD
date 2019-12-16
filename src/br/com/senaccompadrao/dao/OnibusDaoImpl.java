package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Onibus;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnibusDaoImpl extends VeiculoDaoImpl implements OnibusDao, Serializable {

    private Onibus onibus;
    private PreparedStatement psmt;
    private ResultSet rs;

    @Override
    public void salvar(Object object) throws SQLException, Exception {
        onibus = (Onibus) object;
        super.salvar(onibus);
        String sql = "INSERT INTO onibus (qtdAcento, idveiculo)"
                + "VALUES (?, ?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, onibus.getQtdAcento());
            psmt.setInt(2, onibus.getId());
            psmt.executeUpdate();

        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        onibus = (Onibus) object;
        super.alterar(onibus);
        String sql = "UPDATE onibus SET qtdAcento = ? WHERE idveiculo = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, onibus.getQtdAcento());
            psmt.setInt(2, onibus.getId());
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
        String sql = "SELECT * FROM onibus o INNER JOIN veiculo v ON o.idveiculo = v.id "
                + "WHERE o.idveiculo = ? ";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            onibus = new Onibus();
            rs.next();
            onibus.setId(id);
            onibus.setTipo(rs.getString("tipo"));
            onibus.setModelo(rs.getString("modelo"));
            onibus.setFabricante(rs.getString("fabricante"));
            onibus.setPlaca(rs.getString("placa"));
            onibus.setValor(rs.getDouble("valor"));
            onibus.setIpva(rs.getDouble("ipva"));
            onibus.setRenavan(rs.getString("renavan"));

        } catch (Exception ex) {
            Logger.getLogger(OnibusDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return onibus;
    }

    @Override
    public List pesquisarPorModelo(String modelo) throws SQLException {
        String sql = "SELECT * FROM onibus o INNER JOIN veiculo v ON o.idveiculo = v.id "
                + "WHERE v.modelo = ?";
        List<Onibus> onibuss = new ArrayList<>();
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, modelo);
            rs = psmt.executeQuery();
            while (rs.next()) {
                onibus = new Onibus();
                onibus.setId(rs.getInt("id"));
                onibus.setTipo(rs.getString("tipo"));
                onibus.setModelo(rs.getString("modelo"));
                onibus.setFabricante(rs.getString("fabricante"));
                onibus.setPlaca(rs.getString("placa"));
                onibus.setValor(rs.getDouble("valor"));
                onibus.setIpva(rs.getDouble("ipva"));
                onibus.setRenavan(rs.getString("renavan"));
                onibuss.add(onibus);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por modelo e fabricante " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return onibuss;
    }

}
