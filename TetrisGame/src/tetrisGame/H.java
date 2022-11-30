package tetrisGame;

import java.awt.Color;
import java.awt.Point;

public class H extends Tetromino {
	H(int x, int y, Color color){
		super(x,y,color);
	}
	
	@Override
	public void initPoints() {
		this.points = new Point[] { new Point(-1, -1), new Point(-1, 0), new Point(-1,1), 
				new Point(1, -1), new Point(1, 0), new Point(1,1) };
	}
	
	@Override
	public boolean rotateSelf(Color[][] grid) {
		Point[] oldPoints = this.points.clone();
		if(oldPoints[1].getX() == (double) 0) {
			this.points = new Point[] {
					new Point(-1, -1), new Point(-1, 0), new Point(-1,1), 
					new Point(1, -1), new Point(1, 0), new Point(1,1) 
			};
		}else {
			this.points = new Point[] {
					new Point(-1,-1), new Point(0, -1), new Point(1,-1), 
					new Point(-1, 1), new Point(0, 1), new Point(1,1) 
			};
		}
		if(isValidPos(grid)) {
			return true;
		}else {
			this.points = oldPoints;
			return false;
		}
	}
}
