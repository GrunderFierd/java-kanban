import java.util.Objects;

public class Task {
    protected String name;
    protected String Description;
    protected int id;
    protected static int lastId = 0;
    protected String status = "NEW";

    public Task(String name, String Description) {
        this.name = name;
        this.Description = Description;
        this.id = ++lastId;
    }

    public Task(String name, String Description, String status) {
        this.name = name;
        this.Description = Description;
        this.status = status;
    }

    public Task(String name, String Description, int id, String status) {
        this.name = name;
        this.Description = Description;
        this.id = id;
        this.status = status;
    }

    public String getSpecification() {
        return Description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task otherTask = (Task) obj;
        return Objects.equals(name, otherTask.name) &&
                Objects.equals(Description, otherTask.Description) &&
                (id == otherTask.id) &&
                Objects.equals(status, otherTask.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Description, id, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' + '}';
    }

    public String getTitle() {
        this.name = name;
        return name;
    }
}
