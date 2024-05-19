package singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ToDoManager {
    private static ToDoManager instance;
    private List<String> tasks;

    private ToDoManager() {
        tasks = new ArrayList<String>();
    }

    public static ToDoManager getInstance() {
        if(instance == null){
            instance = new ToDoManager();
        }
        return instance;
    }

    public void addTask(String task){
        tasks.add(task);
        System.out.println("'" + task + "'" + " added to list");
    }

    public void removeTask(String task) {
        if (tasks.remove(task)) {
            System.out.println("'" + task + "' removed from list");
        } else {
            System.out.println("'" + task + "' not found in the list");
        }
    }

    public void showTasks(){
        System.out.println("Remain tasks:\n");
        for(String task : tasks){
            System.out.println("- "+task);
        }
    }
}
class Client {
    void performAction() {
        ToDoManager toDoManager = ToDoManager.getInstance();
        toDoManager.addTask("Buy groceries");
        toDoManager.addTask("Clean the house");
        toDoManager.addTask("Pay bills");
        toDoManager.showTasks();
        toDoManager.removeTask("Clean the house");
        toDoManager.showTasks();
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.performAction();
    }
}