import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TasksTest {

    Meeting meeting1 = new Meeting(3, "Встретить маму", "Мама", "2.5.23" );
    Meeting meeting2 = new Meeting(4, "Накормить кота", "Кот","Сегодня");
    SimpleTask simple1 = new SimpleTask(5, "Сварить суп");
    SimpleTask simple2 = new SimpleTask(6, "Домашка");
    Epic epic1 = new Epic(7, new String[]{"Встретить маму", "Купить цветы", "Проверить время"});
    Epic epic2 = new Epic(8, new String[]{"Полить цветы", "Накормить кота"});



}
