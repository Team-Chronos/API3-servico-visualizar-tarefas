package com.api.visualizarTarefas.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.visualizarTarefas.modelo.Item;
import com.api.visualizarTarefas.servico.servicoItem;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itens")
public class controleItem {

    @Autowired
    private servicoItem servicoItem;

    @GetMapping("/tarefa/{tarefaId}")
    public ResponseEntity<List<Item>> listarItensPorTarefa(@PathVariable Long tarefaId) {
        return ResponseEntity.ok(servicoItem.listarItensPorTarefa(tarefaId));
    }

    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<Item>> listarItensPorProjeto(@PathVariable Long projetoId) {
        return ResponseEntity.ok(servicoItem.listarItensPorProjeto(projetoId));
    }

    @GetMapping("/projeto/{projetoId}/responsavel/{responsavelId}")
    public ResponseEntity<List<Item>> listarItensPorProjetoEResponsavel(
            @PathVariable Long projetoId, @PathVariable Long responsavelId) {
        return ResponseEntity.ok(servicoItem.listarItensPorProjetoEResponsavel(projetoId, responsavelId));
    }
}