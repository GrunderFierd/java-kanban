import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private ArrayList<Integer> subtaskIds = new ArrayList<>();

    public Epic(String name, String Description) {
        super(name, Description);
    }

    public Epic(String name, String Description, String status) {
        super(name, Description, status);
    }

    public Epic(String name, String Description, int id, String status, ArrayList<Integer> subtaskIds) {
        super(name, Description, id, status);
        this.subtaskIds = subtaskIds;
    }

    public ArrayList<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Epic otherEpic = (Epic) obj;
        return Objects.equals(name, otherEpic.name) &&
                Objects.equals(Description, otherEpic.Description) &&
                (id == otherEpic.id) &&
                Objects.equals(status, otherEpic.status) &&
                Objects.equals(subtaskIds, otherEpic.subtaskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Description, id, status, subtaskIds);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", subtaskIds='" + subtaskIds + '\'' + '}';
    }
}
