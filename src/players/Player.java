/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;
import game.Board.*;
/**
 *
 * @author venkatramreddykunta
 */
public class Player {
    
 
    PLAYERTYPE currentPlayer;
    COINNAME currentCoin;
    public Player() {
        currentPlayer=PLAYERTYPE.NONE;
        currentCoin=COINNAME.N;
    }
    public PLAYERTYPE whichPlayer(){
        return this.currentPlayer;
    }
    public COINNAME whichCoin(){
        return this.currentCoin;
    }
    public int move(COINNAME[][] currentGameState){
        //System.out.println(currentPlayer+"'s move"); 
    return 1;
    }
}
