package com.practica1.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController
{

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/list")
    Iterable<Task> getTaskList()
    {
        return taskRepository.findAll();
    }

    @PostMapping("/add")
    public String addTask(
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam String colorTitle,
            @RequestParam String colorBody
    )
    {
        final Task task = new Task();
        task.setTitle(title);
        task.setBody(body);
        task.setColorTitle(colorTitle);
        task.setColorBody(colorBody);
        taskRepository.save(task);
        return "Se ha agregado una nueva tarea";
    }

    @GetMapping("/task/{id}")
    public Task findTask(@PathVariable int id)
    {
        return taskRepository.findTaskById(id);
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam int id)
    {
        taskRepository.deleteById(id);
        return String.format("Se ha eliminado la tarea con el id %s!", id);
    }
}
