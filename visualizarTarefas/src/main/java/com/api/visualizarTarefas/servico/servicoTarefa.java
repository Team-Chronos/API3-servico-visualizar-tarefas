package com.api.visualizarTarefas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.api.visualizarTarefas.modelo.Tarefa;
import com.api.visualizarTarefas.repositorio.repositorioTarefa;

@Service
public class servicoTarefa {

    @Autowired
    private repositorioTarefa repositorioTarefa;

    @Cacheable(value = "tarefas")
    public List<Tarefa> listarTarefas() {
        return repositorioTarefa.findAll();
    }

    @Cacheable(value = "tarefas-projeto", key = "#projetoId")
    public List<Tarefa> listarTarefasPorProjeto(Long projetoId) {
        return repositorioTarefa.findByProjetoId(projetoId);
    }

    @Cacheable(value = "tarefas-responsavel", key = "#id")
    public List<Tarefa> listarTarefasPorResponsavel(Long id) {
        return repositorioTarefa.findByResponsavelId(id);
    }

    @Cacheable(value = "tarefas-projeto-responsavel", key = "#projetoId + '-' + #responsavelId")
    public List<Tarefa> listarTarefasPorProjetoEResponsavel(Long projetoId, Long responsavelId) {
        return repositorioTarefa.findByProjetoIdAndResponsavelId(projetoId, responsavelId);
    }

    @Cacheable(value = "tarefa", key = "#id")
    public Tarefa buscarTarefaPorId(Long id) {
        return repositorioTarefa.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }
}
