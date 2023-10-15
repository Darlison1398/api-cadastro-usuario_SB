package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInterface;
import com.example.demo.service.AgentService;
import com.example.demo.model.Agent;

    @RestController
    @RequestMapping("/usuarios")
    public class MainController {
    
        @Autowired
        private UserInterface usuarioRepository;
    
        @GetMapping
        public List<Agent> obterUsuarios() {
            List<Agent> usuarios = usuarioRepository.findAll();

            // Imprime os dados dos usuários no console
            for (Agent usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getName() + ", Idade: " + usuario.getIdade());
            }
    
            return usuarios;
        }


        @Autowired
        private AgentService agentService;

        @PostMapping("/criar")
        public void salvarAgent(@RequestBody Agent agent) {
            agentService.salvarAgent(agent);
        }

        @PutMapping("/editar")
        public void atualizarAgent(@RequestBody Agent agent){
            agentService.atualizarAgent(agent);
        }

        @DeleteMapping("/deletar/{id}")
        public void deletarAgent(@PathVariable Long id) {
            agentService.deletarAgent(id);
        }

        @GetMapping("/buscarPorId/{id}")
        public Agent buscarPorId(@PathVariable Long id){
            return agentService.buscarPorId(id);
        }

        @GetMapping("buscarPorNome/{name}")
        public Agent buscarPorName(@PathVariable String name){

            return agentService.buscarPorName(name);
        }

}
