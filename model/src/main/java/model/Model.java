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
	private String level;
	private int time;
	private int timeLeft;
	private Entity[][] map;
	private int point;
	private Character player;
	
	public Model(int levelID) {
		
	}
	public Observable getObservable() {
		
	}
	private void loadLevel(int levelID) {
		
	}
	private void buildmap() {
		
	}
	public int getTime () {
		
	}
	public void setTimeLeft(int Time) {
		
	}
	public int getTimeLeft(int Time) {
		
	}
	public int getDiamonds() {
	
	}
	public void setDiamondsLeft(int Diamonds) {
	
	}
	public int getDiamondsLeft() {
		
	}
	public int  getPoint() {
		
	}
	public void setPoint(int score) {
		
	}
	public Entity[][] getMap(){
		
	}
	public Character getPlayer() {
		
	}
	public void updateEntity(int posX,int posY) {
		
	}
	public void updateStats() {
		
	}
	public void updateEntitiesStats() {
		
	}
	public void updateSlidingBlocks() {
		
	}
	
	
}
