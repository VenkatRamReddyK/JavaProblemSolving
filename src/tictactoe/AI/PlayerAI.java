/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.AI;
/**
 *
 * @author venkatramreddykunta
 */
public class PlayerAI {

    TicTacToe.GameState currentAiTurn;
    TicTacToe.GameState[][] currentGameState;
    Score playerScore; 
    
    public PlayerAI() {
        playerScore=new Score();        
    }
    public void initGame(TicTacToe.GameState currentAiTurn,
            TicTacToe.GameState[][] currentGameState){
        this.currentAiTurn=currentAiTurn;
        this.currentGameState=currentGameState;
    }

    PlayerAI(Score _curScore) {
     playerScore=_curScore;
    }
    
    
    public void move(){
        System.out.println("Player is moving");
    }
    
}
