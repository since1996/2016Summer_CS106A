/*
 * TODO: comment this program
 */

import stanford.karel.*;

public class CollectNewspaper extends SuperKarel {
	
	public void run() {
		// DONE: write the code to implement this program
		
		moveToPaper();
		
		if (beepersPresent()){
		pickBeeper();
		}
		
		returnToStart();
	}
	
	private void moveToPaper(){
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	private void returnToStart(){
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();		
	}
}
