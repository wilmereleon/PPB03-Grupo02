/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

import java.util.ArrayList;


public class Game{
   //intialize variable, deck and board, arraylist
   private int selectedCards;
   Deck deck;
   Board board;
   private ArrayList <BoardSquare> selected;

   /*
   Constructor
   creates a new game with a new shuffled deck
   and board, selected starts empty
   */
   public Game(){
      selectedCards = 0;
      deck = new Deck();
      deck.shuffle();
      board = new Board(deck);
      selected = new ArrayList<BoardSquare>(3);
   }

   /*
   method outOfCards determines if the 
   board is out of new cards
   @return boolean out
   */
   public boolean outOfCards(){
      boolean out;
      if(deck.isEmpty() == true){
         out = true;
      }
      else
      {
         out = false;
      }
      return out;
   }

   /*
   method addToSelected
   takes the BoardSquare the user selects and saves it to compare later
   @param row
   @param column
   */
   public void addToSelected(int row, int col){
   //add card to an arraylist of selected
      selected.add(board.getBoardSquare(row, col));
      selectedCards++;
      if (selectedCards == 3){
         testSelected();
         }
   }

   /*
   method numSelected returns the number of selected cards being held
   @return selectedCards
   */
   public int numSelected(){
      return selectedCards;
   }

   /*
   method testSelected
   tests whether the three cards in the selected ArrayList
   are a Set
   */
   public boolean testSelected(){
      boolean set = false;
   //test if the cards from selected are a Set, method is in Card Class
      if (selected.size() == 3 && !selected.isEmpty()){
         //boolean set = false;
         //BoardSquare bs1 = selected.get(0);
         //BoardSquare bs2 = selected.get(1);
         //BoardSquare bs3 = selected.get(2);
         //Card.isSet(bs1.getCard(), bs2.getCard(), bs2.getCard());
         if (Card.isSet(selected.get(0).getCard(), selected.get(1).getCard(), selected.get(2).getCard())){
            board.replaceCard(deck.getTopCard(), selected.get(0).getRow(), selected.get(0).getColumn());
            board.replaceCard(deck.getTopCard(), selected.get(1).getRow(), selected.get(1).getColumn());
            board.replaceCard(deck.getTopCard(), selected.get(2).getRow(), selected.get(2).getColumn());
            //print SET
            System.out.print("It's a SET! Pick another\n");
            //empty ArrayList
            for (int i = 0; i < selected.size();) {
               selectedCards = 0;
               selected.remove(i);
            }
             set = true;
         }
         else{
            //print NOT a SET
            System.out.print("Not a SET! Try again\n");
            //empty ArrayList
            for (int i = 0; i < selected.size();) {
               selectedCards = 0;
               selected.remove(i);
            }
            set = false;
         }
         //return set;
      }
      return set;
   }

   /*
   method removeSelected
   de-selects a boardsquare from the arraylist
   @param row
   @param column
   */
   public void removeSelected(int row, int col){
      boolean status = false;
      if (selected.get(0).getRow() == row && selected.get(0).getColumn() == col){
         selected.remove(0);
         selectedCards--;
      }
      else if (selected.get(1).getRow() == row && selected.get(1).getColumn() == col){
         selected.remove(1);
         selectedCards--;
      }
      else if (selected.get(2).getRow() == row && selected.get(2).getColumn() == col){
         selected.remove(2);
         selectedCards--;
      }
      else{
         status = false;
      }
   }

   /*
   method getSelected
   returns the cards that have been selected
   @return selected
   */
   public ArrayList<BoardSquare> getSelected(){
      return selected;
   }

   /*
   method add3
   adds three cards to the board
   */
   public void add3(){
      board.add3(deck);
   }

   /*
   method to String
   converts the game to a string for printing
   */
   public String toString(){
      return board.toString();
   }


   public Board getBoard() {
      return board;
   }
}