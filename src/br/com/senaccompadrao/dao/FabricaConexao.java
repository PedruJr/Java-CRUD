package br.com.senaccompadrao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection abrirConexao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.
                getConnection("jdbc:mysql://localhost:3306/senacComPadrao",
                        "root", "");
    }

    public static void fecharConexao(Connection conn,
            PreparedStatement ps) {
        fechar(conn, ps, null);
    }

    public static void fecharConexao(Connection conn,
            PreparedStatement ps, ResultSet rs) {
        fechar(conn, ps, rs);
    }

    private static void fechar(Connection conn, PreparedStatement ps,
            ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlE) {
            System.out.println("Erro ao fechar conexão "
                    + sqlE.getMessage());
        }
    }
}
