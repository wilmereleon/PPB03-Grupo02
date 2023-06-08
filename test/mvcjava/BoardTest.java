/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mvcjava;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Wilme
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of replaceCard method, of class Board.
     */
    @Test
    public void testReplaceCard() {
        System.out.println("replaceCard");
        Card card = null;
        int row = 0;
        int column = 0;
        Board instance = null;
        instance.replaceCard(card, row, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardSquare method, of class Board.
     */
    @Test
    public void testGetBoardSquare() {
        System.out.println("getBoardSquare");
        int row = 0;
        int column = 0;
        Board instance = null;
        BoardSquare expResult = null;
        BoardSquare result = instance.getBoardSquare(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardSquares method, of class Board.
     */
    @Test
    public void testGetBoardSquares() {
        System.out.println("getBoardSquares");
        Board instance = null;
        ArrayList<ArrayList<BoardSquare>> expResult = null;
        ArrayList<ArrayList<BoardSquare>> result = instance.getBoardSquares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add3 method, of class Board.
     */
    @Test
    public void testAdd3() {
        System.out.println("add3");
        Deck deck = null;
        Board instance = null;
        instance.add3(deck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCard method, of class Board.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        int row = 0;
        int column = 0;
        Board instance = null;
        Card expResult = null;
        Card result = instance.getCard(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numRows method, of class Board.
     */
    @Test
    public void testNumRows() {
        System.out.println("numRows");
        Board instance = null;
        int expResult = 0;
        int result = instance.numRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numCols method, of class Board.
     */
    @Test
    public void testNumCols() {
        System.out.println("numCols");
        Board instance = null;
        int expResult = 0;
        int result = instance.numCols();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
