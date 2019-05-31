/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.ViewFrame;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        Model model = new Model();
        ViewFrame view = new ViewFrame(model);
        model.Run();
        Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
    }
}
