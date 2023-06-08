/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

/**
 *
 * @author Wilme
 */
import java.util.ArrayList;
import java.util.Random;

public class Deck{
   //initialize deck size, create ArrayList, and initialize count
   public final static int CARDS_IN_DECK = 81;
   public ArrayList<Card> deck;
   private int ct;

   /*
   Constructor that represents a fresh deck
   */
   public Deck(){
      freshDeck();
   }

   /*
   Copy constructor that creates all cards in a deck
   */
   public void freshDeck(){
      deck = new ArrayList<Card>(CARDS_IN_DECK);

      for (int number=0; number<3; number++){
         for (int shape=0; shape<3; shape++){
            for (int shading=0; shading<3; shading++) {
               for (int color=0; color<3; color++) {
                  deck.add(new Card(number, shape, shading, color));
               }
            }
         }
      }
    }

   /*
   method shuffle randomizes the order of the cards
   */ 
   public void shuffle()
   {
      int random;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         random = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(random));
         deck.set(random,temp);
      }      
   }

   /*
   method isEmpty determines if the deck has cards in it
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }

   /*
   method getTopCard
   deals a card, returns it, and removes it from the deck
   @return c
   */ 
   public Card getTopCard()
   {
      Card c = deck.remove(deck.size()-1);
      return c;
   }

   /*
   method toString
   turns the deck into a string and returns it
   @return str
   */
   public String toString(){
      String str="Current Deck:\n";
         for (int i=0; i < deck.size() ; i++){
          str+= deck.get(i).toString();
         }
      return str;
   }

   public ArrayList getCards() {
      return deck;
   }
}