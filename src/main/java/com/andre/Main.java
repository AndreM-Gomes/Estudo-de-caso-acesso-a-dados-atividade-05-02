package com.andre;

import com.andre.dados.departamento.Departamento;
import com.andre.dados.departamento.DepartamentoGateway;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DepartamentoGateway dg = new DepartamentoGateway();

        System.out.println("Exibindo departamentos:");
        try {
            for (Departamento dep: dg.getAll()) {
                System.out.println(dep);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

