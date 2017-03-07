package control;

import ui.TicTacToeUI;
import algorithm.StrategyA;
import Main.Game;

public class Application {
	public static void main(String[] args){
		StrategyA strategy = new StrategyA();
		Game g = new Game(strategy);
		TicTacToeUI gui = new TicTacToeUI(g);
		Console console = new Console(g,gui);
	
		
		//run game on GUI
		gui.run();
		console.run();
		//run game on console
		//console.run();
	}

}