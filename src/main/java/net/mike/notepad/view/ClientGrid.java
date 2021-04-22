package net.mike.notepad.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.dbase.services.NotesService;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route("grid")
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class ClientGrid extends HorizontalLayout {

    private Logger log = LoggerFactory.getLogger(ClientGrid.class);

    public ClientGrid() {

        log.info("start constructor ClientGrid");

        VerticalLayout layoutVerticalLeft = new VerticalLayout();
        VerticalLayout layoutVerticalRight = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        NotesService service = new NotesService();
        TextArea  textArea = new TextArea();
        TextArea  textFieldTittle = new TextArea();
        NoteDataSet selectedNoteDataSet = new NoteDataSet();

        //наполняем grid
        Grid<NoteDataSet> grid = new Grid<>();
        grid.addColumn(NoteDataSet::getTittle);
        grid.addColumn(NoteDataSet::getDate);
        grid.setItems(service.getNotesList());

       /* grid.asSingleSelect().addValueChangeListener(event -> {
            String message = String.format("Selection changed from %s to %s",
                    event.getOldValue().getId(), event.getValue().getId());
            Notification.show(message);
        });*/

        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
            textFieldTittle.setValue(event.getItem().getTittle());
            selectedNoteDataSet.setId(event.getItem().getId());
        });

        Button greateNewNoteButton = new Button("Create a new note", event -> {
            textFieldTittle.setPlaceholder("titlle of new note");
            textArea.setPlaceholder("text of new note");
            textFieldTittle.setValue(textFieldTittle.getEmptyValue());
            textArea.setValue(textArea.getEmptyValue());
        });

        Button saveButton = new Button("Save", event -> {
            NoteDataSet noteDataSet = new NoteDataSet(textFieldTittle.getValue(), textArea.getValue());
            service.saveNote(noteDataSet);
            selectedNoteDataSet.setId(noteDataSet.getId());
            grid.setItems(service.getNotesList());
            }
        );

        Button updateButton = new Button("Update", event -> {
            service.updateNote(service.find(selectedNoteDataSet.getId()), textFieldTittle.getValue(), textArea.getValue());
            grid.setItems(service.getNotesList());
        });

        Button removeButton = new Button("Trash", event -> {
           service.removeNote(selectedNoteDataSet);
           grid.setItems(service.getNotesList());
        });

        //разметка страницы
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
        horizontalLayout.add(greateNewNoteButton, saveButton, updateButton, removeButton);
        layoutVerticalRight.add(horizontalLayout, textFieldTittle, textArea);
        layoutVerticalLeft.add(grid);

        setMinHeight("100%");
        setMaxHeight("100%");
        add(layoutVerticalLeft, layoutVerticalRight);
    }
}
