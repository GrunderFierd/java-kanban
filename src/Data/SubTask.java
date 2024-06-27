package Data;

import Status.Status;

import java.util.Objects;

public class SubTask extends Task {

    private int epicId;

    public SubTask(String name, String description, int epicId) {
        super(name, description);
        this.epicId = epicId;
    }

    public SubTask(String name, String description, int id, Status status, int epicId) {
        super(name,description, id,status, epicId);
    }

    public SubTask() {
        super();
    }

    public int getEpicId() {
        return this.epicId;
    }

    @Override
        public boolean equals (Object obj){
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
        SubTask otherSubtask = (SubTask) obj;
            return Objects.equals(name, otherSubtask.name) &&
                    Objects.equals(description, otherSubtask.description) &&
                    (taskId == otherSubtask.taskId) &&
                    Objects.equals(status, otherSubtask.status) &&
                    (epicId == otherSubtask.epicId);
        }

        @Override
        public int hashCode () {
            return Objects.hash(name, description, taskId, status, epicId);
        }

        @Override
        public String toString () {
            return "Subtask{" +
                    "name='" + name + '\'' +
                    ", Description='" + description + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", status='" + status + '\'' +
                    ", epicId='" + epicId + '\'' + '}';
        }
}
