package ru.netology;

public class Epic extends Task {

    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] result = new String[subtasks.length + 1];
        for (int i = 0; i < subtasks.length; i++) {
            result[i] = subtasks[i];
            if (subtasks[subtasks.length].contains(query)) {
                return  true;
            }
        }
        return false;
    }
}