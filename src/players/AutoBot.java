/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;
import AI.AIEngine;
import AI.Score;
import game.*;
import game.Board.*;
/**
 *
 * @author venkatramreddykunta
 */
public class AutoBot extends Player{
    AIEngine aiEngine;
    
    public AutoBot() {                           
        aiEngine=new AIEngine();
    }
//    public void initGame(PLAYERTYPE currentAiTurn,
//            COINNAME[][] currentGameState){
//        this.currentAiTurn=currentAiTurn;
//        this.currentGameState=currentGameState;
//    }    
       
    public int move(COINNAME[][] currentGameState){
        
    //    System.out.println(currentPlayer+"'s move");        
        
        //aiEngine.initAIEngine();
        return aiEngine.move(currentGameState);
    }
    
}
