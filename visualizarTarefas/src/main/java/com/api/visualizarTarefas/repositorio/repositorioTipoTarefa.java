package com.api.visualizarTarefas.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.visualizarTarefas.modelo.TipoTarefa;

public interface repositorioTipoTarefa extends JpaRepository<TipoTarefa, Long> {
    
}
