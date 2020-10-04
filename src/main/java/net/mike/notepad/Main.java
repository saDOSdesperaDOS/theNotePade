package net.mike.notepad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.mike.notepad.controller.services.NotesService;
import net.mike.notepad.model.etyties.Account;
import net.mike.notepad.model.etyties.Note;
import net.mike.notepad.model.etyties.UserProfile;

@Route
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class Main extends HorizontalLayout {

    public Main() {

        Button b = new Button("get grid notes");
        add(b);
        getElement().getStyle().set("position", "absolute");
        getElement().getStyle().set("margin-top", "1%");
        getElement().getStyle().set("margin-left", "84%");

        b.addClickListener( e-> {
            b.getUI().ifPresent(ui -> ui.navigate("grid"));
        });
    }
}
