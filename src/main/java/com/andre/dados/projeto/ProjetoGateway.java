package com.andre.dados.projeto;

import com.andre.dados.ConnectionFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProjetoGateway {
    private Connection conn = ConnectionFactory.getConnection();

    public List<Projeto> getAll() throws SQLException {
        List<Projeto> projetos = new LinkedList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM projetos;");

        while(rs.next()) {
            projetos.add(new Projeto(
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getInt("codigo_departamento"),
                    rs.getString("data_inicio"),
                    rs.getString("data_fim")
            ));
        }
        rs.close();

        return projetos;
    }

    public void create(int codigo, String titulo, String dataInicio, String dataFim) throws SQLException {
        String SQL_INSERT = "INSERT INTO projetos (codigo, titulo, data_inicio, data_fim) VALUES (?,?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);
        pstm.setInt(1, codigo);
        pstm.setString(2, titulo);
        pstm.setString(3, dataInicio);
        pstm.setString(4, dataFim);
        pstm.execute();
        pstm.close();
    }

    public void update(int codigo, String titulo, String dataInicio, String dataFim) throws SQLException  {
        String SQL_UPDATE = "UPDATE projetos SET titulo = ?, data_inicio = ?, data_fim = ? WHERE codigo = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);
        pstm.setString(1, titulo);
        pstm.setString(2, dataInicio);
        pstm.setString(3, dataFim);
        pstm.setInt(4, codigo);
        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(int codigo) throws SQLException  {
        String SQL_DELETE = "DELETE FROM projetos WHERE codigo = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();
        pstm.close();
    }
}