package com.api.visualizarTarefas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.visualizarTarefas.modelo.Tarefa;
import com.api.visualizarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoTarefa {

    @Autowired
    private repositorioTarefa repositorioTarefa;

    public List<Tarefa> listarTarefas() {
        return repositorioTarefa.findAll();
    }

    public List<Tarefa> listarTarefasPorProjeto(Long projetoId) {
        return repositorioTarefa.findByProjetoId(projetoId);
    }

    public List<Tarefa> listarTarefasPorResponsavel(Long id) {
        return repositorioTarefa.findByResponsavelId(id);
    }

    public List<Tarefa> listarTarefasPorProjetoEResponsavel(Long projetoId, Long responsavelId) {
        return repositorioTarefa.findByProjetoIdAndResponsavelId(projetoId, responsavelId);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return repositorioTarefa.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }
}
