/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import players.*;
/**
 *
 * @author venkatramreddykunta
 */
public class Board {
public enum PLAYERTYPE {NONE,HUMAN,AI};
public enum COINNAME {N,H,A};
 
    public COINNAME[][] currentGameState={
                            {COINNAME.H,COINNAME.A,COINNAME.N},
                            {COINNAME.A,COINNAME.N,COINNAME.N},
                            {COINNAME.H,COINNAME.N,COINNAME.N}
                          };        
    PLAYERTYPE currentTurn;
    Player currentPlayer;
    public Board(int size) {
        //currentGameState=new COINNAME[size][size];
        
        currentPlayer=new Human();
        currentTurn=PLAYERTYPE.HUMAN;
    }
    public void alterOver(){
        if(currentTurn.equals(PLAYERTYPE.AI))
            currentTurn=PLAYERTYPE.HUMAN;
        else
            currentTurn=PLAYERTYPE.AI;
        System.out.println("Current turn: "+currentTurn);
    }
     public static void display(COINNAME[][] _currentGameState){
        System.out.println("\n Game State");
        System.out.println("  -   -   - ");
        for(int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
                if(_currentGameState[i][j]==COINNAME.N){
                System.out.print("|   ");//.ordinal());
                }else{
                    System.out.print("| "+_currentGameState[i][j]+" ");//.ordinal());
                }
                
             }System.out.println("|");
            //System.out.println();
            System.out.println("  -   -   - ");
        }        
    }  
    public void startGame() {        
        int currentIndex=-1,count=4;
         Board.display(currentGameState);            
        do{
           
            if(currentTurn==PLAYERTYPE.HUMAN){
              currentPlayer= new Human();
                currentIndex=currentPlayer.move(currentGameState);
              currentGameState[currentIndex/3][currentIndex%3]=COINNAME.H;
            } 
            else{//currentTurn==GameState.AutoBot
                currentPlayer= new AutoBot();
                currentIndex=currentPlayer.move(currentGameState);
                System.out.println("Auto Bot Moved to : "+currentIndex);
                currentGameState[currentIndex/3][currentIndex%3]=COINNAME.A;
            }                      
            Board.display(currentGameState);            
            alterOver();
            count++;
            System.out.println("Count: "+count);
            if(count==9){
                System.out.println("stalemate");
            }
            
        }while(!(GameSpecs.isGameOver(currentGameState,COINNAME.A) || GameSpecs.isGameOver(currentGameState,COINNAME.H) || GameSpecs.isStalemate(currentGameState)));     
//  || isGameOver(GameState.EMPTY)
        if(GameSpecs.isStalemate(currentGameState))
            System.out.println("Stalemate");
        
        
        System.out.println(GameSpecs.whoWon(currentGameState)+" Won the Game");
        
    }
     
    
    
    
    
}

