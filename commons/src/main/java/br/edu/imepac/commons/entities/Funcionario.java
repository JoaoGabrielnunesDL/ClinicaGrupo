package br.edu.imepac.commons.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

    private String numeroCpf;
    private String numeroRg;
    private String cargo;

    // Getters e Setters
    public String getNumeroCpf() { return numeroCpf; }
    public void setNumeroCpf(String numeroCpf) { this.numeroCpf = numeroCpf; }
    public String getNumeroRg() { return numeroRg; }
    public void setNumeroRg(String numeroRg) { this.numeroRg = numeroRg; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}