package seminars.sem6.notes.presentation.queries.controllers;

import seminars.sem6.notes.presentation.queries.views.Presenter;

public abstract class Controller {

    public <T extends Presenter> void view(T presenter) {

    }

}
