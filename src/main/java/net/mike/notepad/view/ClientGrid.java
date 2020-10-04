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
import net.mike.notepad.model.etyties.Note;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientGrid extends VerticalLayout {
    private TextField textArea;
    private Grid<Note> wrapper;
    private NotesService request;


    public ClientGrid() {

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
