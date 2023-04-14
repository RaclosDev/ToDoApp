package com.raclosdev.todoapp.service;

import com.raclosdev.todoapp.excepions.ToDoExceptions;
import com.raclosdev.todoapp.mapper.TaskInDTOToTask;
import com.raclosdev.todoapp.persistence.entity.Task;
import com.raclosdev.todoapp.persistence.entity.TaskStatus;
import com.raclosdev.todoapp.persistence.repository.TaskRepository;
import com.raclosdev.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskInDTOToTask taskInDTOToTaskMapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask taskInDTOToTaskMapper) {
        this.taskRepository = taskRepository;
        this.taskInDTOToTaskMapper = taskInDTOToTaskMapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = taskInDTOToTaskMapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }

}
