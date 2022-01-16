package jp.ac.uryukyu.ie.e215750;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        game.levelSelect();
        long start = System.currentTimeMillis();
        for(int i=0; i<3; i++){
            game.numberGeneration();
            while(game.isNot_finish){
                game.commandSelect();
                game.commandExecution();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("タイム : " + (int)(end - start)/1000 + "秒");
        game.resultDisplay();
    }
}