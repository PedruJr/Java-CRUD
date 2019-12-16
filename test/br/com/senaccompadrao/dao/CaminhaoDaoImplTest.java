/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Automovel;
import br.com.senaccompadrao.entidade.Caminhao;
import br.com.senaccompadrao.entidade.Caminhao;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Junior
 */
public class CaminhaoDaoImplTest {

    private Caminhao caminhao;
    private CaminhaoDao caminhaoDao;

    public CaminhaoDaoImplTest() {
        caminhaoDao = new CaminhaoDaoImpl();
    }

    /**
     * Test of salvar method, of class CaminhaoDaoImpl.
     */
//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        caminhao = new Caminhao(null, "2", "Mercedez", "F300", "ASD-8090", 4000, 2, "210");
        calcularIpva();
        caminhaoDao.salvar(caminhao);
    }

    /**
     * Test of alterar method, of class CaminhaoDaoImpl.
     */
//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        caminhao = new Caminhao(2, "2 alterado", "fx250 Alterado",
                "Mercedez alterado", "ASD-8090Altera", 2000, 0, "210Altera");
        caminhaoDao.alterar(caminhao);
    }

    /**
     * Test of excluir method, of class CaminhaoDaoImpl.
     */
//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        caminhaoDao.excluir(3);
    }

    /**
     * Test of pesquisarPorId method, of class CaminhaoDaoImpl.
     */
//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        caminhao = (Caminhao) caminhaoDao.pesquisarPorId(5);
        System.out.println(caminhao.getId());
        System.out.println(caminhao.getTipo());
        System.out.println(caminhao.getModelo());
        System.out.println(caminhao.getFabricante());
        System.out.println(caminhao.getPlaca());
        System.out.println(caminhao.getValor());
        System.out.println(caminhao.getIpva());
        System.out.println(caminhao.getRenavan());
    }

    /**
     * Test of pesquisarPorModelo method, of class CaminhaoDaoImpl.
     */
    @Test
    public void testPesquisarPorModelo() throws Exception {
        System.out.println("pesquisarPorModelo");
        List<Caminhao> camiveiss = caminhaoDao.pesquisarPorModelo("mercedez");
        for (Caminhao camiveis : camiveiss) {
            System.out.println(camiveis.getId());
            System.out.println(camiveis.getTipo());
            System.out.println(camiveis.getModelo());
            System.out.println(camiveis.getFabricante());
            System.out.println(camiveis.getPlaca());
            System.out.println(camiveis.getValor());
            System.out.println(camiveis.getIpva());
            System.out.println(camiveis.getRenavan());
        }
    }

    public void calcularIpva() {
        caminhao.setIpva(caminhao.getValor() * 0.03);
    }

}
