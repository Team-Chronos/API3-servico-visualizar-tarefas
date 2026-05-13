package com.api.visualizarTarefas.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.visualizarTarefas.modelo.TipoTarefa;
import com.api.visualizarTarefas.servico.servicoTipoTarefa;

@RestController
@RequestMapping("/tipoTarefa")
@CrossOrigin(origins = "*")
public class controleTipoTarefa {

    @Autowired
    private servicoTipoTarefa servicoTipoTarefa;

    @GetMapping
    public ResponseEntity<List<TipoTarefa>> listarTipoTarefas(){
        return ResponseEntity.ok(servicoTipoTarefa.listarTipoTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTarefa> listarTipoTarefasId(@PathVariable Long id){
    return ResponseEntity.ok(servicoTipoTarefa.listarTipoTarefasId(id).stream().findFirst().orElse(null));
    }
}
