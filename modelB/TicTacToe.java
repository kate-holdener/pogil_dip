public class TicTacToe
{
   private TicTacToeTerminal userInterface;
   private AutoPlayer computerPlayer;

   private TicTacToeBoard board;
   private TicTacToePiece usersPiece;
   private TicTacToePiece computersPiece;
   private TicTacToePiece nextMove;

   public TicTacToe(TicTacToePiece usersPiece, AutoPlayer computerPlayer)
   {
      this.board = new TicTacToeBoard();
      this.userInterface = new TicTacToeTerminal(this.board);
      this.usersPiece = usersPiece;
      if (usersPiece == TicTacToePiece.X)
      {
         this.computersPiece = TicTacToePiece.O;
      }
      else
      {
         this.computersPiece = TicTacToePiece.X;
      }
      this.computerPlayer = computerPlayer;
      this.nextMove = TicTacToePiece.X;
   }

   public boolean isGameOver()
   {
      boolean gameOver = false;
      TicTacToePiece winner = this.board.getWinner();
      if (winner != null || this.board.isFull())
      {
         gameOver = true;
      }
      return gameOver;
   }

   public void makeNextMove()
   {
      if (this.nextMove == usersPiece)
      {
         userInterface.manualMove(usersPiece);
         this.nextMove = computersPiece;
      }
      else
      {
         this.computerPlayer.makeNextMove(board);
         this.nextMove = usersPiece;
      }
   }
   
   public void showBoard()
   {
      userInterface.showBoard();
   }

   public TicTacToePiece playGame()
   {
      while(!isGameOver())
      {
         makeNextMove();
         showBoard();
      }

      TicTacToePiece winner = this.board.getWinner();
      return winner;
   }
}
