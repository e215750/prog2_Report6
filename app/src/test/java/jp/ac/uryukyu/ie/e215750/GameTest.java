/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.ac.uryukyu.ie.e215750;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void commandExecutionTest(){
        Game Test = new Game();
        Test.level = 1;
        Test.choice = 6;
        assertThrows(Exception.class,() -> Test.commandExecution());
    }
}
