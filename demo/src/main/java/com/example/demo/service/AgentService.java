package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;
import com.example.demo.model.UserInterface;

@Service
public class AgentService {
    
    @Autowired
    private UserInterface userInterface;

    public void salvarAgent(Agent agent) {
        userInterface.save(agent);
    }

    public void atualizarAgent(Agent agent) {

        if(userInterface.existsById(agent.getId())){
            userInterface.save(agent);
        } else {
            throw new IllegalArgumentException("Agente não encontrado");
        }
    }


    public void deletarAgent(Long id) {

        if (userInterface.existsById(id)){
            userInterface.deleteById(id);
        } else {
            throw new IllegalArgumentException("Agente não encontrado");
        }
    }


    public Agent buscarPorId(Long id) {

        //Optional<Agent> optionalAgent = userInterface.findById(id);
        //return optionalAgent.orElseThrow ( () -> new IllegalArgumentException("Usuário não encontrado!!!"));

        return userInterface.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!!!"));
    }

    public Agent buscarPorName(String name) {

        return userInterface.findByNameIgnoreCaseContaining(name)
        .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!!!"));
    }

}
