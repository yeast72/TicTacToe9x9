package control;

import java.util.Scanner;

import ui.TicTacToeUI;
import algorithm.Strategy;
import algorithm.StrategyA;
import Main.Game;

public class Console{
	private static Scanner scan = new Scanner(System.in);
	private int round;
	
	public int[] readInputRowColumn(Game game){
		int x = -1,y = -1;
		int output[] = new int [2];
		boolean in = false;
		do{
			in = false;
			try{
				System.out.print("Please select row: ");
				x = Integer.parseInt(scan.nextLine().trim());
				System.out.print("Please select column: ");				
				y = Integer.parseInt(scan.nextLine().trim());
			}catch(NumberFormatException e){
				System.out.println("Please input number!!!");
				in = true;
			}
			if(!game.getBoard().isEmpty(x, y) && !in){
				System.out.println("Try again this index not empty!!!");
			}
		}while (!game.getBoard().isEmpty(x, y));
		output[0] = x;
		output[1] = y;
		return output;
	}

	public void run(Game game) {
		this.round = 0;
		int input[] = new int[2];
		do{
			game.changeCurrentPlayer();
			System.out.println("Player " + game.getCurrentPlayer().getName() + " turn.");
			input = readInputRowColumn(game);
			game.getBoard().placeSymbol(game.getCurrentPlayer().getSymbol(), input[0],input[1]);
			game.getBoard().printBoard();
			if(game.isOver(game.getCurrentPlayer()))
				System.out.println(game.getCurrentPlayer().getName()+" wins in round "+this.round + "!!!!");
			else if(game.isFull()){
				System.out.println("Draw");
			}
			else{
				System.out.println("You placed " + game.getCurrentPlayer().getName() + " on (" + input[0] + "," + input[1] + ")");
			}
			round++;
				
		}while(!game.isOver(game.getCurrentPlayer()));		
	}
	
	public void insertDialogUI(Game game,int row,int column) {
		System.out.println(row);
		System.out.print("Please select column: ");
		System.out.println(column);
		game.getBoard().placeSymbol(game.getCurrentPlayer().getSymbol(), row, column);
		game.getBoard().printBoard();
		if(game.isOver(game.getCurrentPlayer()))
			System.out.println(game.getCurrentPlayer().getName()+" wins in round "+this.round + "!!!!");
		else if(game.isFull()){
			System.out.println("Draw");
		}
		else{
			System.out.println("You placed " + game.getCurrentPlayer().getName() + " on (" + row + "," + column + ")");
		}
		round++;
		if(!game.isOver(game.getCurrentPlayer())){
		game.changeCurrentPlayer();
		System.out.print("Please select row: ");
		}
	}
	
}