package desafio.springListToDo.controller;

import desafio.springListToDo.entity.ToDoEntity;
import desafio.springListToDo.service.ToDoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDos")
@Tag(name = "Controller dos ToDos")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @Operation(summary = "Cria um ToDo no DB", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar")
    })
    @PostMapping
    List<ToDoEntity> create(@RequestBody ToDoEntity toDos) {
        toDoService.create(toDos);
        return toDoService.list();
    }

    @Operation(summary = "Retorna uma lista de ToDos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno feito com sucesso"),
    })
    @GetMapping
    List<ToDoEntity> list() {
        return toDoService.list();
    }

    @Operation(summary = "Atualiza um ToDo no DB", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar"),
            @ApiResponse(responseCode = "422", description = "Dados para requisição inválidos")
    })
    @PutMapping
    List<ToDoEntity> update(@RequestBody ToDoEntity toDos) {
        toDoService.update(toDos);
        return toDoService.list();
    }

    @Operation(summary = "Deleta um ToDo no DB", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado feito com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar")
    })
    @DeleteMapping("{id}")
    List<ToDoEntity> delete(@PathVariable("id") Long id) {
        toDoService.delete(id);
        return toDoService.list();
    }
}