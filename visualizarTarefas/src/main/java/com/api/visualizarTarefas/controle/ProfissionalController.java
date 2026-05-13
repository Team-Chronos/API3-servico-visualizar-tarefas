package com.api.visualizarTarefas.controle;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.visualizarTarefas.modelo.DTO.ProfissionalNomeDTO;
import com.api.visualizarTarefas.servico.ProfissionalExternoServico;

@RestController
@RequestMapping("/api/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    private final ProfissionalExternoServico profissionalExternoServico;

    public ProfissionalController(ProfissionalExternoServico profissionalExternoServico) {
        this.profissionalExternoServico = profissionalExternoServico;
    }

    @GetMapping("/nomes")
    public List<ProfissionalNomeDTO> listarNomes() {
        return profissionalExternoServico.listarNomesProfissionais();
    }
}