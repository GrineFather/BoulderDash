package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	/** The helloWorld. */
	private Player player;
	
	String[][] Map = {
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "P", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "G", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "G", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "I", "I", "I", "I", "I", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "I", "I", "I", "I", "I", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "D", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B","B", "B", "B", "B", "B", "B", "B", "B", "B" },

	};

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.player = new Player(2, 2);
	}
	
	public void Run(){
		setChanged();
		notifyObservers();
	}

	public String[][] getMap(){
		return this.Map;
	}

	
	public int[] getPositionPlayer(){
		int[] PlayerPosition = {this.player.getx(), this.player.gety()};
		return PlayerPosition;
	}
	
	public void setMovePlayer(int x, int y){
		this.Map[this.player.gety()][this.player.getx()] = " ";
		this.player.setx(this.player.getx() + x);
		this.player.sety(this.player.gety() + y);
		this.Map[this.player.gety()][this.player.getx()] = "P";
		setChanged();
		notifyObservers();
	}

	

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadHelloWorld(final String code) {
		/*try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}*/
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}