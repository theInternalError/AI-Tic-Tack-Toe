import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;

public class TestAI extends AI {

	//No parameter constructor, initialize name
	public TestAI(){
		this.name = "TestAI";
	}
	@Override
	Point move(TTTBoard b) {
		ArrayList<Point> ar = new ArrayList<Point>();
		Random r = new Random();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				Point p = new Point(i,j);
				if(b.checkSpace(p) == ' '){
					ar.add(p);
				}
			}
		}
		return ar.get(r.nextInt(ar.size()));
	}

}