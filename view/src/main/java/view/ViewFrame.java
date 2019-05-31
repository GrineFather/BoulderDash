package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
public class ViewFrame extends JFrame implements IView, KeyListener, Observer{

	private ViewPanel panneau;
	//public Player p1;
	
	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model){
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	public ViewFrame(IModel model) {
		this.panneau = new ViewPanel();
		this.setModel(model);
		this.model.getObservable().addObserver(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(panneau);
		this.setSize(485, 350);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Boulder dash");
		try {
			this.setIconImage(ImageIO.read(new File("image\\P.png")));
		} catch (IOException e) {

		}
		this.setContentPane(this.panneau);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
	}
	

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public ControllerOrder KeyCode(int keycode){
        switch(keycode){
            case KeyEvent.VK_LEFT:
                return ControllerOrder.LEFT;
            case KeyEvent.VK_RIGHT:
                return ControllerOrder.RIGHT;
            case KeyEvent.VK_UP:
                return ControllerOrder.UP;
            case KeyEvent.VK_DOWN:
                return ControllerOrder.DOWN;
            default:
                return ControllerOrder.STAND_BY;
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.getController().orderPerform(this.KeyCode(e.getKeyCode()));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
		int[] Player;
		Player = this.model.getPositionPlayer();
		this.panneau.UpdateMap(this.model.getMap());
		
	}


}
