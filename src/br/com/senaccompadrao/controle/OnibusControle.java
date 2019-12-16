package br.com.senaccompadrao.controle;

import br.com.senaccompadrao.dao.OnibusDao;
import br.com.senaccompadrao.dao.OnibusDaoImpl;
import br.com.senaccompadrao.entidade.Onibus;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OnibusControle implements CalcularIpva, Serializable{
    
    private OnibusDao onibusDao;
    private Onibus onibus;
    
    public void Onibus(Onibus onibus){
        onibus = onibus;
        onibusDao = new OnibusDaoImpl();
        try {
            calcularIpva();
            onibusDao.salvar(onibus);
        } catch (MySQLIntegrityConstraintViolationException e) {
            if(e.getCause().toString().
                    contains("Duplicate entry " + onibus.getPlaca())){
                JOptionPane.showMessageDialog(null,
                    "Já existe uma onibus com esta placa");
            }
            if(e.getCause().toString().
                    contains("Duplicate entry " + onibus.getRenavan())){
                JOptionPane.showMessageDialog(null,
                    "Já existe um automóvel com esse Renavan");
            }
            System.out.println(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "onibus");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "onibus");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    @Override
    public void calcularIpva() {
        onibus.setIpva(onibus.getValor() * 0.03);
    }
}
