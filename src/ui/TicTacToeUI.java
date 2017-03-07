package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Console;
import Main.Game;

public class TicTacToeUI extends JFrame implements Runnable{
	private JPanel gamePanel = new JPanel();
	private XOButton buttons[][] = new XOButton[9][9];
	private Game game;
	private Console console;
	private JLabel topic;
	private boolean checkEnd;
	private JButton resetButton;
	private JButton exitButton;
	private JPanel layoutXOButtons;
	private JPanel panelButton;
	
	public TicTacToeUI(Game g){
		super("TicTacToe");
		this.game = g;
		this.console = new Console(game,this);
		setSize(450,450);
		checkEnd = false;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents();
		
	}
	private void initComponents() {
		gamePanel.setLayout(new FlowLayout());
		
		panelButton = new JPanel(new GridLayout(1,2));
		resetButton = new JButton( "Reset" );
		resetButton.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				game.reset();
				resetTable();
				checkEnd = false;
				topic.setText( "GAME START!!!" );
			}
			
		});
		exitButton = new JButton( "Exit" );
		exitButton.addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				exit();
			}
			
		});
		panelButton.add(resetButton);
		panelButton.add(exitButton);
		
		topic = new JLabel( "GAME START!!!" );
		topic.setSize( 40, 400 );

		layoutXOButtons = new JPanel(new GridLayout(9, 9));
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++){
				buttons[i][j] = new XOButton(console,game,i,j);
				layoutXOButtons.add(buttons[i][j]);
			}
		}
		gamePanel.add(topic);
		gamePanel.add(layoutXOButtons);
		gamePanel.add(panelButton);
		add(gamePanel);
	}
	
	public void resetTable(){
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++){
				buttons[i][j].setText("_ ");
			}
		}
	}
	
	public void exit(){
		this.dispose();
	}
	@Override
	public void run() {
		setVisible(true);
	}
	
	public void showText(int row ,int col,String val){
		buttons[row][col].setText(val);
	}

}