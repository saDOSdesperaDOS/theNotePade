package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.NotesService;
import net.mike.notepad.entyties.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientGrid extends HorizontalLayout {

    private Logger log = LoggerFactory.getLogger(ClientGrid.class);

    /*private Note n = new Note( 12,"first test tittle", "textarea of first note");
    private Note n1 = new Note( 13,"first tittle", "textarrea of first note");
    private Note n2 = new Note(14,"second tittle", "textarrea of second note");*/

    public ClientGrid() {

        log.info("start constructor ClientGrid");
        setMinHeight("100%");
        setMaxHeight("100%");

        VerticalLayout layoutVerticalRight = new VerticalLayout();
        VerticalLayout layoutVerticalLeft = new VerticalLayout();

        UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        NotesService service = new NotesService(account);
        Grid<Note> grid = new Grid<>();
        Grid.Column<Note> tittleColumn = grid.addColumn(Note::getTittle);
        Grid.Column<Note> dateColumn = grid.addColumn(Note::getDate);
        TextArea  textArea = new TextArea();
        TextArea  textFieldTittle = new TextArea();
        Note selectedNote = new Note();
        /*service.saveNote(n);
        service.saveNote(n1);
        service.saveNote(n2);*/

        grid.setItems(service.getNotesList());

        grid.asSingleSelect().addValueChangeListener(event -> {
            String message = String.format("Selection changed from %s to %s",
                    event.getOldValue().getId(), event.getValue().getId());
            Notification.show(message);
        });

        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
            textFieldTittle.setValue(event.getItem().getTittle());
            //selectedNote = event.getItem();
        });

        Button saveButton = new Button("Save", event -> {
                    service.updateNote(service.find(selectedNote.getId()), textFieldTittle.getValue(), textArea.getValue());
                    grid.getDataProvider().refreshAll();
                }
        );

        Button button = new Button("Create a new Note", event -> {
            Note note = new Note(114);
            service.saveNote(note);
            textArea.setValue(note.getTextArea());
            textFieldTittle.setValue(note.getTittle());
            grid.getDataProvider().refreshAll();
        });

        grid.setWidth("100%");
        textArea.setWidth("100%");
        textFieldTittle.setWidth("100%");
        textFieldTittle.setHeight("5%");
        textArea.setHeight("80%");

        layoutVerticalLeft.setWidth("60%");
        layoutVerticalLeft.setMinHeight("100%");
        layoutVerticalLeft.setMaxHeight("100%");
        layoutVerticalRight.setMinHeight("100%");
        layoutVerticalRight.setMaxHeight("100%");
        layoutVerticalRight.add(saveButton,textFieldTittle, textArea);
        layoutVerticalLeft.add(grid, button);
        add(layoutVerticalLeft, layoutVerticalRight);
    }
}
