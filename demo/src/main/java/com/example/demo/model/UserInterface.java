package com.example.demo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface extendendo JpaRepository para operações de CRUD em "Usuario"
public interface UserInterface extends JpaRepository<Agent, Long> {

    Optional<Agent> findById(Long id); // Método para buscar pelo ID

    Optional<Agent> findByNameIgnoreCaseContaining(String name); // buscando um usuário pleo nome;

}