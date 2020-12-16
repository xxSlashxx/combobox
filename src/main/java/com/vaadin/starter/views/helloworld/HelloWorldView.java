package com.vaadin.starter.views.helloworld;

import com.vaadin.starter.data.entity.Address;
import com.vaadin.starter.data.service.AddressService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.starter.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.Component;

/**
 * A Designer generated component for the hello-world-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@JsModule("./src/views/helloworld/hello-world-view.js")
@Tag("hello-world-view")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends PolymerTemplate<TemplateModel> {

    @Id("streetAddress")
    private TextField street;
    @Id("postalCode")
    private TextField postalCode;
    @Id("city")
    private TextField city;
    @Id("state")
    private ComboBox<String> state;
    @Id("country")
    private ComboBox<String> country;
    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<Address> binder = new Binder<>(Address.class);

    public HelloWorldView(AddressService addressService) {
        country.setItems("Country 1", "Country 2", "Country 3");
        state.setItems("State A", "State B", "State C", "State D");

        binder.bindInstanceFields(this);

        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            addressService.update(binder.getBean());
            Notification.show("Address stored.");
            clearForm();
        });
    }

    private void clearForm() {
        this.binder.setBean(new Address());
    }

}
