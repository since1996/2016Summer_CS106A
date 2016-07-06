/*
 * TODO: comment this program
 */

import stanford.karel.*;

public class Checkerboard extends SuperKarel {
	
	public void run() {
		// TODO: write the code to implement this program
		sweepOddRow();
		
		while (leftIsClear()) {
			moveToNext();
			sweepEvenRow();
			if (leftIsClear()){
				moveToNext();
				sweepOddRow();
			}
			
		}
	
	}
	
	
	private void moveToNext() {
		turnLeft();
		move();
		turnRight();
	}
	
	
	
	private void sweepOddRow(){
		putBeeper();
		if (frontIsClear()){
			move();
		}
		
		while (frontIsClear()){
			move();
			putBeeper();
			if (frontIsClear()){
				move();
			}
		}	
		returnToWall();
	}
	
	
	
	private void sweepEvenRow(){

		if (frontIsClear()){
			move();
			putBeeper();
		}
		
		while (frontIsClear()){
			move();
			if (frontIsClear()){
				move();
				putBeeper();
			}
		}
		
		returnToWall();
	}
	
	
	
	
	/*
	 * Precondition: Karel is at end of a row, facing East, and the beepers are cleared.
	 * Postcondition: Karel is at the beginning of a row, facing East.
	 */
	private void returnToWall() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	
}
