package com.andre.dados.funcionario;

import com.andre.dados.ConnectionFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FuncionarioGateway {
    private Connection conn = ConnectionFactory.getConnection();

    public List<Funcionario> getAll() throws SQLException {
        List<Funcionario> funcionarios = new LinkedList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM funcionarios;");

        while(rs.next()) {
            funcionarios.add(new Funcionario(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getInt("codigo_departamento")
            ));
        }
        rs.close();

        return funcionarios;
    }

    public void create(String cpf, String nome, String email, int codigoDepartamento) throws SQLException {
        String SQL_INSERT = "INSERT INTO funcionarios (cpf, nome, email, codigo_departamento) VALUES (?,?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);
        pstm.setString(1, cpf);
        pstm.setString(2, nome);
        pstm.setString(3, email);
        pstm.setInt(4, codigoDepartamento);
        pstm.execute();
        pstm.close();
    }

    public void update(String cpf, String nome, String email, int codigoDepartamento) throws SQLException  {
        String SQL_UPDATE = "UPDATE funcionarios SET nome = ?, email = ?, codigo_departamento = ? WHERE cpf = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);
        pstm.setString(1, nome);
        pstm.setString(2, email);
        pstm.setString(3, String.valueOf(codigoDepartamento));
        pstm.setString(4, cpf);
        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(String cpf) throws SQLException {
        String SQL_DELETE = "DELETE FROM funcionarios WHERE cpf = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);
        pstm.setString(1, cpf);
        pstm.executeUpdate();
        pstm.close();
    }
}
