package Manager;

import Data.Epic;
import Data.SubTask;
import Data.Task;
import Status.Status;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    private HashMap<Integer, Task> tasks = new HashMap<>();   //Создаем хеш мапы под задачи, эпики и субтаски
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private int id = 1;

    //Get and Set metod`s, remove , update + условия и проверка ,обновление статуса
    Task task = new Task();
    Epic epic = new Epic();
    SubTask subtask = new SubTask();

    private int generId() {
        return ++id;
    }

    public int createNewTask(Task newTask) {
        final int id = generId();
        task.setId(id);
        tasks.put(id, newTask);
        return newTask.getId();
    }

    public Integer createNewSubtask(SubTask newSubtask) {
        int newSubtaskId = generId();
        subtask.setId(newSubtaskId);
        Epic epic = epics.get(newSubtask.getEpicId());
        if (epic != null) {
            subtasks.put(newSubtaskId, newSubtask);
            epic.addSubtaskId(newSubtaskId);
            updateEpicStatus(epic);
        }
        return subtask.getId();
    }

    private void updateEpicStatus(Epic epic) {
        if (!epics.containsKey(epic.getId())) {
            return;
        }

        ArrayList<SubTask> epicSubTasks = new ArrayList<>();

        int countNew = 0;
        int countDone = 0;

        for (int i = 0; i < epic.getSubtaskIds().size(); i++) {
            epicSubTasks.add(subtasks.get(epic.getSubtaskIds().get(i)));
        }

        for (SubTask subtask : epicSubTasks) {
            if (subtask.getStatus().equals(Status.DONE)) {
                countDone++;
            } else if (subtask.getStatus().equals(Status.NEW)) {
                countNew++;
            } else {
                epic.setStatus(Status.IN_PROGRESS);
                return;
            }

            if (countNew == epicSubTasks.size()) {
                epic.setStatus(Status.NEW);
            } else if (countDone == epicSubTasks.size()) {
                epic.setStatus(Status.DONE);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }

    public int createNewEpic(Epic newEpic) {
        int newEpicId = generId();
        epic.setId(newEpicId);
        epics.put(newEpic.taskId, newEpic);
        return epic.getId();
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeAllSubtasks() {
        for (Epic epic : epics.values()) {
            epic.cleanSubtaskIds();
            updateEpicStatus(epic);
        }
        subtasks.clear();
    }

    public void removeAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<SubTask> getSubtasks() {
        ArrayList<SubTask> tasks = new ArrayList<>(subtasks.values());
        return tasks;
    }

    public ArrayList<Epic> getEpics() {
        ArrayList<Epic> tasks = new ArrayList<>(epics.values());
        return tasks;
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public SubTask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public ArrayList<SubTask> getListOfSubtasksByOneEpic(int id) {
        ArrayList<SubTask> subtasksNew = new ArrayList<>();
        Epic epic = epics.get(id);
        if (epic != null) {
            for (Integer subtaskId : epic.getSubtaskIds()) {
                subtasksNew.add(subtasks.get(subtaskId));
            }
        }
        return subtasksNew;
    }

    protected void removeTaskById(int taskId) {
        tasks.remove(taskId);
    }

    protected void removeEpicById(int id) {
        Epic epic = epics.get(id);
        if( epic != null) {
        for (Integer subtaskId : epic.getSubtaskIds()) {
            subtasks.remove(subtaskId);
        }
        epics.remove(id);
    }
        }

    protected void removeSubtaskById(Integer id) {
        SubTask subtask = subtasks.get(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            epic.getSubtaskIds().remove(id);
            updateEpicStatus(epic);
            subtasks.remove(id);
        }
    }

    protected void updateTheTask(Task updateTask, Integer idOfUpdateTask) {
        tasks.put(idOfUpdateTask, updateTask);
    }

    protected void updateTheEpic(Epic updateEpic, Integer idOfUpdateTEpic) {
        epics.put(idOfUpdateTEpic, updateEpic);
    }

    public void updateSubtask(SubTask newSubtask) {
        if ((newSubtask == null) || (!subtasks.containsKey(newSubtask.getId()))) {
            return;
        }
        Epic epic = epics.get(newSubtask.getEpicId());
        if (epic == null) {
            return;
        }
        subtasks.replace(newSubtask.getId(), newSubtask);
        updateEpicStatus(epic);
    }
}