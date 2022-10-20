package org.delta;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import org.delta.action.*;
import org.delta.menu.MenuChoices;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.JsonSerializationService;
import org.delta.storage.Storage;
import org.delta.storage.StringSerializationService;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Storage.class).to(FileSystemStorage.class);
        this.bind(StringSerializationService.class).to(JsonSerializationService.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);

        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.CREATE_PERSON).to(CreatePersonAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
        uriBinder.addBinding(MenuChoices.LOAD).to(LoadBankAction.class);
        uriBinder.addBinding(MenuChoices.SAVE).to(SaveBankAction.class);
    }
}
