package jp.ac.uryukyu.ie.e215750;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        for(int i=0; i<3; i++){
            game.numberGeneration();
            while(game.isNot_finish){
                game.commandSelect();
                game.commandExecution();
            }
        }
        game.resultDisplay();
    }
}