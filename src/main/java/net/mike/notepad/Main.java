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
        Button b1 = new Button("Sign in");
        Button b2 = new Button("Sign up");
        add(b1, b2);

        b1.addClickListener( e-> {
            b1.getUI().ifPresent(ui -> ui.navigate("login"));
        });
        b2.addClickListener( e-> {
            b2.getUI().ifPresent(ui -> ui.navigate("signup"));
        });

        getElement().getStyle().set("position", "absolute");
        getElement().getStyle().set("margin-top", "1%");
        getElement().getStyle().set("margin-left", "84%");
    }
}
