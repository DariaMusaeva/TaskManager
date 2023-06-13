package ru.netology;

public class Epic extends Task {

    protected String[] subtasks = new String[0];

    public String[] getSubtasks() {
        return subtasks;
    }

    public Epic(int id, String subtasks) {
        super(id);
        this.subtasks = new String[]{subtasks};
    }

    @Override
    public boolean matches(String query) {
        String[] result = new String[0];
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks.contains(query)) {
                result = new String[];
            }
        }
        return true;
    }
}