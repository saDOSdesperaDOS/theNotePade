package net.mike.notepad.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.services.NotesService;
import net.mike.notepad.entyties.Note;

import java.util.ArrayList;
import java.util.List;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientGrid extends VerticalLayout {
    private TextField textArea;
    private Grid<Note> wrapper;
    private NotesService request;

    public ClientGrid() {
        Note n1 = new Note(111, "first tittle", "textarrea of first note");
        Note n2 = new Note(121, "second tittle", "textarrea of second note");
        Note n3 = new Note(113, "threetin tittle", "textarrea of threetin note");
        List<Note> noteList = new ArrayList<>();
        noteList.add(n1);
        noteList.add(n2);
        noteList.add(n3);
        //request = new NotesService(account);
        // wrapper = new Grid<>(Note.class);
       // textArea = new TextField();
       // textArea.setPlaceholder("Enter new note");
        //textArea.addValueChangeListener(this::onNameFilterTextChange);
        //wrapper.setItems(notesList);
       // textArea.setSizeFull();
       // add(textArea);
        Grid<Note> grid = new Grid<>();
        grid.setItems(noteList);
        grid.addColumn(Note::getTittle);
        grid.addColumn(Note::getDate);
        grid.setWidth("35%");
        add(grid);
    }

   /* private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<Note> dataProvider = (ListDataProvider<Note>) wrapper.getDataProvider();
        dataProvider.setFilter(Note :: getLeaderCode, s -> caseInsensitiveContains(s, event.getValue()));
    }

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }*/
}
