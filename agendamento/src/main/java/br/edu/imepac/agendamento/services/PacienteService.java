package br.edu.imepac.agendamento.services;

import br.edu.imepac.agendamento.dtos.PacienteRequest;
import br.edu.imepac.agendamento.dtos.PacienteResponse;
import br.edu.imepac.agendamento.models.PacienteModel;
import br.edu.imepac.agendamento.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
  
    public PacienteResponse cadastrar(PacienteRequest request) {
        log.info("Cadastrando paciente: {}", request.getNome());
        PacienteModel model = new PacienteModel();
        BeanUtils.copyProperties(request, model);
        PacienteModel salvo = pacienteRepository.save(model);
        
        PacienteResponse response = new PacienteResponse();
        BeanUtils.copyProperties(salvo, response);
        return response;
    }
}