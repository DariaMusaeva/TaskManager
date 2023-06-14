import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    Meeting meeting1 = new Meeting(3, "Встретить маму", "Мама", "2.5.23");
    Meeting meeting2 = new Meeting(41, "Накормить кота", "Кот","Сегодня");
    SimpleTask simple1 = new SimpleTask(56, "Сварить суп");
    SimpleTask simple2 = new SimpleTask(62, "Домашка");
    Epic epic1 = new Epic(75, new String[]{"Встретить маму", "Купить цветы", "Проверить время"});
    Epic epic2 = new Epic(84, new String[]{"Полить цветы", "Накормить кота", "Позвонить"});

    @Test
    public void shouldFindHomeworkInSimpleTask() {
        Todos todos = new Todos();

        todos.add(simple1);
        todos.add(simple2);
        todos.search("Домашка");

        Assertions.assertArrayEquals(new SimpleTask[]{(simple2)}, todos.search("Домашка"));
    }

    @Test
    public void shouldNotFindSimpleTask(){
        Todos todos = new Todos();

        todos.add(simple1);
        todos.add(simple2);
        todos.search("Погладить кота");

        Assertions.assertArrayEquals(new SimpleTask[0], todos.search("Погладить кота"));
    }

    @Test
    public void shouldNotFindMeeting(){
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.search("Зефир");

        Assertions.assertArrayEquals(new Meeting[0], todos.search("Зефир"));
    }

    @Test
    public void shouldFindMeetingWithMom() {
        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.search("Мама");

        Assertions.assertArrayEquals(new Meeting[]{meeting1}, todos.search("Мама"));
    }

    @Test
    public void shouldFindFlowers() {
        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.search("Позвонить");

        Assertions.assertArrayEquals(new Epic[]{epic2}, todos.search("Позвонить"));
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
