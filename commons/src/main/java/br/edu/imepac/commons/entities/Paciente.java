package br.edu.imepac.commons.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {

    private String numeroCpf;
    private String convenio;

    // Getters e Setters
    public String getNumeroCpf() { return numeroCpf; }
    public void setNumeroCpf(String numeroCpf) { this.numeroCpf = numeroCpf; }
    public String getConvenio() { return convenio; }
    public void setConvenio(String convenio) { this.convenio = convenio; }
}