package contract;

import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	int[] getPositionPlayer();
	
	void setMovePlayer(int x, int y);
	
	String[][] getMap();
	
	void loadHelloWorld(final String code);
	
	Observable getObservable();
}
