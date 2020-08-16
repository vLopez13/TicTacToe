/* Tic Tac Toe created version A: Vanessa Lopez  D: March 31 2019 C:CS 111B Teach:Constance C
Algorithm;
@make the nested loop using array
@figure out the logic of the game 
@Understand each methods and each booleans
@explain it out --> comment throughout

Number of Tries: lost count
At first the program didn't compile
Then, a lot of fixing up, it compiled
Later,mouse didn't fire to visually see each token
After later, the status message was good,
but logic didn't follow through entirely
I will keep workign on it. */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Cell;

/* class name: XsAndOs
   -extends into Application meaning it takes out some preexisiting subclass
   -starts out with the data initialization
   */ 
   

   public class XsAndOs extends Application 
{

    private boolean gameOver = false;  //flag
    private char whoseTurn = 'X'; // 'X' or 'O' but 'X' starts 
    private Cell[][] board =  new Cell[3][3];  //the board for playing
    private Label statusLabel = new Label("X's turn to play"); 
   
   @Override   // We start the stage and prep it to show
   public void start(Stage primaryStage)
   {  
      GridPane pane = new GridPane();   
      // Figure out the array loop and how to access the column and row 
      // make a nested loop so I am using i == row & j == col 
      for (int i =0; i <3; i++)
      { for(int j = 0; j <3; j++)
       { 
         board[i][j] = new Cell();    // make a new Cell(), it shows an array
         pane.add(board[i][j], j, i);
       }
      }  
      BorderPane borderPane = new BorderPane(); // it looks like we are using borderpane
      
      borderPane.setCenter(pane);
 
      borderPane.setBottom(statusLabel);
      
      Scene scene = new Scene(borderPane, 300, 300);
      primaryStage.setTitle("X's & O's");
      
      primaryStage.setScene(scene);   //And we begin the show!
      primaryStage.show();
      }
    /* isFull() method
       @ takes no parameters
       @ takes in account each value in board to see if it's full
       @ local data int count to make sure the board is empty
       */ 
       
    public boolean isFull()    
    {
      int count = 0;
      for(int i =0; i <3; i++)
      { for(int j =0; j<3; j++)
       {
         if (board[i][j].getToken() == ' '){
	           count++; 
          }                  
        }
      }
            
     return count > 0 ? false : true;
   }
   /*  hasWon() method
   @takes parameters  - character: token
   @ takes a loop to check each array space
   @ checks if the space is a win 
   @ there are 8 chances to win 
   */
   public boolean hasWon(char token)
   
    { for(int j= 0; j<3; j++)
      { for(int i =0; i<3; i++)
        {
         if(board[0][0].getToken()==token && board[0][1].getToken()==token && board[0][2].getToken()==token)
         return true;
         if (board[1][0].getToken()==token && board[1][1].getToken()==token && board[1][2].getToken()==token)
         return true;
         if (board[2][0].getToken()==token && board[2][1].getToken()==token && board[2][2].getToken()==token)
         return true;
         if (board[0][0].getToken()==token && board[1][0].getToken()==token && board[2][0].getToken()==token)
         return true;
         if (board[0][1].getToken()==token && board[1][1].getToken()==token && board[2][1].getToken()==token)
         return true; 
         if (board[0][2].getToken()==token && board[1][2].getToken()==token && board[2][2].getToken()==token)
         return true;
         if (board[0][0].getToken()==token && board[1][1].getToken()==token && board[2][2].getToken()==token)
         return true;
         if (board[0][2].getToken()==token && board[1][1].getToken()==token && board[2][0].getToken()==token)
         return true;
         }
       }
       return false;
    }

   /* class: Cell 
    -extends to Pane Taking the class Grid pane 
    -Instantiates data
    */ 
      
    public class Cell extends Pane {
        private char token = ' ';   // one of blank, X, or O
       // Cell() taking each cell into gridpane
        public Cell() {
            setStyle("-fx-border-color: black"); 
            setPrefSize(100, 100);
            setOnMouseClicked(e -> handleMouseClick());  //lambda notation
        }        
        // getToken() method 
        // @takes no parameters
        // character returned
        public char getToken()
        {
           return token;
        }
        // setToken method
        // @ takes character "c"
        // returns true if it's X or O if it's not X
        public void setToken(char c) {
            if (c == 'X'){
               drawX(); 
             } 
             else if ( c =='O'){
                 drawO();
              }
               
             token = c;
           }
        // draws X
        public void drawX() {
            double w = getWidth();
            double h = getHeight();
            
            Line line1 = new Line(10, h-10, w-10,10);
            Line line2 = new Line(10, 10, w-10, h-10);
            
            
                    //CODE HERE TO CREATE TWO LINES FOR 'X'
            getChildren().addAll(line1, line2); 
            }
        // draws O
        public void drawO() {
            double w = getWidth();
            double h = getHeight();
            Ellipse ellipse = new Ellipse( w/2, h/2, w/2, h/2);
                //CODE HERE TO CREATE AN 'O'
            getChildren().add(ellipse);
         }
  /*  handleMouseClick() 
  -local data --> the String
  - Logic of the game in tic tac toe if game is not over it's false
  - token was taken to see if 1 of the 9 spaces were occupied
  - if not then we take that space in ! gameOver  Keep Going
  - if the player has won then set game to true Winner!
  - check if board is full we set game to true and message Draw!
  - see how we switch turns from X then to O then back again X
  */
         
      
        private void handleMouseClick() {
             String s = "";
           if (!gameOver){
                
              if (token == ' '){
             
                    if (whoseTurn == 'X'){
                    setToken('X'); } 
                   
                    if(whoseTurn == 'O'){
                    setToken('O'); }
                  
               
                if (hasWon(whoseTurn)){
                  
                  statusLabel.setText( whoseTurn +"'s has won!");
                  gameOver = true; }
                  
                  
                  
                else if(isFull()) {
                   statusLabel.setText("The board is full, it's a tie!");
                   gameOver = true;    }
                 
                   
                     else {
                        // TOGGLE PLAYER
                        if (whoseTurn == 'X' && !gameOver){
                           whoseTurn = 'O';    
                           statusLabel.setText(whoseTurn+ "'s turn to play");}
                        
                        
                        else if (whoseTurn == 'O' && !gameOver){
                         whoseTurn = 'X';    
                         statusLabel.setText(whoseTurn+ "'s turn to play");} 
                       
                          }
                 
           }
           else {
            s = "that space is occupied, try again.";   }
                
      
      }
     else{
       s = "the game is over!";
       statusLabel.setText(s); 
       
         }

                              
    }
                
             /*  code I tried making it different
                   if (token == ' ' && !gameOver){
                    
                   statusLabel.setText(whoseTurn + " the space is occupied");
                    
                   
                  if (whoseTurn = (whoseTurn == 'O') ? 'X' :'O'){
                   statusLabel.setText(whoseTurn+ "'s turn to play");
                   setToken(whoseTurn);


                      }
         
                  
              */     
             
                       
         
    }
      
    // static main()
    // and we  launch  it!       
  
    public static void main(String[] args) {
        launch(args);
    }
    
  }
    
    

 
    
   
    
