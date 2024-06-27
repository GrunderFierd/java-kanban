import Data.Epic;
import Data.SubTask;
import Data.Task;
import Manager.Manager;
import Status.Status;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("***test system***");
        // Не присваивает id subtask к epic
        // Epic не меняет статус взависимости от subtask(если все подзадачи закрыты, epic все равно в статусе NEW) -
        // метод есть для проверки, думаю из-за того что нет id

        Epic epic1 = new Epic("Эпик 1", "Описание");
        manager.createNewEpic(epic1);
        System.out.println("Добавили эпик");
        System.out.println(epic1);

        System.out.println("Добавили два subtask");
        SubTask subtask1 = new SubTask("Subtask1 создания ",
                "Описание",1);
        SubTask subtask2 = new SubTask("Subtask2 создания ",
                "Описание ", 1);
        manager.createNewSubtask(subtask1);
        manager.createNewSubtask(subtask2);
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("Создаем задачу");
        Task task1 = new Task("Задача №1", "Нужно сделать",1, Status.NEW);
        manager.createNewTask(task1);
        System.out.println(task1);


        System.out.println("Создаем ид для subtask for epic");
        ArrayList<Integer> subtaskIdsForEpic1 = epic1.getSubtaskIds();
        subtaskIdsForEpic1.add(subtask1.getId());
        System.out.println(epic1);

        subtask1.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(subtask1);
        System.out.println("Поменяли статус первого subtask на В ПРОЦЕССЕ");
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("Проверяем статус epic после изменения статуса его subtask");
        System.out.println(epic1);

        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask2);
        System.out.println("Поменяли статус второго subtask на ВЫПОЛНЕН");
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("Проверяем статус epic после изменения статуса второго subtask");
        System.out.println(epic1);

        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);
        System.out.println("Выставили статус ВЫПОЛНЕН первому subtask" + subtask1.getStatus());
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("Проверяем статус первого epic после выполнения всех его subtask" + epic1.getStatus());
        System.out.println(epic1);

        System.out.println("Смотрим все задачи:");
        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());

        //Look by ID epic for subtask , выводит пустой массив
        System.out.println(manager.getListOfSubtasksByOneEpic(epic1.getId()));


        System.out.println("Look by ID");
        System.out.println(manager.getTaskById(task1.getId())); //Выводит null
        System.out.println(manager.getEpicById(epic1.getId()));
        System.out.println(manager.getSubtaskById(subtask1.getId())); // Выводит null

        System.out.println("Проверяем очистились ли subtask");
        System.out.println(manager.getSubtasks());

        //Удаляем все
        manager.removeAllTasks();
        manager.removeAllSubtasks();
        manager.removeAllEpics();
    }
}