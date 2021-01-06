package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
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

    public ClientGrid() {

        setMinHeight("100%");
        setMaxHeight("100%");

        VerticalLayout layoutVerticalRight = new VerticalLayout();
        VerticalLayout layoutVerticalLeft = new VerticalLayout();

        UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        Note n = new Note( "first test tittle", "textarea of first note");
        Note n1 = new Note( "first tittle", "textarrea of first note");
        Note n2 = new Note("second tittle", "textarrea of second note");
        Note n3 = new Note();
        NotesService service = new NotesService(account);
        Grid<Note> grid = new Grid<>();
        grid.setWidth("100%");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        service.saveNote(n);
        service.saveNote(n2);
        service.saveNote(n3);

        grid.setItems(service.getAccount().getNotesList());
        grid.addColumn(Note::getTittle);
        grid.addColumn(Note::getDate);

        TextArea  textArea = new TextArea();

        textArea.setWidth("100%");
        textArea.setMinHeight("100%");
        textArea.setMaxHeight("100%");

        layoutVerticalLeft.setWidth("60%");
        layoutVerticalLeft.setMinHeight("100%");
        layoutVerticalLeft.setMaxHeight("100%");
        layoutVerticalRight.setMinHeight("100%");
        layoutVerticalRight.setMaxHeight("100%");

        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
        });

        Button button = new Button("Create a new Note", event -> {
            Note note = new Note();
            service.saveNote(note);
            grid.getDataProvider().refreshAll();
        });

        /*Binder<Note> binder = new Binder<>();
        binder.setBean(service.getAccount().getNotesList().get(0));

        Button saveButton = new Button("Save", event -> {
            if (binder.validate().isOk()) {
                log.info("Начали обновление первой заметки в списке");
                service.updateNote(service.getAccount().getNotesList().get(0), textArea.getValue());
                log.info("обновили первую заметку в списке");
                grid.getDataProvider().refreshItem(service.getAccount().getNotesList().get(0));
                grid.getDataProvider().refreshAll();
                log.info("обновили всю сетку");

            }
        });*/
        Binder<Note> binder = new Binder<>(Note.class);
        TextField titleField = new TextField();
// Start by defining the Field instance to use
        binder.forField(titleField)
                // Finalize by doing the actual binding
                // to the Person class
                .bind(
                        // Callback that loads the title
                        // from a person instance
                        Note::getTittle,
                        // Callback that saves the title
                        // in a person instance
                        Note::setTittle);
        TextField textAreaField = new TextField();
// Shorthand for cases without extra configuration
        binder.bind(textAreaField, Note::getTextArea,
                Note::setTextArea);


// Updates the value in each bound field component
        binder.readBean(n);
        Button saveButton = new Button("Save",
                event -> {
                    try {
                        binder.writeBean(n);
                        // A real application would also save
                        // the updated person
                        // using the application's backend
                        grid.getDataProvider().refreshAll();
                    } catch (ValidationException e) {
                        System.out.println(e.getBeanValidationErrors());;
                    }
                });
// Updates the fields again with the
// previously saved values
        Button resetButton = new Button("Reset",
                event -> binder.readBean(n));

        layoutVerticalRight.add(saveButton, resetButton, titleField, textAreaField);
        layoutVerticalLeft.add(grid, button);
        add(layoutVerticalLeft, layoutVerticalRight);
    }
}
