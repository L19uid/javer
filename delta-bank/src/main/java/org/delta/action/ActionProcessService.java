package org.delta.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.menu.MenuChoices;

import java.util.Map;
@Singleton
public class ActionProcessService {

    @Inject
    private Map<MenuChoices,Action> registerActions;

    public void processAction(MenuChoices key) {
        Action action = this.registerActions.get(key);

        if(action != null)
        {
            action.processAction();
        }
    }
}
