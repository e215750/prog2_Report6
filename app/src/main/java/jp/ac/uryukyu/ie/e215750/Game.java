package jp.ac.uryukyu.ie.e215750;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/** 
 * 素因数分解ゲーム
 * ランダムに生成された数を簡単モードなら{2、3、5、7、11}、難しいモードなら{2、3、5、7、11、13、17}
 * のどれかを選んで割っていき、最終的に1になるまで割ることができるとクリアとなる。
*/
public class Game {
    int problem;//問題の数字
    int point;//正解数
    int choice;//ユーザーが選択した数字
    int level;//ユーザーが選択したレベル
    int[] easy_numbers = {2,3,5,7,11};//簡単モードで問題で使用する素数
    int[] hard_numbers = {2,3,5,7,11,13,17}; //難しいモードでしようする素数
    boolean isNot_finish = true;//ゲームが終了するかどうかの判定
    Scanner scanner;//Scannerクラスを使用する際に必要

/**
 * 簡単モードか難しいモードを選択する。
 */
    public void levelSelect(){
        scanner = new Scanner(System.in);
        System.out.println("素因数分解ゲーム!!");
        System.out.println();
        System.out.println("難易度を選択してください");
        System.out.println("1:簡単   2:難しい");
        level = scanner.nextInt();
        if((level < 1)||(2 < level)){
            System.out.println("1または2を選択してください");
            System.exit(0);
        }
    }
    
/**
 * 簡単モード：2、3、5、7、11で割り切れるランダムな数字を生成する。
 * 難しいモード：2、3、5、7、11、13、17で割り切れるランダムな数字を生成する。
 */
    public void numberGeneration(){
        int number;
        problem = 1;
        Random r = new Random();
        isNot_finish = true;   
        if(level == 1){
            for(int i=0; i<5; i++){
                number = (int)Math.pow(easy_numbers[i], r.nextInt(4));
                if(number != 0){
                    problem *= number;
                }
            }
        }else{
            for(int i=0; i<7; i++){
                number = (int)Math.pow(hard_numbers[i], r.nextInt(3));
                if(number != 0){
                    problem *= number;
                }
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
        if(level == 1){
            for(int number : easy_numbers){
                System.out.println(sequence + ":" + number + "で割る");
                sequence += 1;
            }
            try{
                choice = scanner.nextInt();       
                if((choice < 1) || (5 < choice)){
                    throw new Exception();
                }
            }catch(InputMismatchException e){
                System.out.println("数字を入力してください");
                System.exit(0);
            }catch(Exception e){
                System.out.println("1~5の数字を入力してください");
                System.exit(0);
            }
        }else{
            for(int number : hard_numbers){
                System.out.println(sequence + ":" + number + "で割る");
                sequence += 1;
            }
            try{
                choice = scanner.nextInt();       
                if((choice < 1) || (7 < choice)){
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
    }

    /**
     * 選択された数字で問題の数を割り切れるかを判定し、
     * 割り切れるなら割った後にゲームクリアになるかを判定する。
     */
    public void commandExecution(){
        if(level == 1){
            int check_number = problem % easy_numbers[choice - 1];
            if(check_number == 0){
                problem /= easy_numbers[choice - 1];
                System.out.println(problem);
                if(problem == 1){
                    System.out.println("クリア!");
                    point += 1;
                    isNot_finish = false;
                }
            }else{
                System.out.println(easy_numbers[choice - 1] + "では割ることが出来なかった!");
                System.out.println("クリア失敗");
                isNot_finish = false;
            }
        }else{
            int check_number = problem % hard_numbers[choice - 1];
            if(check_number == 0){
                problem /= hard_numbers[choice - 1];
                System.out.println(problem);
                if(problem == 1){
                    System.out.println("クリア!");
                    point += 1;
                    isNot_finish = false;
                }
            }else{
                System.out.println(hard_numbers[choice - 1] + "では割ることが出来なかった!");
                System.out.println("クリア失敗");
                isNot_finish = false;
            }
        }
    }

/**
 * 何回ゲームをクリアすることが出来たかを表示する。
 */
    public void resultDisplay(){
        System.out.print("あなたの得点は" + point + "点です。");
    }
}