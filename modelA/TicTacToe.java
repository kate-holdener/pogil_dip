public class TicTacToe
{
   private TicTacToeTerminal userInterface;
   private AutoPlayer autoPlayer;

   private TicTacToeBoard board;
   private TicTacToePiece playersPiece;
   private TicTacToePiece computersPiece;
   private TicTacToePiece nextMove;

   public TicTacToe(TicTacToePiece playersPiece)
   {
      this.board = new TicTacToeBoard();
      this.userInterface = new TicTacToeTerminal(this.board);
      this.playersPiece = playersPiece;
      if (playersPiece == TicTacToePiece.X)
      {
         this.computersPiece = TicTacToePiece.O;
      }
      else
      {
         this.computersPiece = TicTacToePiece.X;
      }
      this.autoPlayer = new AutoPlayer(computersPiece);
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
      if (this.nextMove == playersPiece)
      {
         userInterface.manualMove(playersPiece);
         this.nextMove = computersPiece;
      }
      else
      {
         this.autoPlayer.makeNextMove(board);
         this.nextMove = playersPiece;
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
