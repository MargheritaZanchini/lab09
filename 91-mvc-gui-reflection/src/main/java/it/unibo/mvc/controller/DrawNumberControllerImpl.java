package it.unibo.mvc.controller;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements the game controller. It orchestrates the game, exposes methods to its observers
 * (the boundaries), and sends results to them.
 */
public final class DrawNumberControllerImpl implements DrawNumberController {

    private final DrawNumber model;
    private List<DrawNumberView> views = new ArrayList<>();
    //private DrawNumberView view;

    /**
     * Builds a new game controller provided a game model.
     *
     * @param model the implementation of the game model
     */
    public DrawNumberControllerImpl(final DrawNumber model) {
        this.model = model;
    }

    @Override
    public void addView(final DrawNumberView view) {
        Objects.requireNonNull(view, "Cannot set a null view");
        /*if (this.view != null) {
            throw new IllegalStateException("The view is already set! Multiple views are not supported");
        }*/
        view.setController(this);
        view.start();
        this.views.add(view);
        //this.view = view;
        
    }

    @Override
    public void newAttempt(final int n) {
        final DrawResult result = model.attempt(n);
        for(int i=0; i<views.size(); i++){
            Objects.requireNonNull(views.get(i), "There is no view attached!").result(result);
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        /*
         * A bit harsh. A good application should configure the graphics to exit by
         * natural termination when closing is hit. To do things more cleanly, attention
         * should be paid to alive threads, as the application would continue to persist
         * until the last thread terminates.
         */
        System.exit(0);
    }

}
