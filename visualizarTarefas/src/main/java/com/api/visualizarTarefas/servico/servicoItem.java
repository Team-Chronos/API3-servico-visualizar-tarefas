package com.api.visualizarTarefas.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.visualizarTarefas.modelo.Item;
import com.api.visualizarTarefas.modelo.Tarefa;
import com.api.visualizarTarefas.repositorio.repositorioItem;

@Service
public class servicoItem {

    @Autowired
    private repositorioItem repositorioItem;

    @Autowired
    private servicoTarefa servicoTarefa;

    public Item listarItemPorId(Long id) {
        return repositorioItem.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com ID: " + id));
    }

    public List<Item> listarItensPorTarefa(Long tarefaId) {
        return repositorioItem.findByTarefaId(tarefaId);
    }

    public List<Item> listarItensPorProjeto(Long projetoId) {
        List<Long> tarefaIds = servicoTarefa.listarTarefasPorProjeto(projetoId)
                .stream()
                .map(Tarefa::getId)
                .toList();
        if (tarefaIds.isEmpty()) return List.of();
        return repositorioItem.findByTarefaIdIn(tarefaIds);
    }

    public List<Item> listarItensPorProjetoEResponsavel(Long projetoId, Long responsavelId) {
        List<Long> tarefaIds = servicoTarefa.listarTarefasPorProjeto(projetoId)
                .stream()
                .filter(tarefa -> tarefa.getResponsavelId().equals(responsavelId))
                .map(Tarefa::getId)
                .toList();
        if (tarefaIds.isEmpty()) return List.of();
        return repositorioItem.findByTarefaIdIn(tarefaIds);
    }
}