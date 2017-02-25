package algorithm;

import softpec_ticTest.Board;
import softpec_ticTest.Player;

public interface Strategy {
	public boolean isEnd(Board board,Player p);
	public boolean isFull(Board board);
	boolean isCompleteHorizontal(Board board,Player p);
	boolean isCompleteVertical(Board board,Player p);
	boolean isCompleteDiagonal(Board board,Player p);
	boolean isCompleteAntiDiagonal(Board board,Player p);
	
}
