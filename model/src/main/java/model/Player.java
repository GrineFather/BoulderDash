package model;


public class Player{
	private int x, y;

	Player(int x, int y) {
		this.setx(x);
		this.sety(y);
	}

	public int getx() {
		return this.x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public int gety() {
		return this.y;
	}

	public void sety(int y) {
		this.y = y;
	}

	public void move_LEFT() {
		this.x--;
	}

	public void moveRIGHT() {
		this.x++;
	}

	public void moveUP() {
		this.y--;
	}

	public void moveDOWN() {
		this.y++;
	}

}



