/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Onibus;
import br.com.senaccompadrao.entidade.Onibus;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Junior
 */
public class OnibusDaoImplTest {

    private Onibus onibus;
    private OnibusDao onibusDao;

    public OnibusDaoImplTest() {
        onibusDao = new OnibusDaoImpl();
    }

    /**
     * Test of salvar method, of class OnibusDaoImpl.
     */
//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        onibus = new Onibus(null, "20", "Bus", "Masterbus", "BUS-8888", 12000, 0, "205");
        calcularIpva();
        onibusDao.salvar(onibus);
    }

    /**
     * Test of alterar method, of class OnibusDaoImpl.
     */
//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        onibus = new Onibus(2, "4 alterado", "Clio Alterado",
                "Renault alterado", "ASD-8080Altera", 2000, 0, "205Altera");
        onibusDao.alterar(onibus);
    }

    /**
     * Test of excluir method, of class OnibusDaoImpl.
     */
//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        onibusDao.excluir(2);
    }

    /**
     * Test of pesquisarPorId method, of class OnibusDaoImpl.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        onibus = (Onibus) onibusDao.pesquisarPorId(10);
        System.out.println(onibus.getId());
        System.out.println(onibus.getTipo());
        System.out.println(onibus.getModelo());
        System.out.println(onibus.getFabricante());
        System.out.println(onibus.getPlaca());
        System.out.println(onibus.getValor());
        System.out.println(onibus.getIpva());
        System.out.println(onibus.getRenavan());
    }

    /**
     * Test of pesquisarPorModelo method, of class OnibusDaoImpl.
     */
//    @Test
    public void testPesquisarPorModelo() throws Exception {
        System.out.println("pesquisarPorModelo");
        List<Onibus> automoveis = onibusDao.pesquisarPorModelo("bus");
        for (Onibus automovei : automoveis) {
            System.out.println(automovei.getId());
            System.out.println(automovei.getTipo());
            System.out.println(automovei.getModelo());
            System.out.println(automovei.getFabricante());
            System.out.println(automovei.getPlaca());
            System.out.println(automovei.getValor());
            System.out.println(automovei.getIpva());
        }
    }

    public void calcularIpva() {
        onibus.setIpva(onibus.getValor() * 0.03);
    }
}
