/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Moto;
import br.com.senaccompadrao.entidade.Moto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Junior
 */
public class MotoDaoImplTest {
    
    private Moto moto;
    private MotoDao motoDao;
    
    public MotoDaoImplTest() {
        motoDao = new MotoDaoImpl();
    }

    /**
     * Test of salvar method, of class MotoDaoImpl.
     */
//        @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        moto = new Moto(null, "250", "bis", "honda", "ASD-8000", 2000, 20, "215");
        calcularIpva();
        motoDao.salvar(moto);
        
        
    }
    
    

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        moto = new Moto(8, "400", "Clio Alterado",
                "Renault alterado", "ASD-8080Altera", 2000, 0,  "205Altera");
         motoDao.alterar(moto);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        motoDao.excluir(8);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
       System.out.println("pesquisarPorId");
        moto = (Moto) motoDao.pesquisarPorId(9);
        System.out.println(moto.getId());
        System.out.println(moto.getTipo());
        System.out.println(moto.getModelo());
        System.out.println(moto.getFabricante());
        System.out.println(moto.getPlaca());
        System.out.println(moto.getValor());
        System.out.println(moto.getIpva());
        System.out.println(moto.getRenavan());
    }

    public void calcularIpva() {
       moto.setIpva(moto.getValor() * 0.03);
    }

    /**
     * Test of pesquisarPorModelo method, of class MotoDaoimpl.
     */
    @Test
    public void testPesquisarPorModelo() throws Exception {
       System.out.println("pesquisarPorModelo");
        List<Moto> motis = motoDao.pesquisarPorModelo("bis");
        for (Moto moti : motis) {
            System.out.println(moti.getId());
            System.out.println(moti.getTipo());
            System.out.println(moti.getModelo());
            System.out.println(moti.getFabricante());
            System.out.println(moti.getPlaca());
            System.out.println(moti.getValor());
            System.out.println(moti.getIpva());
            System.out.println(moti.getRenavan());
    }
    
}
}
