/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

public class BoardSquare{

   private int column;//column of the card
   private int row; //row of the card
   private Card card;
   private boolean selected=false;

   /*Constructor
   @param card, a card object
   @param column, column of the card
   @param row, row of the card
   */
   public BoardSquare(Card card, int column, int row){
      this.column = column;
      this.row = row;
      this.card = card;
   }

   /*
   method getColumn returns column
   @return column
   */
   public int getColumn(){
      return column;
   }

   /*
   method setColumn updates the column
   @param c
   */
   public void setColumn(int c){
      column = c;
   }

   /*
   method getRow returns row
   @return row
   */
   public int getRow(){
      return row;
   }

   /*
   method setRow updates the row
   @param r
   */
   public void setRow(int r){
      row = r;
   }

   /*
   method getCard returns card
   @return card
   */
   public Card getCard(){
      return card;
   }

   /*
   method setCard updates the card
   @param c
   */
   public void setCard(Card c){
      card = c;
   }

   /*
   method isSelected
   @returns boolean selected
   */
   public boolean isSelected(){
      return selected;
   }

   public void setSelected(boolean s){
      selected = s;
   }

}