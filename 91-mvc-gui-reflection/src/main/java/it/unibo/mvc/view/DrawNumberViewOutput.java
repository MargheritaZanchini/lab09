package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberViewOutput implements DrawNumberView{

    DrawNumberController controller;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        System.out.println("called method start");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println("Result: "+res);
    }
    
}
