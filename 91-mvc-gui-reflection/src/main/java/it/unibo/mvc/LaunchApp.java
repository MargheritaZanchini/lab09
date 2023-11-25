package it.unibo.mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import it.unibo.mvc.view.DrawNumberViewOutput;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws SecurityException
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        final Class<?> class1 = Class.forName("it.unibo.mvc.view.DrawNumberSwingView");
        final Class<?> class2 = Class.forName("it.unibo.mvc.view.DrawNumberViewOutput");

        final Constructor<?> cons1= class1.getConstructor();
        final Constructor<?> cons2= class2.getConstructor();

        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);

        for(int i=0; i<3; i++){
            app.addView((DrawNumberView) cons1.newInstance());
            app.addView((DrawNumberView)cons2.newInstance());
        }
    }
}
