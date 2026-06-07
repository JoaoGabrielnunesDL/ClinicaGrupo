package br.edu.imepac.administrativo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "convenios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao; // ou 'descricao' caso seu Service use em português
}