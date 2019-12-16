package br.com.senaccompadrao.controle;

import br.com.senaccompadrao.dao.AutomovelDao;
import br.com.senaccompadrao.dao.AutomovelDaoimpl;
import br.com.senaccompadrao.entidade.Automovel;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AutomovelControle implements CalcularIpva, Serializable {

    private AutomovelDao automovelDao;
    private Automovel automovel;

    public void salvarAutomovel(Automovel auto) {
        automovel = auto;
        automovelDao = new AutomovelDaoimpl();
        try {
            calcularIpva();
            automovelDao.salvar(auto);
        } catch (MySQLIntegrityConstraintViolationException e) {

            if (e.getCause().toString().
                    contains("Duplicate entry " + auto.getPlaca())) {
                JOptionPane.showMessageDialog(null,
                        "Já existe um automóvel com essa placa");
            }
            if (e.getCause().toString().
                    contains("Duplicate entry " + auto.getRenavan())) {
                JOptionPane.showMessageDialog(null,
                        "Já existe um automóvel com esse Renavan");
            }
            System.out.println(e);
//          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                    + "automovel");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                    + "automovel");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }
    }

    @Override
    public void calcularIpva() {
        automovel.setIpva(automovel.getValor() * 0.03);
    }
}
