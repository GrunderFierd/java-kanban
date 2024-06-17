import java.util.Objects;

public class Subtask extends Task {
    private int epicId;

    public Subtask(String name, String Description, int epicId) {
        super(name, Description);
        this.epicId = epicId;
    }

    public Subtask(String name, String Description, String status, int epicId) {
        super(name, Description, status);
        this.epicId = epicId;
    }

    public Subtask(String name, String Description, int id, String status, int epicId) {
        super(name, Description, id, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Subtask otherSubtask = (Subtask) obj;
        return Objects.equals(name, otherSubtask.name) &&
                Objects.equals(Description, otherSubtask.Description) &&
                (id == otherSubtask.id) &&
                Objects.equals(status, otherSubtask.status) &&
                (epicId == otherSubtask.epicId);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, Description, id, status, epicId);
    }

    @Override
    public String toString () {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", epicId='" + epicId + '\'' + '}';
    }
}
