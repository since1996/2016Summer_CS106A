/*
 * Done: comment this program
 */


/*
 * File: MidpointFinder.java
 * ----------------------------
 * 
 * Given a world of m rows and n columns. Place a beeper in the midpoint of the first row.
 * Assumption: n>=m
 *
 * Solution:
 * Case 1: When n=1, place beeper on (1,1).
 * Case 2: When n=2, place beeper on (1,2).
 * Case 3: When n>3:
 * 	   Idea : The intersection of the diagonal line and the off-diagonal line gives the target column.	 
 *     Step 1: Place beepers along diagonal line (i,j)= (i, i) for i>=2
 *     Step 2: Place beepers along the lower-diagonal line (i,j) = (i,i-1) for i>=2 		
 * 	   Step 3: Karel moves along the off-diagonal line (i,j) = (i, n+1-i) for i=1,2,3...
 * 	           When Karel meets a beeper, i.e., when the diagonal lines and the off-diagonal line intersect, the target column is found.
 * 	   Step 4: Place beeper on the target place.
 * 	   Step 5: Clear beepers on the two diagonal line.
 *     Step 6: Karel moves to the final position.	
 * 		   		
 * 
 */

import stanford.karel.*;

public class MidpointFinder extends SuperKarel {
	
	public void run() {
		// Done: write the code to implement this program
		
		// Case 1: There is only one column
		if (frontIsBlocked()){
			putBeeper();
		} else{
			move();
			// Case 2: There're only two columns.
			if (frontIsBlocked()){
				putBeeper();
			} else{
				// General Case: Three or more columns.
				returnToStart();
				
				//Step 1: Sweep the diagonal
				sweepDiagonal();
				returnToStart();
				
				//Step 2: Sweep the lower-diagonal
				sweepLowDiagonal();
				returnToStart();
				
				//Step 3+4: Track the off-diagonal, place peeper on the target 
				traceOffDiagonal();
				returnToStart();
				
				//Step 5: Clear the two diagonals
				clearDiagonal();
				returnToStart();
				
				clearLowDiagonal();
				returnToStart();
				
				//Step 6: Final position
				goToFinalPosition();	
				
			}
		
	
		}
	}
	
	
	private void sweepDiagonal(){
		while (frontIsClear()){
			move();
			turnLeft();
			move();
			putBeeper();
			turnRight();
		}
	}
	
	private void sweepLowDiagonal(){
		if (frontIsClear()){
			move();
			sweepDiagonal();
		}
	}
	
	private void traceOffDiagonal(){
		toWall();
		turnAround();
		while (noBeepersPresent()){
			move();
			turnRight();
			move();
			turnLeft();
		}
		turnLeft();
		toWall();
		putBeeper();
	}
	
	private void clearDiagonal(){
		while (frontIsClear()){
			move();
			turnLeft();
			move();
			pickBeeper();
			turnRight();
		}
	}
	
	private void clearLowDiagonal(){
		if (frontIsClear()){
			move();
			clearDiagonal();
		}
	}
	
	private void toWall(){
		while (frontIsClear()){
			move();
		}
	}
	
	private void downToRowOne(){
		while (notFacingSouth()){
			turnLeft();
		}
		toWall();
	}
	

	
	private void leftToColumnOne(){
		while (notFacingWest()){
			turnLeft();
		}
		toWall();
	}
	
	
	private void returnToStart(){
		downToRowOne();
		turnRight();
		leftToColumnOne();
		while (notFacingEast()){
			turnLeft();
		}	
	}
	
	private void goToFinalPosition(){
		while (noBeepersPresent()){
			move();
		}	
	}

}
