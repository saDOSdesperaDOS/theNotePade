package net.mike.notepad.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.dbase.entyties.NoteDataSet;
import net.mike.notepad.dbase.services.UserService;
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

        UserService service = new UserService();
        TextArea  textArea = new TextArea();
        TextArea  textFieldTittle = new TextArea();
        NoteDataSet selectedNoteDataSet = new NoteDataSet();
        //инициализируем grid
        Grid<NoteDataSet> grid = new Grid<>();
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
        setMinHeight("100%");
        setMaxHeight("100%");

        String email = VaadinServletRequest.getCurrent().getHttpServletRequest().getQueryString().split("=")[1];

        if (email.contains("ui")) {
            UI.getCurrent().getPage().reload();
            return;
        }
        long id = service.getUserId(email);
        //наполняем grid
        grid.addColumn(NoteDataSet::getTittle);
        grid.addColumn(NoteDataSet::getDate);
        grid.setItems(service.getNotesList(id));

        grid.addItemClickListener(event -> {
            textArea.setValue(event.getItem().getTextArea());
            textFieldTittle.setValue(event.getItem().getTittle());
           selectedNoteDataSet.setTittle(event.getItem().getTittle());
            selectedNoteDataSet.setTextArea(event.getItem().getTextArea());
        });

        Button greateNewNoteButton = new Button("Create a new note", event -> {
           textFieldTittle.setPlaceholder("titlle of new note");
            textArea.setPlaceholder("text of new note");
            textFieldTittle.setValue(textFieldTittle.getEmptyValue());
            textArea.setValue(textArea.getEmptyValue());
        });

        Button saveButton = new Button("Save", event -> {
           service.addNote(id, textFieldTittle.getValue(), textArea.getValue());
           grid.setItems(service.getNotesList(id));
            }
        );

        Button updateButton = new Button("Update", event -> {
          service.updateNote(id, selectedNoteDataSet, textFieldTittle.getValue(), textArea.getValue());
            grid.setItems(service.getNotesList(id));
        });

        Button removeButton = new Button("Trash", event -> {
           service.removeNote(id, selectedNoteDataSet);
           grid.setItems(service.getNotesList(id));
        });

        Button logOut = new Button("SignOut");
        logOut.addClickListener(event -> logOut.getUI().ifPresent(ui -> ui.navigate("/")));

        horizontalLayout.add(greateNewNoteButton, saveButton, updateButton, removeButton, logOut);
        layoutVerticalRight.add(horizontalLayout, textFieldTittle, textArea);
        layoutVerticalLeft.add(grid);
        add(layoutVerticalLeft, layoutVerticalRight);

    }
}
