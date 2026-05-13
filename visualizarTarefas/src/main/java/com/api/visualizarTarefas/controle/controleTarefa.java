package com.api.visualizarTarefas.controle;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.visualizarTarefas.modelo.DTO.disponibilidadeProjetoDTO;
import com.api.visualizarTarefas.modelo.Tarefa;
import com.api.visualizarTarefas.servico.servicoDisponibilidadeProjeto;
import com.api.visualizarTarefas.servico.servicoTarefa;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class controleTarefa {

    @Autowired
    private servicoTarefa servicoTarefa;

    @Autowired
    private servicoDisponibilidadeProjeto servicoDisponibilidadeProjeto;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = servicoTarefa.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Tarefa tarefa = servicoTarefa.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<Tarefa>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
        List<Tarefa> tarefas = servicoTarefa.listarTarefasPorProjeto(projetoId);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/projeto/{projetoId}/disponibilidade")
    public ResponseEntity<disponibilidadeProjetoDTO> buscarDisponibilidadeProjeto(@PathVariable Long projetoId) {
        disponibilidadeProjetoDTO disponibilidade = servicoDisponibilidadeProjeto.obterDisponibilidadeProjeto(projetoId);
        return ResponseEntity.ok(disponibilidade);
    }

    @GetMapping("/responsavel/{id}")
    public ResponseEntity<List<Tarefa>> listarTarefasPorResponsavel(@PathVariable Long id) {
        List<Tarefa> tarefas = servicoTarefa.listarTarefasPorResponsavel(id);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/projeto/{projetoId}/responsavel/{id}")
    public ResponseEntity<List<Tarefa>> listarTarefasPorProjetoEResponsavel(
            @PathVariable Long projetoId, 
            @PathVariable Long id) {
        List<Tarefa> tarefas = servicoTarefa.listarTarefasPorProjetoEResponsavel(projetoId, id);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/responsaveis")
    public ResponseEntity<List<Long>> listarResponsaveisUnicos() {
        List<Tarefa> tarefas = servicoTarefa.listarTarefas();
        List<Long> responsaveis = tarefas.stream()
            .map(Tarefa::getResponsavelId)
            .filter(Objects::nonNull)
            .distinct()
            .toList();
        return ResponseEntity.ok(responsaveis);
    }
}