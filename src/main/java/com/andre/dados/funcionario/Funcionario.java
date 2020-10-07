package com.andre.dados.funcionario;

public class Funcionario {
    public String cpf;
    public String nome;
    public String email;
    public int codigoDepartamento;

    public Funcionario(){}

    public Funcionario(String cpf,String nome, String email, int codigoDepartamento){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public String toString(){
        return "Funcionario {nome: " + this.nome + ", cpf: " + this.cpf + ", email: " + this.email + ", departamento: " + this.codigoDepartamento + "}";
    }
}
