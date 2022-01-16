package jp.ac.uryukyu.ie.e215750;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/** 
 * 素因数分解ゲーム
 * ランダムに生成された数を2、3、5、7、11の5つの数字で割っていき、
 * 1になるまで割ることができるとクリアとなる。
*/
public class Game {
    int problem;
    int choise;
    int point = 0;
    int[] numbers = {2,3,5,7,11};
    boolean isNot_finish = true;
    Scanner scanner;
    
/**
 * 2、3、5、7、11で割り切れるランダムな数字を生成する。
 */
    public void numberGeneration(){
        problem = 1;
        Random r = new Random();
        isNot_finish = true;   
        for(int i=0; i<5; i++){
            for(int j=0; j<r.nextInt(5); j++){
                problem *= numbers[i];
            }
        }
    }

/**
 * いくつかの選択肢を表示し、ユーザーが選択したコマンドを保存する。
 * 入力された情報が適切でない場合、エラーを示す。
 */
    public void commandSelect(){
        scanner = new Scanner(System.in);
        int sequence = 1;
        System.out.println("--------------");
        System.out.println(problem);
        System.out.println("↑を割ることができる数字を選べ!");
        for(int number : numbers){
            System.out.println(sequence + ":" + number + "で割る");
            sequence += 1;
        }
        try{
            choise = scanner.nextInt();        
            if((choise < 1) || (5 < choise)){
                throw new Exception();
            }
        }catch(InputMismatchException e){
            System.out.println("数字を入力してください");
            System.exit(0);
        }catch(Exception e){
            System.out.println("1~5の数字を入力してください");
            System.exit(0);
        }
    }

    /**
     * 選択された数字で問題の数を割り切れるかを判定し、
     * 割り切れるなら割った後にゲームクリアになるかを判定する。
     */
    public void commandExecution(){
        int check_number = problem % numbers[choise - 1];
        if(check_number == 0){
            problem /= numbers[choise - 1];
            System.out.println(problem);
            if(problem == 1){
                System.out.println("クリア!");
                point += 1;
                isNot_finish = false;
            }
        }else{
            System.out.println(numbers[choise - 1] + "では割ることが出来なかった!");
            System.out.println("クリア失敗");
            isNot_finish = false;
        }
    }
/**
 * 何回ゲームをクリアすることが出来たかを表示する。
 */
    public void resultDisplay(){
        System.out.print("あなたの得点は" + point + "です。");
    }
}