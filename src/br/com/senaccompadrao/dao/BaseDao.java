
package br.com.senaccompadrao.dao;

import java.sql.SQLException;


public interface BaseDao {
    
    public abstract void salvar(Object object) throws SQLException, Exception;
    
    void alterar(Object object) throws SQLException, Exception;
    
    void excluir(int id) throws SQLException;
    
    Object pesquisarPorId(int id)throws SQLException;
    
}
