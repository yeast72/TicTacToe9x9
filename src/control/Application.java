package control;

import ui.TicTacToeUI;
import algorithm.StrategyA;
import Main.Game;

public class Application {
	public static void main(String[] args){
		StrategyA strategy = new StrategyA();
		Game g = new Game(strategy);
		Console console = new Console();
		TicTacToeUI gui = new TicTacToeUI(g);
		
		//run game on GUI
		gui.run();
		console.run(g);
		//run game on console
		//console.run();
	}

}