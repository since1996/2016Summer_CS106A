/*
 * Done: comment this program
 */

import stanford.karel.*;

public class StoneMason extends SuperKarel {
	
	public void run() {
		// Done: write the code to implement this program
		sweepColumn();
		
		while (frontIsClear()){
			move4SweepColumn();
		}
	}
	
	
	/*
	 * Precondition: Karel is at the bottom of a column, facing East
	 * Postcondition: Karel is back at the original position, facing East, and all beepers are filled.
	 */	
	private void sweepColumn() {
		pickAllBeepers();
		returnToColumnBegin();
	}
	
	/*
	 * Precondition: Karel is at the bottom of column k, facing East
	 * Postcondition: Karel is at the bottom of column k+4, facing East, and all beepers on the k+4 column 
	 * are filled.
	 */	
	private void move4SweepColumn(){
		for (int i=0; i<4; i++){
			move();
		}
		sweepColumn();
	}
	
	
	
	/*
	 * Precondition: Karel is at the bottom of a column, facing East
	 * Postcondition: Karel is at the top of column, and all beepers are filled.
	 */
	private void pickAllBeepers() {
		turnLeft();
		if (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
	
	
	/*
	 * Precondition: Karel is at the top of a column, facing North
	 * Postcondition: Karel is at the bottom of a column,  facing East.
	 */
	private void returnToColumnBegin(){
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}

}
