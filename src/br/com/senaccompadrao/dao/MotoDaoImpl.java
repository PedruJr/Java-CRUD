package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Moto;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoDaoImpl extends VeiculoDaoImpl implements MotoDao, Serializable {

    private Moto moto;
    private PreparedStatement psmt;
    private ResultSet rs;

    @Override
    public void salvar(Object object) throws SQLException, Exception {
        moto = (Moto) object;
        super.salvar(moto);
        String sql = "INSERT INTO moto (potencia, idveiculo)"
                + "VALUES (?, ?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, moto.getPotencia());
            psmt.setInt(2, moto.getId());
            psmt.executeUpdate();
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException, Exception {
        moto = (Moto) object;
        super.alterar(moto);
        String sql = "UPDATE moto SET potencia = ? WHERE idveiculo = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, moto.getPotencia());
            psmt.setInt(2, moto.getId());
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
        String sql = "SELECT * FROM moto m INNER JOIN veiculo v ON m.idveiculo = v.id "
                + "WHERE m.idveiculo = ? ";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            moto = new Moto();
            rs.next();
            moto.setId(id);
            moto.setTipo(rs.getString("tipo"));
            moto.setModelo(rs.getString("modelo"));
            moto.setFabricante(rs.getString("fabricante"));
            moto.setPlaca(rs.getString("placa"));
            moto.setValor(rs.getDouble("valor"));
            moto.setIpva(rs.getDouble("ipva"));
            moto.setRenavan(rs.getString("renavan"));
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return moto;
    }

    @Override
    public List pesquisarPorModelo(String modelo) throws SQLException {
        String sql = "SELECT * FROM moto m INNER JOIN veiculo v ON m.idveiculo = v.id "
                + "WHERE v.modelo = ?";
        List<Moto> motos = new ArrayList<>();
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, modelo);
            rs = psmt.executeQuery();
            while (rs.next()) {
                moto = new Moto();
                moto.setId(rs.getInt("id"));
                moto.setTipo(rs.getString("tipo"));
                moto.setModelo(rs.getString("modelo"));
                moto.setFabricante(rs.getString("fabricante"));
                moto.setPlaca(rs.getString("placa"));
                moto.setValor(rs.getDouble("valor"));
                moto.setIpva(rs.getDouble("ipva"));
                moto.setRenavan(rs.getString("renavan"));
                motos.add(moto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por modelo e fabricante " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return motos;
    }

}
