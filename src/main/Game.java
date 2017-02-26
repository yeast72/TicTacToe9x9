package main;

import java.security.GeneralSecurityException;
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
	
	public void start(Strategy stategy) {
		for(int i = 0 ; i < 2 ; i++){
			System.out.print("Input player "+ (i+1) + " name : ");
			String name = scan.nextLine();
			System.out.print("Input player "+ (i+1) + " symbol : ");
			String symbol = scan.nextLine();
			players[i] = createPlayer(name,symbol);
		}
		int round = 0,turn,x=-1,y=-1;
		do{
			turn = round % 2 ;
			System.out.println("Player " + players[turn].getName() + " turn.");
			do{
				System.out.print("Please select row: ");
				x = Integer.parseInt(scan.nextLine());
				System.out.print("Please select col: ");
				y = Integer.parseInt(scan.nextLine());
			}while (!board.isEmpty(x, y));
				board.placeSymbol(players[turn].getSymbol(), x, y);
				board.printBoard();
				over = stategy.isEnd(board,players[turn]);
				if(isOver())
					System.out.println(players[turn].getName()+" win in round "+round + " !!!!");
				else if(stategy.isFull(board)){
					System.out.println("Draw");
					over = true;
				}
				else{
					System.out.println("You placed " + players[turn].getName() + " on (" + x + "," + y + ")");
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
