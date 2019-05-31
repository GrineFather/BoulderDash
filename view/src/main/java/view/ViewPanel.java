package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel{
	
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
	
	protected BufferedImage Breakable, Outline, Diamond, Player, Inline, Background, Gravity;
	private int nbcol = 30;
	private int nblig = 20;
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel() {
		try {
			this.Breakable = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Breakable\\B.png"));
			this.Background = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Background\\1.png"));
			this.Outline = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Outline\\O.png"));
			this.Inline = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Delemitation_Block_1\\I.png"));
			this.Diamond = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Diamond\\D.png"));
			this.Player = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Personnage\\Motionless\\P.png"));
			this.Gravity = ImageIO.read(new File("C:\\Users\\langl\\OneDrive\\Bureau\\projetjava\\Level_1\\Gravity\\G.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void UpdateMap(String[][] Map){
		this.Map = Map;
		this.repaint();
	}
	
	protected void paintComponent(Graphics Graphic) {

		for (int y = 0; y < 526; y += 16) {
			for (int x = 0; x < 526; x += 16) {
				Graphic.drawImage(this.Background, x, y, 16, 16, this);
			}
		}

		
		
		for (int i = 0; i < nblig; i++) { // lignes
			for (int j = 0; j < nbcol; j++) { // colonnes

				switch (this.Map[i][j]) {
				case "B":
					Graphic.drawImage(this.Breakable, j * 16, i * 16, 16, 16, this);
					break;

				case "O":
					Graphic.drawImage(this.Outline, j * 16, i * 16, 16, 16, this);
					break;

				case "I":
					Graphic.drawImage(this.Inline, j * 16, i * 16, 16, 16, this);
					break;

				case "D":
					Graphic.drawImage(this.Diamond, j * 16, i * 16, 16, 16, this);
					break;

				case "P":
					Graphic.drawImage(this.Player, j * 16, i * 16, 16, 16, this);
					break;

				case "G":
					Graphic.drawImage(this.Gravity, j * 16, i * 16, 16, 16, this);
					break;
				}

			}
		
		}
		}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	

}
