package Data;

import Status.Status;

import java.util.Objects;

public class Task {
    protected String name;
    protected String description;
    public int taskId;
    protected Status status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        status = status.NEW;
    }

    public Task(String name, String description, int taskId, Status status) {
        this.name = name;
        this.description = description;
        this.taskId = taskId;
        this.status = status;
    }

    public Task(String name, String description, int taskId, Status status, int epicId) {
        this.name = name;
        this.description = description;
        this.taskId = taskId;
        this.status = status;
    }

    public Task() {

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return taskId;
    }

    public String getTitle() {
        this.name = name;
        return name;
    }

    public void setId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task otherTask = (Task) obj;
        return Objects.equals(name, otherTask.name) &&
                Objects.equals(description, otherTask.description) &&
                (taskId == otherTask.taskId) &&
                Objects.equals(status, otherTask.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, taskId, status);
    }

    @Override
    public String toString() {
        return "Data.Task{" +
                "name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", taskId='" + taskId + '\'' +
                ", status='" + status + '\'' + '}';
    }
}
