public enum ChatCommand { //Для команд
    GETTING,  // Получение списка задач
    DELETING,  // удаление всех задач
    RECEIVING, // Получение задачи по айди
    CREATING, // Создание задачи, Сам объект должен передаваться в качестве параметра.
    UPDATING, // Обновление задачи,Новая версия объекта с верным идентификатором передаётся в виде параметра.
    DELETE; // Удаление задачи по айди

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
