package br.com.senaccompadrao.dao;

import java.sql.SQLException;
import java.util.List;

public interface MotoDao extends VeiculoDao {

    List pesquisarPorModelo(String modelo) throws SQLException;
}
