package br.com.senaccompadrao.controle;

/**
 *
 * @author Pedro Junior
 */
import br.com.senaccompadrao.dao.MotoDao;
import br.com.senaccompadrao.dao.MotoDaoImpl;
import br.com.senaccompadrao.entidade.Moto;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MotoControle implements CalcularIpva, Serializable{
    
    private MotoDao motoDao;
    private Moto moto;
    
    public void Moto(Moto moto){
        moto = moto;
        motoDao = new MotoDaoImpl();
        try {
            calcularIpva();
            motoDao.salvar(moto);
        } catch (MySQLIntegrityConstraintViolationException e) {
            if(e.getCause().toString().
                    contains("Duplicate entry " + moto.getPlaca())){
                JOptionPane.showMessageDialog(null,
                    "Já existe uma moto com esta placa");
            }
            if(e.getCause().toString().
                    contains("Duplicate entry " + moto.getRenavan())){
                JOptionPane.showMessageDialog(null,
                    "Já existe um automóvel com esse Renavan");
            }
            System.out.println(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "moto");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar "
                                               + "moto");
            System.out.println("Erro ao salvar " + ex.getMessage());
            ex.getStackTrace();
        }
    }
    @Override
    public void calcularIpva() {
        moto.setIpva(moto.getValor() * 0.03);
    }
}
