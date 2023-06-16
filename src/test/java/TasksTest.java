import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TasksTest {

    Meeting meeting1 = new Meeting(3, "Встретить маму", "Мама", "2.5.23");
    Meeting meeting2 = new Meeting(41, "Накормить кота", "Кот", "Сегодня");
    SimpleTask simple1 = new SimpleTask(56, "Сварить суп");
    SimpleTask simple2 = new SimpleTask(62, "Домашка");
    String[] subtasks1 = {"Встретить маму", "Купить цветы", "Проверить время"};
    Epic epic1 = new Epic(75, subtasks1);
    String[] subtasks2 = {"Полить цветы", "Накормить кота", "Позвонить"};
    Epic epic2 = new Epic(84, subtasks2);


    @Test
    public void shouldFindSimpleTask() {

        boolean expected = true;
        boolean actual = simple1.matches("Сварить суп");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSimpleTask() {

        boolean expected = false;
        boolean actual = simple2.matches("Зефир");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {

        boolean expected = true;
        boolean actual = meeting2.matches("Кот");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {

        boolean expected = false;
        boolean actual = meeting1.matches("Зефир");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTask() {

        boolean expected = true;
        boolean actual = epic1.matches("Встретить маму");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTask() {

        boolean expected = false;
        boolean actual = epic2.matches("Повесить полку");
        Assertions.assertEquals(expected, actual);
    }
}
