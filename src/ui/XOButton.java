package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Main.Game;
import control.Console;

public class XOButton extends JButton implements ActionListener{
	private final int row;
	private final int column;
	private Console console;
	private Game game;
	public XOButton(Console console,Game g,int row,int column){
		super();
		setText("_ ");
	//	this.setSize(arg0, arg1);
		this.game = g;
		this.row = row;
		this.column = column;
		this.console = console;
		this.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(getText().equals("_ ") && !game.isOver(game.getCurrentPlayer())){
			if(game.getCurrentPlayer().getSymbol().getValue().equals("X")){
				setText("X");
			}
			else 
				setText("O");
			console.insertDialogUI(game, row+1,column +1);
		}
		
	}
	
}
