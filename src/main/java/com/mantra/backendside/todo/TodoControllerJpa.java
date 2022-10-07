package com.mantra.backendside.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@SessionAttributes("name")
public class TodoControllerJpa {

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();

        this.todoRepository = todoRepository;
    }

    private TodoRepository todoRepository;



    @RequestMapping("/user/list-todos")
    public ModelAndView listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);

        return new ModelAndView("listTodos");
    }

    @RequestMapping(value="/user/add-todo", method = RequestMethod.GET)
    public ModelAndView showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername(model);
        Todo todo = new Todo();
        //Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        todo.setUsername(username);
        model.put("todo", todo);

        return new ModelAndView("todo");
    }

    @RequestMapping(value="/user/add-todo", method = RequestMethod.POST)
    public ModelAndView addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
       if(result.hasErrors()){
           return new ModelAndView("todo");
       }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return new ModelAndView("redirect:list-todos");
    }

    @RequestMapping(value="/user/delete-todo")
    public ModelAndView deleteTodo(@RequestParam int id) {
        //Delete todo
        todoRepository.deleteById(id);
        return new ModelAndView("redirect:list-todos");

    }
    @RequestMapping(value="/user/update-todo", method = RequestMethod.GET)
    public ModelAndView showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return new ModelAndView("todo");
    }

    @RequestMapping(value="/user/update-todo", method = RequestMethod.POST)
    public ModelAndView updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            new ModelAndView("todo");
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return new ModelAndView("redirect:list-todos");
    }

    private String getLoggedInUsername(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
