package br.edu.imepac.administrativo.services;

import br.edu.imepac.administrativo.dtos.ConvenioRequest;
import br.edu.imepac.administrativo.dtos.ConvenioResponse;
import br.edu.imepac.administrativo.models.ConvenioModel;
import br.edu.imepac.administrativo.repositories.ConvenioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    public ConvenioResponse cadastrar(ConvenioRequest request) {
        log.info("Cadastrando novo convênio: {}", request.getNome());
        ConvenioModel model = new ConvenioModel();
        BeanUtils.copyProperties(request, model);

        ConvenioModel salvo = convenioRepository.save(model);

        ConvenioResponse response = new ConvenioResponse();
        BeanUtils.copyProperties(salvo, response);
        return response;
    }

    public List<ConvenioResponse> listarTodos() {
        log.info("Listando todos os convênios");
        return convenioRepository.findAll().stream().map(model -> {
            ConvenioResponse response = new ConvenioResponse();
            BeanUtils.copyProperties(model, response);
            return response;
        }).collect(Collectors.toList());
    }

    public ConvenioResponse buscarPorId(Long id) {
        log.info("Buscando convênio pelo ID: {}", id);
        ConvenioModel model = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com o ID: " + id));

        ConvenioResponse response = new ConvenioResponse();
        BeanUtils.copyProperties(model, response);
        return response;
    }

    public ConvenioResponse alterar(Long id, ConvenioRequest request) {
        log.info("Alterando convênio ID: {}", id);
        ConvenioModel model = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com o ID: " + id));

        BeanUtils.copyProperties(request, model);
        ConvenioModel atualizado = convenioRepository.save(model);

        ConvenioResponse response = new ConvenioResponse();
        BeanUtils.copyProperties(atualizado, response);
        return response;
    }

    public void excluir(Long id) {
        log.info("Excluindo convênio ID: {}", id);
        ConvenioModel model = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convênio não encontrado com o ID: " + id));
        convenioRepository.delete(model);
    }
}
