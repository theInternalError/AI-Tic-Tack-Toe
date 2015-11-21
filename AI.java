/* How to build an AI:
 *  1. Make a subclass of this AI class
 *  2. Within your constructor, give your AI a name.
 *  3. Implement move. You are given a copy of the board and are free to change it.
 *  	-Note : If you would like another copy the board so you can test moves, you can make a new copy by
 *  			using the getBoardCopy() method.
**/
import java.awt.Point;
public abstract class AI {
	protected char side;
	protected String name;
	
	char getSide(){
		return side;
	}
	void setSide(char s){
		side = s;
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	abstract Point move(TTTBoard b);
}