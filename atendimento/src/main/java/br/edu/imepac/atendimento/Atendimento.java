package br.edu.imepac.atendimento;

import jakarta.persistence.*;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prontuario;
    private String receita;

    // Getters e Setters rápidos (para não precisar configurar Lombok à pressa)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProntuario() { return prontuario; }
    public void setProntuario(String prontuario) { this.prontuario = prontuario; }
    public String getReceita() { return receita; }
    public void setReceita(String receita) { this.receita = receita; }
}