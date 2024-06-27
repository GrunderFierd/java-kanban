package Data;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private ArrayList<Integer> subtaskIds;

    public Epic(String name, String description) {
        super(name, description);
        subtaskIds = new ArrayList<>();
    }

    public Epic(String name, String description, int taskId, ArrayList<Integer> subtaskIds) {
        super(name, description);
    }

    public Epic() {
        super();
    }

    public ArrayList<Integer> getSubtaskIds() {
        return this.subtaskIds;
    }

    public void addSubtaskId(Integer id) {
        subtaskIds.add(id);
    }

    public void cleanSubtaskIds() {
        subtaskIds.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Epic otherEpic = (Epic) obj;
        return Objects.equals(name, otherEpic.name) &&
                Objects.equals(description, otherEpic.description) &&
                (taskId == otherEpic.taskId) &&
                Objects.equals(status, otherEpic.status) &&
                Objects.equals(subtaskIds, otherEpic.subtaskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, taskId, status, subtaskIds);
    }

    @Override
    public String toString() {
        return "Data.Epic{" +
                "name='" + name + '\'' +
        ", Description='" + description + '\'' +
                ", taskId='" + taskId + '\'' +
                ", status='" + status + '\'' +
                ", subtaskIds='" + subtaskIds + '\'' + '}';
    }
}
