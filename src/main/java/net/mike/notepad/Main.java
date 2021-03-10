package net.mike.notepad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route
@Theme(variant = Lumo.DARK, value = Lumo.class )
public class Main extends HorizontalLayout {

    public Main() {

        Button b = new Button("get notes list");
        add(b);
        getElement().getStyle().set("position", "absolute");
        getElement().getStyle().set("margin-top", "1%");
        getElement().getStyle().set("margin-left", "84%");

        b.addClickListener( e-> {
            b.getUI().ifPresent(ui -> ui.navigate("grid"));
        });
    }
}
