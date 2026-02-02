package org.example.task.model;

import java.util.ArrayList;
import java.util.List;

import org.example.task.TaskExceptions.TaskException;

public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    public void save(Task task) {
        if (task == null) {
            throw new TaskException("The value most be null");
        }
        this.tasks.add(task);
    }

    public Task findById(String id) {
        // return task.stream().filter(t ->
        // t.getId().equals(id)).findFirst().orElse(null);
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public void update(Task taskData) {
        if (taskData == null) {
            // System.out.println("This task does not exist");
            throw new TaskException("The task data cannot be null.");
        }
        int taskIndex = findIndexById(taskData.getId());
        if (taskIndex == -1) {
            throw new TaskException("The data for the ");
        }
        tasks.set(taskIndex, taskData);
    }

    // Delete one task
    public void remove(Task task) {
        // Task task = findById(id);
        if (task == null) {
            // System.out.println("This task does not exist");
            throw new TaskException("The task cannot be null.");
        }

        if (tasks.contains(task)) {
            // System.out.println("This task does not exist");
            throw new TaskException("This task does not exist in the list.");
        }

        this.tasks.remove(task);
        System.out.println("Task deleted successfully.");
    }

    public int findIndexById(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (this.tasks.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
