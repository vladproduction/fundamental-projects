package com.epam.rd.autotasks;

public class TaskCarousel {

    private final int capacity;
    private final Task[] tasks;
    private int currentIndex;
    private int taskCount;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new Task[capacity];
        this.currentIndex = 0;
        this.taskCount = 0;
    }

    public boolean addTask(Task task) {
        if (task == null || task.isFinished() || isFull()) {
            return false;
        }
        tasks[taskCount] = task;
        taskCount++;
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        Task currentTask = tasks[currentIndex];
        if (currentTask != null) {
            currentTask.execute();
            if (currentTask.isFinished()) {
                removeTask(currentIndex);
                return true;
            }
        }
        currentIndex = (currentIndex + 1) % taskCount;
        return true;
    }

    public boolean isFull() {
        return taskCount == capacity;
    }

    public boolean isEmpty() {
        return taskCount == 0;
    }

    private void removeTask(int index) {
        for (int i = index; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[taskCount - 1] = null;
        taskCount--;
        if (currentIndex >= taskCount && taskCount > 0) {
            currentIndex = 0;
        }
    }

}
