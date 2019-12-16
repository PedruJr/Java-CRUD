package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Automovel;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovelDaoimpl extends VeiculoDaoImpl implements AutomovelDao, Serializable {

    private Automovel automovel;

    @Override
    public void salvar(Object object) throws SQLException, Exception {
        automovel = (Automovel) object;
        super.salvar(automovel);
        String sql = "INSERT INTO automovel(numeroPorta, idVeiculo)"
                + " VALUES(?, ?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, automovel.getNumeroPorta());
            psmt.setInt(2, automovel.getId());
            psmt.executeUpdate();

        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }

    }

    @Override
    public void alterar(Object object) throws SQLException {
        automovel = (Automovel) object;
        super.alterar(automovel);
        String sql = "UPDATE automovel SET numeroPorta = ?"
                + " WHERE idVeiculo = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, automovel.getNumeroPorta());
            psmt.setInt(2, automovel.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar auto "
                    + e.getMessage());
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
        String sql = "SELECT * FROM automovel a INNER JOIN veiculo v ON a.idVeiculo = v.id "
                + "WHERE a.idVeiculo = ? ";
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            automovel = new Automovel();
            rs.next();
            automovel.setId(id);
            automovel.setTipo(rs.getString("tipo"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setFabricante(rs.getString("fabricante"));
            automovel.setPlaca(rs.getString("placa"));
            automovel.setValor(rs.getDouble("valor"));
            automovel.setIpva(rs.getDouble("ipva"));
            automovel.setRenavan(rs.getString("renavan"));
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return automovel;
    }

    @Override
    public List pesquisarPorModelo(String nome) throws SQLException {
        String sql = "SELECT * FROM automovel a INNER JOIN veiculo v ON a.idVeiculo = v.id "
                + "WHERE v.modelo = ?";
        List<Automovel> automoveis = new ArrayList<>();
        try {
            conn = FabricaConexao.abrirConexao();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, nome);
            rs = psmt.executeQuery();
            while (rs.next()) {
                automovel = new Automovel();
                automovel.setId(rs.getInt("id"));
                automovel.setTipo(rs.getString("tipo"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setFabricante(rs.getString("fabricante"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setValor(rs.getDouble("valor"));
                automovel.setIpva(rs.getDouble("ipva"));
                automoveis.add(automovel);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por modelo " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conn, psmt, rs);
        }
        return automoveis;
    }

}
