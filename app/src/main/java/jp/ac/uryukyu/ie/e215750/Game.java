package jp.ac.uryukyu.ie.e215750;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/** 
 * 素因数分解ゲーム
 * 
*/
public class Game {
    private static int problem;
    private static int choise;
    private int[] numbers = {2,3,5,7,11};
    private boolean isNot_finish = true;
    private Scanner scanner;

/**
 * getterメソッド
 * @return 
 */
    public boolean getIsNot_finish(){
        return isNot_finish;
    }
    
/**
 * 
 */
    public void numberGeneration(){
        int number;
        problem = 1;
        Random r = new Random();
        
        for(int i = 0 ; i < 5 ; i++){
            number = numbers[i] * r.nextInt(5);
            if(number != 0){
            problem *= number;
            }
        }
        System.out.println(problem);
    }

/**
 * 
 * @param question
 */
    public void commandSelect(String question){
        scanner = new Scanner(System.in);
        int sequence = 1;
        System.out.println(question);
        for(int number : numbers){
            System.out.println(sequence + ":" + number + "で割る");
            sequence += 1;
        }
        try{
            choise = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("数字を入力してください");
        }
    }

    public void commandExecution(){
        int check_number = problem % numbers[choise - 1];
        if(check_number == 0){
            problem /= numbers[choise - 1];
            System.out.println("--------------");
            System.out.println(problem);
            if(problem == 1){
                System.out.println("ゲームクリア!");
                isNot_finish = false;
            }
        }else{
            System.out.println(numbers[choise - 1] + "では割ることが出来なかった!");
            System.out.println("クリア失敗");
            isNot_finish = false;
        }
    }
}