package UI;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algorithm.Strategy;
import algorithm.StrategyA;
import control.Main;
import main.Game;

public class GUI extends JFrame{
	private JPanel gamePanel = new JPanel();
	private XOButton buttons[][] = new XOButton[9][9];
	private Game game;
	private Main m;
	
	public GUI(Game g){
		super("TicTacToe");
		this.game = g;
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		
	}
	private void initComponents() {
		gamePanel.setLayout(new GridLayout(9, 9));
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++){
				buttons[i][j] = new XOButton();
				gamePanel.add(buttons[i][j]);
			}
		}
		add(gamePanel);
		m.readInputRowColumn(game);
	}
	
	
	public static void main(String[] args){
		StrategyA strategy = new StrategyA();
		Game game = new Game(strategy);
		GUI gui = new GUI(game);
		gui.setVisible(true);
	}

}
