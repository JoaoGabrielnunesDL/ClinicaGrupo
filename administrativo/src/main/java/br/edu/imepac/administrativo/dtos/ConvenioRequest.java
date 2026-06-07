package br.edu.imepac.administrativo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConvenioRequest {

    @NotBlank(message = "O nome do convênio é obrigatório!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do convênio é obrigatória!")
    @Size(max = 255, message = "A descrição não pode passar de 255 caracteres")
    private String descricao;
}
