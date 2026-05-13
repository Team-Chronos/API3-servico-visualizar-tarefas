package com.api.visualizarTarefas.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.visualizarTarefas.modelo.TipoTarefa;
import com.api.visualizarTarefas.repositorio.repositorioTipoTarefa;

@Service
public class servicoTipoTarefa {

    @Autowired
    private repositorioTipoTarefa repositorioTipoTarefa;

    public List<TipoTarefa> listarTipoTarefas() {
        return repositorioTipoTarefa.findAll();
    }

    public List<TipoTarefa> listarTipoTarefasId(Long id) {
        return repositorioTipoTarefa.findById(id).stream().toList();
    }
}