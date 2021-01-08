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
        Note n = new Note( 12,"first test tittle", "textarea of first note");
        Note n1 = new Note( 13,"first tittle", "textarrea of first note");
        Note n2 = new Note(14,"second tittle", "textarrea of second note");
        //Note n3 = new Note();
        NotesService service = new NotesService(account);
        Grid<Note> grid = new Grid<>();
        grid.setWidth("100%");
        //grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        service.saveNote(n);
        service.saveNote(n2);
        service.saveNote(n1);

        grid.setItems(service.getAccount().getNotesList());
        grid.addColumn(Note::getTittle);
        grid.addColumn(Note::getDate);

        TextArea  textArea = new TextArea();
        TextArea  textFieldTittle = new TextArea();

        textArea.setWidth("100%");
        textFieldTittle.setWidth("100%");
        textFieldTittle.setHeight("5%");
        textArea.setHeight("80%");

        layoutVerticalLeft.setWidth("60%");
        layoutVerticalLeft.setMinHeight("100%");
        layoutVerticalLeft.setMaxHeight("100%");
        layoutVerticalRight.setMinHeight("100%");
        layoutVerticalRight.setMaxHeight("100%");

        //ote noteOld = new Note();
        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
            textFieldTittle.setValue(event.getItem().getTittle());
            //Note noteOldF = service.find(event.getItem().getId());
        });

        Button button = new Button("Create a new Note", event -> {
            Note note = new Note(114);
            service.saveNote(note);
            grid.getDataProvider().refreshAll();
            textArea.setValue(note.getTextArea());
            textFieldTittle.setValue(note.getTittle());
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
        binder.forField(textArea)
                .bind(
                        Note::getTextArea,
                        Note::setTextArea);
        //binder.readBean(n);
        Button saveButton = new Button("Save",
                event -> {
                    try {
                        binder.writeBean(n);
                        binder.readBean(n);
                    } catch (ValidationException e) {
                        System.out.println(e.getBeanValidationErrors());;
                    }
                });



        layoutVerticalRight.add(saveButton,textFieldTittle, textArea);
        layoutVerticalLeft.add(grid, button);
        add(layoutVerticalLeft, layoutVerticalRight);
    }
}
