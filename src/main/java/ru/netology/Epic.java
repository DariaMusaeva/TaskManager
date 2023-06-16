package ru.netology;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] tmp = new String[subtasks.length];
        for (int i = 0; i < subtasks.length; i++) {
            tmp[i] = subtasks[i];
            if (tmp[i].contains(query)) {
                return true;
            }
        }
        return false;
    }
}