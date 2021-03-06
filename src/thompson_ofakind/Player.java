/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompson_ofakind;

/**
 *
 * @author Grant Thompson
 * ITDEV 140 THUR EVE
 * ASSIGNMENT 3
 */
public class Player implements Comparable<Player>{
    
    private String name;
    private int gamesWon;
    private int[][] gameScores = new int[10][5];

      

    //Properies
    public String getName() {
        return name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon() {
        this.gamesWon = (this.gamesWon+1);
    }
    // end properties

    

    public Player(String name) {
        this.name = name;
    }//end constructor
    
    

    public int[] getGameScore(int gameNumber) {//gets game scaores for calc class
        int[] tempGameScore;
        tempGameScore = gameScores[gameNumber];
        
                return tempGameScore;
    }
    
    
    
    public void setScore(int gameNumber, int[] gamescore){//sets scores from calc class
        
        for (int i =0; i<gamescore.length;i++) {
            
            gameScores[gameNumber][i]=gamescore[i];
            
        }
        
    }

    @Override
	public int compareTo(Player player) {//sorts game winner by score in Player_UI
		double compareMatches = ((Player) player).getGamesWon();

		// ascending order
		// return (int) (this.gamesWon - compareMatches);

		// descending order
		return (int) (compareMatches - this.gamesWon);
	}
}
