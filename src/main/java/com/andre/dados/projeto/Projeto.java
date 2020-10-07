package com.andre.dados.projeto;

public class Projeto{
    public int codigo;
    public String titulo;
    public String dataInicio;
    public String dataFim;
    public int codigoDepartamento;
    public Projeto(int codigo, String titulo, int codigoDepartamento, String dataInicio, String dataFim) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public String toString() {
        return "Projeto [codigo=" + codigo + ", codigoDepartamento=" + codigoDepartamento + ", dataFim=" + dataFim
                + ", dataInicio=" + dataInicio + ", titulo=" + titulo + "]";
    }
}
