package exercises.ella;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import jdk.internal.jline.console.completer.FileNameCompleter;

public class Game implements MouseListener, ActionListener {

	Timer timer = new Timer(1000, this);
	int time = 0;
	JFrame frame = new JFrame();
	PicturePanel panel = new PicturePanel();
	SideBar bar = new SideBar();
	JPanel mainPanel = new JPanel();
	Emojis emoji = new Emojis();
	int gameNumber = 0;
	boolean checkMe = false;
	boolean checkMe2 = false;
	boolean checkMe3 = false;
	boolean checkMe4 = false;
	boolean checkMe5 = false;
	boolean checkMe6 = false;
	boolean checkMe7 = false;
	boolean checkMeL2 = false;
	boolean checkMeL22 = false;
	boolean checkMeL23 = false;
	boolean checkMeL24 = false;
	boolean checkMeL25 = false;
	boolean checkMeL26 = false;
	boolean checkMeL27 = false;
	JButton balloonButton;
	JButton sparklesButton;
	JButton backpackButton;
	JButton diamondButton;
	JButton pawprintsButton;
	JButton snakeButton;
	JButton ringButton;
	JButton appleButton;
	JButton bowButton;
	JButton keyButton;
	JButton cloudButton;
	JButton chickenButton;
	JButton roseButton;
	JButton earthButton;
	JButton cactusButton;

	public static void main(String[] args) {

		Game ellasGame = new Game();
	}

	Game() {
		setup();
		timer.start();
	}

	void setup() {
		frame.setSize(1800, 1000);
		frame.setLayout(new BorderLayout());
		mainPanel.add(panel, BorderLayout.WEST);
		mainPanel.add(bar, BorderLayout.EAST);
		frame.add(mainPanel);
		panel.setPreferredSize(new Dimension(1500, 1000));
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLevelOneButtons();
	}

	void createLevelOneButtons() {
		balloonButton = addButton("balloon.png", 698, 336);
		diamondButton = addButton("diamond.png", 315, 900);
		pawprintsButton = addButton("pawprints.png", 1079, 782);
		ringButton = addButton("WeddingRing.png", 1460, 500);
		snakeButton = addButton("snake.png", 1100, 420);
		backpackButton = addButton("backpack.png", 840, 770);
		sparklesButton = addButton("sparkles.png", 680, 756);
	}

	private JButton addButton(String fileName, int xPosition, int yPosition) {
		JButton button = new JButton();
		try {
			Image image = ImageIO.read(getClass().getResource(fileName));
			button.setIcon(new ImageIcon(image));
			panel.setLayout(null);
			panel.add(button);
			button.addMouseListener(this);
			button.setBorder(null);
			button.setBounds(xPosition, yPosition, 30, 30);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return button;

	}

	void createLevelTwoButtons() {
		appleButton = addButton("apple.png", 503, 931);
		bowButton = addButton("bow.png", 953, 903);
		cloudButton = addButton("cloud.png", 460, 529);
		roseButton = addButton("rose.png", 719, 664);
		chickenButton = addButton("chicken.png", 351, 575);
		keyButton = addButton("key.png", 953, 903);
		earthButton = addButton("earth.png", 1224, 879);
		cactusButton = addButton("cactus.png", 578, 588);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getSource() == (balloonButton)) {
			balloonButton.setVisible(false);
			bar.foundBalloon();
			checkMe = true;
		}
		if (e.getSource() == (pawprintsButton)) {
			pawprintsButton.setVisible(false);
			bar.foundPawprint();
			checkMe2 = true;
		}
		if (e.getSource() == (ringButton)) {
			ringButton.setVisible(false);
			bar.foundRing();
			checkMe3 = true;
		}
		if (e.getSource() == (snakeButton)) {
			snakeButton.setVisible(false);
			bar.foundSnake();
			checkMe4 = true;
		}
		if (e.getSource() == (backpackButton)) {
			backpackButton.setVisible(false);
			bar.foundBackpack();
			checkMe5 = true;
		}
		if (e.getSource() == (sparklesButton)) {
			sparklesButton.setVisible(false);
			bar.foundSparkles();
			checkMe6 = true;
		}
		if (e.getSource() == (diamondButton)) {
			diamondButton.setVisible(false);
			bar.foundDiamond();
			checkMe7 = true;
		}

		if (checkFoundAll()) {
			timer.stop();
			JOptionPane.showMessageDialog(null,
					"Congratulations! You found all the pictures! \n You finished the puzzle in: " + time
							+ " seconds. \n Ready for level 2?");
			panel.nextLevelPicture();
			bar.nextLevelBar();
			gameNumber += 1;
			checkMe = false;
			checkMe2 = false;
			checkMe3 = false;
			checkMe4 = false;
			checkMe5 = false;
			checkMe6 = false;
			checkMe7 = false;
			createLevelTwoButtons();
			time = 0;
			timer.restart();

		}

		if (e.getSource() == (appleButton)) {
			appleButton.setVisible(false);
			bar.foundApple();
			checkMeL2 = true;
		}
		if (e.getSource() == (bowButton)) {
			bowButton.setVisible(false);
			bar.foundBow();
			checkMeL22 = true;
		}
		if (e.getSource() == (roseButton)) {
			roseButton.setVisible(false);
			bar.foundRose();
			checkMeL23 = true;
		}
		if (e.getSource() == (cloudButton)) {
			cloudButton.setVisible(false);
			bar.foundCloud();
			checkMeL24 = true;
		}
		if (e.getSource() == (chickenButton)) {
			chickenButton.setVisible(false);
			bar.foundChicken();
			checkMeL25 = true;
		}
		if (e.getSource() == (earthButton)) {
			earthButton.setVisible(false);
			bar.foundEarth();
			checkMeL26 = true;
		}
		if (e.getSource() == (cactusButton)) {
			cactusButton.setVisible(false);
			bar.foundCactus();
			checkMeL27 = true;
		}

		if (checkFoundAllLevelTwo()) {
			timer.stop();
			JOptionPane.showMessageDialog(null,
					"Congratulations! You found all the pictures! \n You finished the puzzle in: " + time
							+ " seconds.");
			System.exit(0);
		}
	}

	private boolean checkFoundAllLevelTwo() {
		return checkMeL2 == true && checkMeL22 == true && checkMeL23 == true && checkMeL24 == true && checkMeL25 == true
				&& checkMeL26 == true && checkMeL27 == true;
	}

	private boolean checkFoundAll() {
		return checkMe == true && checkMe2 == true && checkMe3 == true && checkMe4 == true && checkMe5 == true
				&& checkMe6 == true && checkMe7 == true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time += 1;
		bar.showTime(time);
	}

}