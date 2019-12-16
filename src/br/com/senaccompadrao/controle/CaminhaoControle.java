package br.com.senaccompadrao.controle;

/**
 *
 * @author Pedro Junior
 */
import br.com.senaccompadrao.dao.CaminhaoDao;
import br.com.senaccompadrao.dao.CaminhaoDaoImpl;
import br.com.senaccompadrao.entidade.Caminhao;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CaminhaoControle implements CalcularIpva, Serializable{
    
    private CaminhaoDao caminhaoDao;
    private Caminhao caminhao;
    
    public void Caminhao(Caminhao caminhao){
        caminhao = caminhao;
        caminhaoDao = new CaminhaoDaoImpl();
        try {
            calcularIpva();
            caminhaoDao.salvar(caminhao);
        } catch (MySQLIntegrityConstraintViolationException e) {
            if(e.getCause().toString().
                    contains("Duplicate entry " + caminhao.getPlaca())){
                JOptionPane.showMessageDialog(null,
                    "Já existe uma caminhao com esta placa");
            }
            if(e.getCause().toString().
                    contains("Duplicate entry " + caminhao.getRenavan())){
                JOptionPane.showMessageDialog(null,
                    "Já existe um automóvel com esse Renavan");
            }
            System.out.println(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "caminhao");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "caminhao");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    @Override
    public void calcularIpva() {
        caminhao.setIpva(caminhao.getValor() * 0.03);
    }
}
