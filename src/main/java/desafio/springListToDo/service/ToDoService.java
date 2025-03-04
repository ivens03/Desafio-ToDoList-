package desafio.springListToDo.service;

import desafio.springListToDo.entity.ToDoEntity;
import desafio.springListToDo.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoEntity> create(ToDoEntity toDos) {
        toDoRepository.save(toDos);
        return list();
    }

    public List<ToDoEntity> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<ToDoEntity> update(ToDoEntity toDos) {
        toDoRepository.save(toDos);
        return list();
    }

    public List<ToDoEntity> delete(Long id) {
        toDoRepository.deleteById(id);
        return list();
    }
}
