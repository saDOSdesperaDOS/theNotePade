package net.mike.notepad.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.entyties.Account;
import net.mike.notepad.entyties.UserProfile;
import net.mike.notepad.services.NotesService;
import net.mike.notepad.entyties.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientGrid extends HorizontalLayout {

    private TextArea textArea;

    public ClientGrid() {
        UserProfile userProfile = new UserProfile(123, "email", "password");
        Account account = new Account(123, userProfile);
        Note n = new Note( "first test tittle", "textarea of first note");
        Note n1 = new Note( "first tittle", "textarrea of first note");
        Note n2 = new Note("second tittle", "textarrea of second note");
        Note n3 = new Note();
        NotesService service = new NotesService(account);
        Grid<Note> grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        service.saveNote(n);
        service.saveNote(n2);
        service.saveNote(n3);

        grid.setItems(service.getAccount().getNotesList());
        grid.addColumn(Note::getTittle);
        grid.addColumn(Note::getDate);

        setMinHeight("100%");
        setMaxHeight("100%");
        grid.setWidth("100%");

        textArea = new TextArea();
        textArea.setWidth("100%");
        textArea.setMinHeight("100%");
        textArea.setMaxHeight("100%");
        /**изменение в textArea дедфют uddate в поле textArea заметки время созд которой ~ **/
        /*textArea.addInputListener(event -> {
            List<Note> noteList = service.getAccount().getNotesList();
            Stream.of(noteList).filter(textAreaNote ->
                    (noteList.iterator().next().getTextArea().equals(textAreaNote))).count();
        });*/
       /* Binder<Note> binder = new Binder<>();
        Button saveButton = new Button("Save", event -> {
                for (int i = 0; i < service.getAccount().getNotesList().size(); i++) {
                    if(service.getAccount().getNotesList().get(i).getTextArea().equals(this.textArea.getValue())) {
                        binder.setBean(service.getAccount().getNotesList().get(i));
                        if (binder.validate().isOk()) {
                            service.getAccount().getNotesList().get(i).setTextArea(this.textArea.getValue());
                            service.getAccount().getNotesList().get(i).setTittle(this.textArea.getValue().substring(0, 5));
                            service.updateNote(service.getAccount().getNotesList().get(i), service.getAccount().getNotesList().get(i).getTittle(), service.getAccount().getNotesList().get(i).getTextArea());
                    } else {
                            service.saveNote(service.getAccount().getNotesList().get(i));
                        }
                }
                grid.getDataProvider().refreshItem(service.getAccount().getNotesList().get(i));
            }
        });*/


        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
        });

        VerticalLayout layoutVerticalRight = new VerticalLayout();
        VerticalLayout layoutVerticalLeft = new VerticalLayout();
        layoutVerticalLeft.setWidth("60%");
        layoutVerticalRight.setMinHeight("100%");
        layoutVerticalRight.setMaxHeight("100%");
        layoutVerticalLeft.setMinHeight("100%");
        layoutVerticalLeft.setMaxHeight("100%");

        Button button = new Button("Create a new Note", event -> {
            Note note = new Note();
            service.saveNote(note);
            grid.getDataProvider().refreshAll();
        });


        Binder<Note> binder = new Binder<>();

// Field binding configuration omitted,
// it should be done here


                binder.setBean(n);

// Loads the values from the person instance
// Sets person to be updated when any bound field
// is updated


        Button saveButton = new Button("Save", event -> {
            if (binder.validate().isOk()) {
                // person is always up-to-date as long as
                // there are no validation errors

                service.updateNote(n, n.getTittle(), textArea.getValue());
                grid.getDataProvider().refreshAll();
            }
        });
        layoutVerticalRight.add(saveButton, textArea);
        layoutVerticalLeft.add(grid, button);
        add(layoutVerticalLeft, layoutVerticalRight);
    }
}
