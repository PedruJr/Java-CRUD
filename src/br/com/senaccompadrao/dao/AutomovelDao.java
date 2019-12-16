package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Automovel;
import java.sql.SQLException;
import java.util.List;

public interface AutomovelDao extends VeiculoDao {

    List<Automovel> pesquisarPorModelo(String modelo) throws SQLException;

}
