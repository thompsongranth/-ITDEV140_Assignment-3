/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thompson_ofakind;

import java.util.ArrayList;
/**
 *
 * @author Grant Thompson
 * ITDEV 140 THUR EVE
 * ASSIGNMENT 3
 */
public class Calc {
    
    private String[] winnersList;
    private int qtyOfWinners = 0;
    
    //properties setter getters
    public int getWinnersListSize(){
        
        return winnersList.length;
    }
    
    public String getMtachWinners(int arg1){
        return winnersList[arg1];
    }
    //end properties setter getters
    
    public int getQtyOfWinners() {
        return qtyOfWinners;
    }//end constructor
    
    
    
    
    
    
    public void doRoundWinner(int roundNumber, int numberOfPlayers, ArrayList<Player> player){
        
        int[][] sotedByDie = new int[numberOfPlayers][6];
        int[] playerHolder1= new int[numberOfPlayers];
        int[][] playerHolder0= new int[numberOfPlayers][6];
        ArrayList<Winner> roundWinner = new ArrayList();
        int highestQTY = 0;
        int dieFaceValue = 0;
        
         
        for (int i = 0; i < numberOfPlayers; i++) 
            System.arraycopy(player.get(i).getGameScore(roundNumber), 0, playerHolder0[i], 0, 5);
         
       
        
        for(int i =0; i<numberOfPlayers;i++){
            for (int j = 0; j < 5; j++) {
                
                switch(playerHolder0[i][j]){
                    case 1:
                      sotedByDie[i][0] =  sotedByDie[i][0]+1;
                      break;
                    case 2:
                      sotedByDie[i][1] =  sotedByDie[i][1]+1;
                      break;
                    case 3:
                      sotedByDie[i][2] =  sotedByDie[i][2]+1;
                      break;
                    case 4:
                      sotedByDie[i][3] =  sotedByDie[i][3]+1;
                      break;
                    case 5:
                      sotedByDie[i][4] =  sotedByDie[i][4]+1;
                      break;
                    case 6:
                      sotedByDie[i][5] =  sotedByDie[i][5]+1;
                      break;
                }
            }
        }
        
        
        for(int i=0; i<numberOfPlayers;i++){
            
            for (int j = 5; j >= 0; j--) {
                
                
                if(sotedByDie[i][j]>=highestQTY){// if arrays qty > highest qty it may enter
                
                    if(j<dieFaceValue && sotedByDie[i][j]==highestQTY){ //if loop position < highest face value and its qty = highest qty exit
                        continue;
                    }
                    
                switch(sotedByDie[i][j]){
                    
                    case 5:
                        
                        if(highestQTY < 5){//clear previous match winners if highest qty is less than new
                            roundWinner.clear();
                        }
                        if(dieFaceValue<j){//clear previous match winners if face value is less than new
                            roundWinner.clear();
                        }
                        roundWinner.add(new Winner(i));//add new to list
                        highestQTY=5;//set highest qty
                        dieFaceValue=(j);// set new high facevalue
                        break;
                    case 4:
                       
                        if(highestQTY < 4){
                            roundWinner.clear();
                        }
                        if(dieFaceValue<j){
                            roundWinner.clear();
                        }
                        roundWinner.add(new Winner(i));
                        highestQTY=4;
                        dieFaceValue=(j);
                        break;
                    case 3:
                        
                        if(highestQTY < 3){
                            roundWinner.clear();
                        }
                        if(dieFaceValue<j){
                            roundWinner.clear();
                        }
                        roundWinner.add(new Winner(i));
                        highestQTY=3;
                        dieFaceValue=(j);
                        break;
                    case 2:
                        if(highestQTY < 2){
                            roundWinner.clear();
                        }
                        if(dieFaceValue<j){
                            roundWinner.clear();
                        }
                        
                        roundWinner.add(new Winner(i));
                        highestQTY=2;
                        dieFaceValue=(j);
                        break;
                                       
                }//end switch
                }//end if
                }//end inner loop
            }//end outer loop

        
        
        
        
        
                //if(roundWinner.size()>0){
                    winnersList= new String[roundWinner.size()];//sets array size can probably remove if statement
                for (int k = 0; k < roundWinner.size(); k++) {
                    player.get(roundWinner.get(k).getRoundWinnerPlayer()).setGamesWon();
                    winnersList[k]= String.format("%nMatch #%d winner %s!", (roundNumber+1),player.get(roundWinner.get(k).getRoundWinnerPlayer()).getName());
                    //System.out.printf("%nround winner %s%n",player.get(roundWinner.get(k).getRoundWinnerPlayer()).getName());
                }//end loop
                //}//end if
        
        
        
        
                //console testing string
                /*for(int i =0; i<numberOfPlayers;i++){
                   System.out.printf("%d %d %d %d %d %d%n",sotedByDie[i][0],sotedByDie[i][1],sotedByDie[i][2],sotedByDie[i][3],sotedByDie[i][4],sotedByDie[i][5]);
                }*/
        
        
        
        
    }
    
    public int getGameWinner(ArrayList<Player> player){//sets the number of game winners for if more than one player specificly
        
        int highestAmountOfMatchWins = 0;
        
        for (int i = 0; i < player.size(); i++) {
            if(player.get(i).getGamesWon()>highestAmountOfMatchWins){
                highestAmountOfMatchWins=player.get(i).getGamesWon();
                qtyOfWinners=1;}
            else if(player.get(i).getGamesWon()==highestAmountOfMatchWins){
                qtyOfWinners++;
        }
        }
        
        return highestAmountOfMatchWins;
    }

    
    
}
