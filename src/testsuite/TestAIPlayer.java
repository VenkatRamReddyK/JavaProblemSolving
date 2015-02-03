/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsuite;

import tictactoe.AI.*;

/**
 *
 * @author venkatramreddykunta
 */
public class TestAIPlayer {
      PlayerAI[] _allPlayers;
      public int decideMove(){
        //maxScoreIndex
        int[] winner=new int[_allPlayers.length];
        int index=0,minScore=Integer.MAX_VALUE,winIndex=0,curScore;
        Score currentScore;
       
        for(PlayerAI currentPlayer:_allPlayers){
            
            currentScore=currentPlayer.playerScore;
            
            for(int i=0;i<9;i++){                                
                    if(currentScore.score[i][0]>=1){
                        System.out.println("Win status ["+10*(i+1)+"] "+(index+1)); 
                        winner[index]=-10*(i+1);break;
                    }else if(currentScore.score[i][1]>=1){
                        System.out.println("Draw status ["+(i+1)+"] "+(index+1)); 
                        winner[index]=i+1;break;
                    }
                    else if(currentScore.score[i][2]>=1){
                        System.out.println("Loose status ["+(-10)*(i+1)+"] "+(index+1)); 
                        winner[index]=10*(i+1);break;
                    }
            }
            index++;
        }
        
        for(int i=0;i<_allPlayers.length;i++)
        {
            System.out.println("Current score of [ "+i+" ] is : "+winner[i]+", MAX SCORE:"+minScore);
            if(minScore>winner[i]){
                minScore=winner[i];
                winIndex=i;
            }
        }
        return winIndex;
    }
      
      public static void main(String[] args) {
        TestAIPlayer testPlayer=new TestAIPlayer();
        testPlayer.moveAI();        
    }

    public void moveAI() {
        int N=3;
        _allPlayers=new PlayerAI[N];
        PlayerAI _currentPlayer;
        Score _curScore;
        
        for(int i=0;i<_allPlayers.length;i++){
            _curScore=new Score();
            _currentPlayer=new PlayerAI(_curScore);
            _allPlayers[i]=_currentPlayer;
        }
        
        // processing the scores 
        
        _allPlayers[0].playerScore.addWins(2);
        _allPlayers[0].playerScore.addDraws(1);
        _allPlayers[0].playerScore.addLooses(3);
        
        _allPlayers[1].playerScore.addWins(3);
        _allPlayers[1].playerScore.addDraws(4);
        _allPlayers[1].playerScore.addLooses(2);
        
        _allPlayers[2].playerScore.addWins(1);
        _allPlayers[2].playerScore.addDraws(1);
        _allPlayers[2].playerScore.addLooses(1);
        
        
        _allPlayers[0].playerScore.display();
        _allPlayers[1].playerScore.display();
        _allPlayers[2].playerScore.display();
        
        System.out.println("Choice: "+decideMove());
        
        // initialising the scores
        /*
        Score[] allScores=new Score[3];
        
        Score score0=new Score();
        Score score1=new Score();
        Score score2=new Score();
      
        allScores[0]=score0;allScores[1]=score1;allScores[2]=score2;
        
        // processing the scores 
        
        allScores[0].addWins(2);allScores[0].addWins(3);
        allScores[0].addDraws(1);allScores[0].addDraws(3);
        allScores[0].addLooses(2);
        
        allScores[1].addWins(3);allScores[1].addWins(5);
        allScores[1].addDraws(1);allScores[1].addDraws(3);
        allScores[1].addLooses(2);
                
        allScores[2].addWins(8);allScores[2].addWins(5);
        allScores[2].addDraws(1);allScores[2].addDraws(2);
        allScores[2].addLooses(1);
        
        allScores[0].display();
        allScores[1].display();
        allScores[2].display();
        
        System.out.println("Choice: "+decideWin(allScores));
        */
    }
}
