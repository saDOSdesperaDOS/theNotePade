import net.mike.notepad.utils.Mailer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class MainTest {
    public static void main(String... args) {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String ldtString = FOMATTER.format(localDateTime);

        System.out.println(LocalDateTime.parse(ldtString));      // 07/15/2018 at 02:49 PM
    }
}
