package com.andre.dados.participacao;

import com.andre.dados.funcionario.Funcionario;
import com.andre.dados.projeto.Projeto;

public class Participacao{
    public int codigo;
    public Projeto projeto;
    public Funcionario funcionario;
    public String dataEntrada;
    public String dataSaida;

    public Participacao(int codigo, Projeto projeto, Funcionario funcionario, String dataEntrada, String dataSaida){
        this.codigo = codigo;
        this.projeto = projeto;
        this.funcionario = funcionario;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString(){
        return "Participacao {"+
                "codigo:" + codigo +
                ",projeto:" + projeto +
                ",funcionario:" + funcionario +
                ",dataEntrada:" + dataEntrada +
                ",dataSaida:" + dataSaida + "}";
    }
}