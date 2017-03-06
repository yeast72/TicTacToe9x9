package Main;


import javax.swing.JTable;

import algorithm.Strategy;
import control.Console;
import model.Board;
import model.Player;

public class Game {
	private Player[] players;
	private Board board;
	private Strategy strategy;
	private Player currentPlayer;

	public Game(Strategy strategy) {
		this.players = new Player[]{ new Player( "P1", "X" ), new Player( "P2", "O" ) };
		this.board = board.getInstance();
		this.strategy = strategy;
		currentPlayer = players[0];
	}
	
	public Player[] getPlayers() {
		return players;
	}


	public Board getBoard() {
		return board;
	}

	public boolean isOver(Player p){
		return strategy.isEnd(board, p);
	}
	
	public void changeCurrentPlayer() {
		if( currentPlayer.equals( players[0] ) ) {
			currentPlayer = players[1];
		}
		else {
			currentPlayer = players[0];
		}
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public boolean isFull(){
		return strategy.isFull(board);
	}
	
	public void reset() {
		board.clearMap();
		currentPlayer = players[0];
	}
}