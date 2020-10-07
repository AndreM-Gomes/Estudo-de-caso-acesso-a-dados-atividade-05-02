package com.andre.dados.participacao;

import com.andre.dados.ConnectionFactory;
import com.andre.dados.funcionario.Funcionario;
import com.andre.dados.projeto.Projeto;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ParticipacaoGateway {
    private Connection conn = ConnectionFactory.getConnection();

    public List<Participacao> getAll() throws SQLException {
        List<Participacao> participacoes = new LinkedList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT participacoes.codigo as participacao_codigo," +
                    "participacoes.data_entrada as data_entrada_projeto," +
                    "participacoes.data_saida as data_saida_projeto" +
                    "projetos.codigo as codigo_projeto" +
                    "projetos.titulo as titulo_projeto," +
                    "projetos.data_inicio as data_inicio_projeto," +
                    "projetos.data_fim as data_fim_projeto," +
                    "funcionarios.cpf as cpf_funcionario," +
                    "funcionarios.nome as nome_funcionario," +
                    "funcionarios.email as email_funcionario " +
                    " FROM participacoes" +
                "INNER JOIN funcionarios ON participacoes.cpf_funcionarios=funcionarios.cpf" +
                "INNER JOIN projetos ON participacoes.codigo_projeto=projetos.codigo");

        while(rs.next()) {
            Funcionario funcionario = new Funcionario(
                    rs.getString("cpf_funcionario"),
                    rs.getString("nome_funcionario"),
                    rs.getString("email_funcionario"),
                    0
            );
            Projeto projeto = new Projeto(
                    rs.getInt("codigo_projeto"),
                    rs.getString("titulo_projeto"),
                    0,
                    rs.getString("data_inicio_projeto"),
                    rs.getString("data_fim_projeto")
            );
            participacoes.add(
                    new Participacao(
                            rs.getInt("participacao_codigo"),
                            projeto,
                            funcionario,
                            rs.getString("data_entrada_projeto"),
                            rs.getString("data_saida_projeto"))
            );
        }
        rs.close();

        return participacoes;
    }

    public void create(int codigo, int codigoProjeto, String cpfFuncionario, String dataEntrada, String dataSaida) throws SQLException {
        String SQL_INSERT = "INSERT INTO participacao (codigo, codigo_projeto, cpf_funcionario,data_entrada,data_saida)" +
                " VALUES (?,?,?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);
        pstm.setInt(1,codigo);
        pstm.setInt(2, codigoProjeto);
        pstm.setString(3, cpfFuncionario);
        pstm.setString(4, dataEntrada);
        pstm.setString(5,dataSaida);
        pstm.execute();
        pstm.close();
    }

    public void update(int codigo, int codigoProjeto, String cpfFuncionario, String dataEntrada, String dataSaida) throws SQLException  {
        String SQL_UPDATE = "UPDATE participacao " +
                "SET codigo_projeto = ?, cpf_funcionario = ?, data_entrada = ?, data_saida = ? WHERE codigo = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);
        pstm.setInt(1,codigoProjeto);
        pstm.setString(2, cpfFuncionario);
        pstm.setString(3, dataEntrada);
        pstm.setString(4, dataSaida);
        pstm.setInt(5, codigo);
        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(int codigo) throws SQLException  {
        String SQL_DELETE = "DELETE FROM participacao WHERE codigo = ?;";
        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);
        pstm.setInt(1, codigo);
        pstm.executeUpdate();
        pstm.close();
    }
}