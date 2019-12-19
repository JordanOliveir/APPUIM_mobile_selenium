package Suporte;

import java.sql.*;

public class ConnectionFactory {
    private ConnectionFactory dataSource;


    private String hostname;
    private int porta;
    private String dataBase;
    private String username;
    private String password;

    private Connection connection;

    public ConnectionFactory() {
        try {
            hostname = "172.20.30.100";
            porta = 3310;
            dataBase = "bkm_automacao";
            username = "programador";
            password = "finnet10@";

            String url = "jdbc.mysql://"+hostname+":"+porta+"/"+dataBase;

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url,username,password);

            System.out.println("SQL Conectada");
        }catch (SQLException ex){
            System.out.println("Erro na conexão "+ex.getMessage());
        }catch (Exception ex){
            System.out.println("ErroGeral "+ex.getMessage());
        }
    }

    public Connection getConnection(){
        return this.getConnection();
    }

    public void closeDataSource(){
        try {
            connection.close();
        }catch (Exception ex){
            System.out.println("Erro na Desconexão "+ex.getMessage());
        }
    }

    public String SelectRemessa(String pagamento){
        try {
            String SQL = "\n" +
                    "SELECT arq.arq_nome\n" +
                    "FROM folha_detalhe fol\n" +
                    "INNER JOIN arquivo arq ON(fol.arq_id_geracao = arq.arq_id)\n" +
                    "WHERE fol.fol_nro_pagto = "+pagamento+";";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);//MANDA O SQL COMO UMA INSTRUÇÃO DO MYSQL
            ResultSet rs = ps.executeQuery();//POR SER UMA QUERY PRECISA SER ARMAZENADO EM UMA EXECUTEQUERY PRA TRAZER O RESULTADO

        return rs.getString(pagamento);
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Erro geral " + ex.getMessage());
        }
        return null;
    }
}
