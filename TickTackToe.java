/* How to run tests:
 * 1. Move your AI file(s) into this directory
 * 2. When prompted for the name of the AI, type in your file name without the .java part
 * 		- ex: For TestAI.java, type in "TestAI"
 * 3. Program should run automatically.
 */

import java.awt.Point;
import java.util.Scanner;

public class TickTackToe {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Name of AI 1: ");
		String nameOne = scan.nextLine();
		nameOne = nameOne.trim();
		AI one,two;
		try{
			one = (AI) (Class.forName(nameOne).newInstance());
		}
		catch(Exception e){
			System.out.println("Could not load AI one.");
			return;
		}
		one.setSide('x');
		System.out.println("Name of AI 2: ");
		String nameTwo = scan.nextLine();
		nameTwo = nameTwo.trim();
		try{
			two = (AI) (Class.forName(nameTwo).newInstance());
		}
		catch(Exception e){
			System.out.println("Could not load AI two.");
			return;
		}
		two.setSide('o');
		
		System.out.println("\nAI 1 \""+one.getName()+"\" is : "+one.getSide());
		System.out.println("AI 2 \""+two.getName()+"\" is : "+two.getSide()+"\n");
		
		TTTBoard board = new TTTBoard();
		
		boolean turn = true;
		
		//game cycle
		boolean won = false;
		while(!won){
			if(turn){
				System.out.println("AI 1's Turn...");
				Point move = one.move(board.getBoardCopy());
				board.place(one.getSide(),move);
				turn = !turn;
			}
			else{
				System.out.println("AI 2's Turn...");
				Point move = two.move(board.getBoardCopy());
				board.place(two.getSide(),move);
				turn = !turn;
			}
			board.printBoard();
			System.out.println();
			won = board.winCheck() != '-';
		}
		char winner = board.winCheck();
		if(one.getSide() == winner){
			System.out.println("AI 1 \""+one.getName()+"\" Wins!");
		}
		else if(two.getSide() == winner){
			System.out.println("AI 2 \""+two.getName()+"\" Wins!");
		}
		else{
			System.out.println("Huh, something went wrong....");
		}
	}
}
