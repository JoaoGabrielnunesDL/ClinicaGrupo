package br.edu.imepac.agendamento.services;

import br.edu.imepac.agendamento.dtos.ConsultaRequest;
import br.edu.imepac.agendamento.dtos.ConsultaResponse;
import br.edu.imepac.agendamento.models.ConsultaModel;
import br.edu.imepac.agendamento.models.FilaEsperaModel;
import br.edu.imepac.agendamento.models.PacienteModel;
import br.edu.imepac.agendamento.repositories.ConsultaRepository;
import br.edu.imepac.agendamento.repositories.FilaEsperaRepository;
import br.edu.imepac.agendamento.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private FilaEsperaRepository filaEsperaRepository;

    public boolean isHorarioDisponivel(Long medicoId, LocalDateTime dataHora) {
        return !consultaRepository.existsByMedicoIdAndDataHoraAndStatus(medicoId, dataHora, "AGENDADA");
    }

    public ConsultaResponse agendarConsulta(ConsultaRequest request) {
        log.info("Tentando agendar consulta para o médico {} em {}", request.getMedicoId(), request.getDataHora());
        
        PacienteModel paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        if (!isHorarioDisponivel(request.getMedicoId(), request.getDataHora())) {
            log.warn("Horário indisponível! Registrando na fila de espera...");
            FilaEsperaModel fila = new FilaEsperaModel(null, paciente, request.getMedicoId(), request.getDataHora());
            filaEsperaRepository.save(fila);
            throw new RuntimeException("Horário ocupado. Paciente adicionado à fila de espera.");
        }

        ConsultaModel consulta = new ConsultaModel();
        consulta.setPaciente(paciente);
        consulta.setMedicoId(request.getMedicoId());
        consulta.setDataHora(request.getDataHora());
        consulta.setStatus("AGENDADA");

        ConsultaModel salva = consultaRepository.save(consulta);

        ConsultaResponse response = new ConsultaResponse();
        BeanUtils.copyProperties(salva, response);
        response.setPacienteId(salva.getPaciente().getId());
        return response;
    }

    public void cancelarConsulta(Long id) {
        log.info("Cancelando consulta ID: {}", id);
        ConsultaModel consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        
        consulta.setStatus("CANCELADA");
        consultaRepository.save(consulta);
    }
}