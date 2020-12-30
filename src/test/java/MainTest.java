import net.mike.notepad.entyties.Note;

public class MainTest {
    public static void main(String... args) {
        Note n = new Note(12, "first test tittle", "textarea of first note");
        System.out.println(n.getTextArea());
    }
}
