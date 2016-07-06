
 // Done: comment this program
 
/*
 * File: CollectNewspaper.java
 * ----------------------------
 * Given Karel's world. 
 * Make Karel move to the newspaper, pick it up, return to the starting point and face east. 
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
	
	
	/*
	* Move Karel to the newspaper.
	* Pre: Karel is at its starting point, facing east.
	* Post: Karel is at the newspaper's position, facing east.
	*/	
	private void moveToPaper(){
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	
	/*
	* Move Karel back to its starting point.
	* Pre: Karel is at newspaper's position, facing east.
	* Post: Karel is at at its starting point, facing east.
	*/	
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
