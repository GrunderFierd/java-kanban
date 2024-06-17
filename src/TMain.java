import java.util.ArrayList;

public class TMain {

    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("***test system***");
        //Create Task
        Task task1 = new Task("Заплатить за интернет.", "Не забыть заплатить за интернет.");
        Task task2 = new Task("Сходить в магазин.", "Ходить в магазин нужно каждый день.");
        manager.createNewTask(task1);
        manager.createNewTask(task2);

        //Create Epic
        Epic epic3 = new Epic("Переехать в другой город.", "Поискать место , куда переехать.");
        Epic epic4 = new Epic("Купить новую квартиру.", "Мало место, нужна квартира побольше.");
        manager.createNewEpic(epic3);
        manager.createNewEpic(epic4);

        //Create Subtask
        Subtask subtask5 = new Subtask("Зайти на сайты городов", "Поискать лучшее место", 3);
        Subtask subtask6 = new Subtask("Попросить знакомых", "Надо что бы помогли с переездом", 3);
        Subtask subtask7 = new Subtask("Взять ипотеку", "Рассчитать стоимость ипотеки для новой квартиры", 4);
        manager.createNewSubtask(subtask5);
        manager.createNewSubtask(subtask6);
        manager.createNewSubtask(subtask7);

        //Create id subtask for epic
        ArrayList<Integer> subtaskIdsForEpic3 = epic3.getSubtaskIds();
        subtaskIdsForEpic3.add(subtask5.getId());
        subtaskIdsForEpic3.add(subtask6.getId());
        ArrayList<Integer> subtaskIdsForEpic4 = epic4.getSubtaskIds();
        subtaskIdsForEpic4.add(subtask7.getId());

        //see Task,Subtask,epic
        manager.getListOfTasks();
        manager.getListOfEpics();
        manager.getListOfSubtasks();

        //Look by ID
        manager.getTaskById(task1.getId());
        manager.getEpicById(epic4.getId());
        manager.getSubtaskById(subtask7.getId());

        //Look by ID epic for subtask
        System.out.println(manager.getListOfSubtasksByOneEpic(epic3.getId()));

        //Update task name and status
        Task updateTask3 = new Task("Task", "432", task1.getId(), "IN_PROGRESS");
        manager.updateTheTask(updateTask3, task1.getId());

        //Update epic
        Epic updateEpic3 = new Epic("Epic", "12513", epic3.getId(), epic3.getStatus(), epic3.getSubtaskIds());
        manager.updateTheEpic(updateEpic3, epic3.getId());

        //Update subtask
        Subtask updateSubtask5 = new Subtask("Subtask",
                "1123523", subtask5.getId(),"IN_PROGRESS", 3);
        manager.updateTheSubtask(updateSubtask5, subtask5.getId());

        //Deleting by task ID, subtask, epic***");
        manager.removeTaskById(task1.getId());
        manager.removeEpicById(epic4.getId());
        manager.removeSubtaskById(subtask6.getId());

        //Deleting all
        manager.removeAllTasks();
        manager.removeAllSubtasks();
        manager.removeAllEpics();
    }
}