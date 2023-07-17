package br.com.ronnyribeiro.todolistchallenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ronnyribeiro.todolistchallenger.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
