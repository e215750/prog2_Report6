package jp.ac.uryukyu.ie.e215750;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
			game.numberGeneration();
        while(game.getIsNot_finish()){
            game.commandSelect("↑を割ることができる数字を選べ!");
            game.commandExecution();
        }
    }
}