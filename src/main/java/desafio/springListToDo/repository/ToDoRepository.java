package desafio.springListToDo.repository;

import desafio.springListToDo.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
