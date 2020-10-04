package net.mike.notepad.view;

import java.util.List;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.controller.services.NotesService;
import net.mike.notepad.model.etyties.Account;
import net.mike.notepad.model.etyties.Note;
import net.mike.notepad.model.etyties.UserProfile;
import org.apache.openjpa.lib.util.Services;
import java.util.List;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientNotes extends VerticalLayout {
    private TextField textArea;
    private Grid<Note> wrapper;
    private NotesService request;
    private List<Note> notesList;
    private Account account;

    public ClientNotes() {
        UserProfile userProfile = new UserProfile(1, "aaa", "bbb");
        Account account = new Account(userProfile.getId(), userProfile);
        Note note = new Note(1,"first note", "this is textarea first note");
        Note note1 = new Note(2,"first note", "this is textarea first note");
        Note note2 = new Note(3,"first note", "this is textarea first note");
        Note note3 = new Note(4,"first note", "this is textarea first note");
        NotesService notesService = new NotesService(account);
        notesService.saveNote(note);
        notesService.saveNote(note1);
        notesService.saveNote(note2);
        notesService.saveNote(note3);
        //request = new NotesService(account);
       // wrapper = new Grid<>(Note.class);
        textArea = new TextField();
        textArea.setPlaceholder("Enter new note");
        //textArea.addValueChangeListener(this::onNameFilterTextChange);
        //wrapper.setItems(notesList);
        textArea.setSizeFull();
        add(textArea);
    }

   /* private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<Note> dataProvider = (ListDataProvider<Note>) wrapper.getDataProvider();
        dataProvider.setFilter(Note :: getLeaderCode, s -> caseInsensitiveContains(s, event.getValue()));
    }

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }*/
}
