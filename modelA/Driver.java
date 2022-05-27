public class Driver
{
   public static void main(String []args)
   {
      TicTacToe game = new TicTacToe(TicTacToePiece.X);
      TicTacToePiece winner = game.playGame();
      if (winner != null)
      {
         System.out.println("Winner is " + winner);
      }
   }
}
