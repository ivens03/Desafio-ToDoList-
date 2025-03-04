package desafio.springListToDo.controller;

import desafio.springListToDo.entity.ToDoEntity;
import desafio.springListToDo.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDos")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    List<ToDoEntity> create(@RequestBody ToDoEntity toDos) {
        toDoService.create(toDos);
        return toDoService.list();
    }

    @GetMapping
    List<ToDoEntity> list() {
        return toDoService.list();
    }

    @PutMapping
    List<ToDoEntity> update(@RequestBody ToDoEntity toDos) {
        toDoService.update(toDos);
        return toDoService.list();
    }

    @DeleteMapping("{id}")
    List<ToDoEntity> delete(@PathVariable("id") Long id) {
        toDoService.delete(id);
        return toDoService.list();
    }
}