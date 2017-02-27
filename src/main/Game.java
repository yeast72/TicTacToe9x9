package main;

import java.util.Scanner;

import algorithm.Strategy;
import algorithm.StrategyA;
import model.Board;
import model.Player;

public class Game {
	private Player[] players;
	private Board board;
	Scanner scan;
	private boolean over;

	public Game() {
		this.players = new Player[2];
		this.board = board.getInstance();
		this.scan = new Scanner(System.in);
		this.over = false;

	}
	public Player createPlayer(String name,String symbol){
		return new Player(name,symbol);
	}
	
	public boolean isOver(){
		return over;
	}
	
	public int[] readInputRowColumn(){
		int x = -1,y = -1;
		int output[] = new int [2];
		do{
			try{
				System.out.print("Please select row: ");
				x = Integer.parseInt(scan.nextLine());
				System.out.print("Please select col: ");				
				y = Integer.parseInt(scan.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Please input number!!!");
			}
			if(!board.isEmpty(x, y))
				System.out.println("Try again this index not empty!!!");
		}while (!board.isEmpty(x, y));
		output[0] = x;
		output[1] = y;
		return output;
	}
	
	public void start(Strategy stategy) {
		String name,symbol;
		for(int i = 0 ; i < 2 ; i++){
			System.out.print("Input player "+ (i+1) + " name : ");
			name = scan.nextLine();
			do{
			System.out.print("Input player "+ (i+1) + " symbol : ");
			symbol = scan.nextLine();
			if(symbol.equals("_"))
				System.out.println("Please select another symbol");
			}while(symbol.equals("_"));
			players[i] = createPlayer(name,symbol);
		}
		
		int round = 0,turn;
		int input[] = new int[2];
		do{
			turn = round % 2 ;
			System.out.println("Player " + players[turn].getName() + " turn.");
			input = readInputRowColumn();
			board.placeSymbol(players[turn].getSymbol(), input[0],input[1]);
			board.printBoard();
			over = stategy.isEnd(board,players[turn]);
			if(isOver())
				System.out.println(players[turn].getName()+" win in round "+round + " !!!!");
			else if(stategy.isFull(board)){
				System.out.println("Draw");
				over = true;
			}
			else{
				System.out.println("You placed " + players[turn].getName() + " on (" + input[0] + "," + input[1] + ")");
			}
			round++;
				
		}while(!isOver());
	}

	public static void main(String[] args) {
		Game g = new Game();
		StrategyA strategy = new StrategyA();
		g.start(strategy);
	}
}
