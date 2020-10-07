package com.andre.dados.departamento;

public class Departamento {
    public int codigo;
    public String nome;
    public String sigla;

    public Departamento(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return codigo + ", " + nome + ", " + sigla;
    }
}