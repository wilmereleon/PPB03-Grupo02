/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

import java.util.ArrayList;

public class Board{
   //initialize arraylist and variables
   private ArrayList<ArrayList<BoardSquare>> board;
   public final static int INITIAL_ROWS = 3;
   public final static int INITIAL_COLS = 4;

   //Constructor that accepts a Deck object and populates
   //The ArrayLists
   public Board(Deck deck){
      board = new ArrayList<ArrayList<BoardSquare>>();
      ArrayList<Card> boardsquare;
      for(int i=0; i<3; i++){
         board.add(new ArrayList<BoardSquare>());
         for(int j=0; j<4; j++){
            board.get(i).add(new BoardSquare(deck.getTopCard(),i,j));
         }
      }           
   }

   /*
   method replaceCard will replace a card that has been removed
   @param card - card object
   @param row - row of the card
   @param column - column of card
   */
   public void replaceCard(Card card, int row, int column){
      board.get(row).get(column).setCard(card);
   }

   /*
   method getBoardSquare returns the card at a specified location
   @param row
   @param column
   @return reference to a board square location
   */
   public BoardSquare getBoardSquare(int row, int column){
      return board.get(row).get(column);
   }

   public ArrayList<ArrayList<BoardSquare>> getBoardSquares() {
      return board;
   }

   /*
   method add3 puts one card into each row if no sets are available
   @param deck object
   */
   public void add3(Deck deck){
      for(int i=0; i<3; i++) {
         board.get(i).add(new BoardSquare(deck.getTopCard(),i,board.get(i).size()));
      }
   }


   /*
   method getCard returns a reference to a card at a location
   @param row
   @param column
   @return reference to a card
   */
   public Card getCard(int row, int column){
      return board.get(row).get(column).getCard();
   }

   /*
   method numRows returns amount of rows on the board
   @return rows
   */
   public int numRows(){
      return INITIAL_ROWS;
   }

   /*
   method numCols gets how many columns in each row, intially 4
   @return columns aka size of the column array
   */
   public int numCols(){
      return board.get(0).size();
   }

   /*
   method toString returns a String representation of the Board
   @return str
   */
   public String toString(){
      String str = "";
      for(int i=0; i<3; i++){
         for(int j=0; j<numCols(); j++){
            str += (board.get(i).get(j).getCard().toString() + "\t");
         }
         str += "\n";
      }
      return str;
   }
}