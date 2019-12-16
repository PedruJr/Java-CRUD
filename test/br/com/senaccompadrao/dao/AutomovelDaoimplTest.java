/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.controle.CalcularIpva;
import br.com.senaccompadrao.entidade.Automovel;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author silvio.junior
 */
public class AutomovelDaoimplTest implements CalcularIpva{
    
    private Automovel automovel;
    private AutomovelDao automovelDao;
    
    public AutomovelDaoimplTest() {
        automovelDao = new AutomovelDaoimpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        automovel = new Automovel(null, "4", "Clio", "Renault", "ASD-8080", 2000, 0, "205");
        calcularIpva();
        automovelDao.salvar(automovel);
        
        
    }
    
    

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        automovel = new Automovel(2, "4 alterado", "Clio Alterado",
                "Renault alterado", "ASD-8080Altera", 2000, 0,  "205Altera");
         automovelDao.alterar(automovel);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        automovelDao.excluir(3);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
       System.out.println("pesquisarPorId");
        automovel = (Automovel) automovelDao.pesquisarPorId(2);
        System.out.println(automovel.getId());
        System.out.println(automovel.getTipo());
        System.out.println(automovel.getModelo());
        System.out.println(automovel.getFabricante());
        System.out.println(automovel.getPlaca());
        System.out.println(automovel.getValor());
        System.out.println(automovel.getIpva());
        System.out.println(automovel.getRenavan());
    }

    @Override
    public void calcularIpva() {
       automovel.setIpva(automovel.getValor() * 0.03);
    }

    /**
     * Test of pesquisarPorModelo method, of class AutomovelDaoimpl.
     */
//    @Test
    public void testPesquisarPorModelo() throws Exception {
       System.out.println("pesquisarPorModelo");
        List<Automovel> automoveis = automovelDao.pesquisarPorModelo("clio");
        for (Automovel automovei : automoveis) {
            System.out.println(automovei.getId());
            System.out.println(automovei.getTipo());
            System.out.println(automovei.getModelo());
            System.out.println(automovei.getFabricante());
            System.out.println(automovei.getPlaca());
            System.out.println(automovei.getValor());
            System.out.println(automovei.getIpva());
    }
    
}
}
