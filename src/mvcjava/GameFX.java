/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.transform.Rotate;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GameFX extends Application {
    public Game g;
    private Pane pane;
    private Board b;
    //int rows = g.getBoard().numRows();
    //int cols = g.getBoard().numCols();

    public static void main(String [] args) {
        Application.launch((String[]) args);
    }

    public void start(Stage stage) throws Exception {

        // Variables
        g = new Game();
        b = g.getBoard();
        pane = new Pane();
        int cardsLeft = g.deck.deck.size();
        BackgroundFill grayBG = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        BackgroundFill darkGrayBG = new BackgroundFill(Color.DARKGRAY, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        BorderPane main = new BorderPane();
        Scene scene = new Scene(main);
        Label label = new Label("Set Game");
        Label instructionsLabel = new Label("Click on cards to select them, Double-click to deselect them, type 'A' to add three cards, type 'E' to end the game");
        Label actionsLabel = new Label("(A)dd 3 cards, (E)nd Game, (N)ew Game");
        Label cardsRemaining = new Label("There are " + cardsLeft + " cards remaining in the deck");
        GridPane topPane = new GridPane();
        GridPane centerPane = new GridPane();
        GridPane rightPane = new GridPane();
        GridPane bottomPane = new GridPane();

        int rows = g.getBoard().numRows();
        int cols = g.getBoard().numCols();

        boolean stop = false;

        // Configure pane
        pane.setPrefHeight(500);
        pane.setPrefWidth(1000);
        centerPane.setPrefHeight(500);
        centerPane.setPrefWidth(700);
        rightPane.setPrefWidth(300);
        rightPane.setPrefHeight(500);
        pane.setBackground(new Background(grayBG));
        rightPane.setBackground(new Background(darkGrayBG));

        // Create initial board
        updateBoard(b, centerPane);

        // Configure label
        label.setTextFill(Color.RED);

        // Add content to topPane
        topPane.add(label, 0, 0);
        topPane.add(instructionsLabel, 0, 1);
        topPane.add(actionsLabel, 0, 2);
        topPane.add(cardsRemaining, 0, 3);

        // Set panes in BorderPane layout
        main.setCenter(centerPane);
        main.setTop(topPane);
        //main.setRight(rightPane); 

        // Request focus and configure window
        stage.setTitle("Set");
        stage.setScene(scene);
        stage.show();
        centerPane.requestFocus();
        centerPane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A: {
                    System.out.println("A was pressed");
                    if (b.numCols() < 6) {
                        g.add3();
                    }
                    updateBoard(b, centerPane);
                    break;
                }
                case E: {
                  Platform.exit();
                  break;
                }
                case N: {
                  System.out.println( "New Game!" );
                  stage.close();
                  Game g2 = new Game();
                  Board  b2 = g2.getBoard();
                  updateBoard(b2, centerPane);
                  stage.setScene(scene);
                  stage.show();
                }
            }
        });
    }


    public Pane createCard(int shape, int fill, int color, int number, int rows, int cols) {
         //int cardRow = cardRow;
         //int cardColumn = cardColumn;
         Pane cardPane = new Pane();
         Pane shapePane = new Pane();

         ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
         ArrayList<Circle> circles = new ArrayList<Circle>();
         ArrayList<Rectangle> diamonds = new ArrayList<Rectangle>();


         String stripesRedURL = "stripesRed.png";
         String stripesPurpleURL = "stripesPurple.png";
         String stripesGreenURL = "stripesGreen.png";
         Image stripesRed = new Image(stripesRedURL);
         Image stripesPurple = new Image(stripesPurpleURL);
         Image stripesGreen = new Image(stripesGreenURL);

        BackgroundFill cardBG = new BackgroundFill(Color.WHITE,
                new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));

         if (shape == 0) {
             for (int i=0; i < number; i++) {
                 circles.add(new Circle(50,20 + (i * 30),10));
             }

             for(Circle circle: circles) {
                 if (fill == 0) {
                     if (color == 0) {
                         circle.setFill(Color.RED);
                     } else if (color == 1) {
                         circle.setFill(Color.PURPLE);
                     } else if (color == 2) {
                         circle.setFill(Color.GREEN);
                     }
                 } else if (fill == 1) {
                     if (color == 0) {
                         circle.setFill(new ImagePattern(stripesRed, 0, 0, 40, 40, false));
                     } else if (color == 1) {
                         circle.setFill(new ImagePattern(stripesPurple, 0, 0, 40, 40, false));
                     } else if (color == 2) {
                         circle.setFill(new ImagePattern(stripesGreen, 0, 0, 40, 40, false));
                     }
                 } else if (fill == 2) {
                     if (color == 0) {
                         circle.setStroke(Color.RED);
                         circle.setFill(Color.WHITE);
                     } else if (color == 1) {
                         circle.setStroke(Color.PURPLE);
                         circle.setFill(Color.WHITE);
                     } else if (color == 2) {
                         circle.setStroke(Color.GREEN);
                         circle.setFill(Color.WHITE);
                     }
                 }
             }
             //System.out.println(circles);
             for(Circle circle: circles) {
                 shapePane.getChildren().add(circle);
             }
         } else if (shape == 1) {
             for (int i=0; i < number; i++) {
                 squares.add(new Rectangle(40, 10 + (i * 30), 20, 20));
             }

             for(Rectangle square: squares) {
                 if (fill == 0) {
                     if (color == 0) {
                         square.setFill(Color.RED);
                     } else if (color == 1) {
                         square.setFill(Color.PURPLE);
                     } else if (color == 2) {
                         square.setFill(Color.GREEN);
                     }
                 } else if (fill == 1) {
                     if (color == 0) {
                         square.setFill(new ImagePattern(stripesRed, 0, 0, 40, 40, false));
                     } else if (color == 1) {
                         square.setFill(new ImagePattern(stripesPurple, 0, 0, 40, 40, false));
                     } else if (color == 2) {
                         square.setFill(new ImagePattern(stripesGreen, 0, 0, 40, 40, false));
                     }
                 } else if (fill == 2) {
                     if (color == 0) {
                         square.setStroke(Color.RED);
                         square.setFill(Color.WHITE);
                     } else if (color == 1) {
                         square.setStroke(Color.PURPLE);
                         square.setFill(Color.WHITE);
                     } else if (color == 2) {
                         square.setStroke(Color.GREEN);
                         square.setFill(Color.WHITE);
                     }
                 }
             }
             //System.out.println(squares);
             for(Rectangle square: squares) {
                 shapePane.getChildren().add(square);
             }
         } else if (shape == 2) {
             for (int i=0; i < number; i++) {
                 diamonds.add(new Rectangle(40, 10 + (i * 30), 20, 20));
             }

             for(Rectangle diamond: diamonds) {
                 diamond.getTransforms().add(new Rotate(45,50,50));
                 if (fill == 0) {
                     if (color == 0) {
                         diamond.setFill(Color.RED);
                     } else if (color == 1) {
                         diamond.setFill(Color.PURPLE);
                     } else if (color == 2) {
                         diamond.setFill(Color.GREEN);
                     }
                 } else if (fill == 1) {
                     if (color == 0) {
                         diamond.setFill(new ImagePattern(stripesRed, 0, 0, 40, 40, false));
                     } else if (color == 1) {
                         diamond.setFill(new ImagePattern(stripesRed, 0, 0, 40, 40, false));
                     } else if (color == 2) {
                         diamond.setFill(new ImagePattern(stripesRed, 0, 0, 40, 40, false));
                     }
                 } else if (fill == 2) {
                     if (color == 0) {
                         diamond.setStroke(Color.RED);
                         diamond.setFill(Color.WHITE);
                     } else if (color == 1) {
                         diamond.setStroke(Color.PURPLE);
                         diamond.setFill(Color.WHITE);
                     } else if (color == 2) {
                         diamond.setStroke(Color.GREEN);
                         diamond.setFill(Color.WHITE);
                     }
                 }

             }
             //System.out.println(diamonds);
             for(Rectangle diamond: diamonds) {
                 shapePane.getChildren().add(diamond);
             }
         }
        cardPane.setBackground(new Background(cardBG));
        cardPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        cardPane.setPrefHeight(100);
        cardPane.setPrefWidth(100);
        cardPane.getChildren().addAll(shapePane);

        //If card is selected, background changes color
        cardPane.setOnMouseClicked(new EventHandler<MouseEvent>(){
        //int selected = 0;
        //ArrayList<String> selected = new ArrayList<String>();
        //g.getSelected();;


        @Override
            public void handle(MouseEvent me) {
               g.board.getBoardSquare(rows,cols).setSelected(!g.board.getBoardSquare(rows,cols).isSelected());
               if(me.getClickCount() == 1){
                  cardPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                  g.addToSelected(rows, cols);
               }
               else if(me.getClickCount() == 2){
                  cardPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                  g.removeSelected(rows, cols);
               }
               if(g.numSelected()==3){
                  g.testSelected();
                  if(g.testSelected() == true){
                     System.out.println("Remove and replace");
                  }
                  else if(g.testSelected() == false){
                     System.out.println("Background to white");
                  }
                  //entire back board to white
                  //cardPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
               }
            }
        });

        return cardPane;

     }

     public void updateBoard(Board b, GridPane pane) {
         ArrayList<ArrayList<BoardSquare>> boardSquares = b.getBoardSquares();
         for (ArrayList<BoardSquare> boardRow: boardSquares) {
             for (BoardSquare boardSquare: boardRow) {
                 Card boardCard = boardSquare.getCard();
                 pane.add(createCard(boardCard.getShape(), boardCard.getShading(), boardCard.getColor(), boardCard.getNumber() + 1, boardSquare.getRow(), boardSquare.getColumn()), boardSquare.getRow(), boardSquare.getColumn());
             }   
         }
      }

}
