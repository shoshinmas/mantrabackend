package com.mantra.backendside.todo;

import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.http.HttpHeaders;
import java.util.List;

@RestController
@SessionAttributes("name")
@RequestMapping("/user")
public class TodoControllerJpa {

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();

        this.todoRepository = todoRepository;
    }

    private final TodoRepository todoRepository;



    @RequestMapping("list-todos")
    public ModelAndView listAllTodos(ModelMap model) {
        //String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername("mantra");
        model.addAttribute("todos", todos);

        return new ModelAndView("listTodos");
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public ModelAndView showNewTodoPage(ModelMap model) {
        //String username = getLoggedInUsername(model);
        Todo todo = new Todo();
        //Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        todo.setUsername("mantra");
        model.put("todo", todo);

        return new ModelAndView("todo");
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public ModelAndView addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
       if(result.hasErrors()){
           return new ModelAndView("todo");
       }
        //String username = getLoggedInUsername(model);
        todo.setUsername("mantra");
        todoRepository.save(todo);
        return new ModelAndView("redirect:list-todos");
    }

    @RequestMapping(value="/delete-todo")
    public ModelAndView deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return new ModelAndView("redirect:list-todos");

    }
    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public ModelAndView showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return new ModelAndView("todo");
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public ModelAndView updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            new ModelAndView("todo");
        }
        //String username = getLoggedInUsername(model);
        todo.setUsername("mantra");
        todoRepository.save(todo);
        return new ModelAndView("redirect:list-todos");
    }


    @RequestMapping(value="/todo/{id}", method = RequestMethod.GET)
    public HttpEntity<Todo> sendJsonTodo(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range");
        Todo todo = todoRepository.findById(id).get();
        HttpEntity<Todo> response = new HttpEntity<>(todo, headers);
        return response;
    }

//    private String getLoggedInUsername(ModelMap model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
}
