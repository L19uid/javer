package org.delta;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.action.*;
import org.delta.menu.MenuChoices;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.JsonSerializationService;
import org.delta.storage.Storage;
import org.delta.storage.StringSerializationService;

public class BankInjector extends AbstractModule {

    private EventBus eventBus = new EventBus("Default event bus");

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

        this.bind(EventBus.class).toInstance(eventBus);

        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {
                    public void afterInjection(I i) {
                        eventBus.register(i);
                    }
                });
            }
        });
    }
}
