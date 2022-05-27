public class Driver
{
   public static void main(String []args)
   {
      NaivePlayer computerPlayer = new NaivePlayer(TicTacToePiece.O);
      TicTacToe game = new TicTacToe(TicTacToePiece.X, computerPlayer);
      TicTacToePiece winner = game.playGame();
      if (winner != null)
      {
         System.out.println("Winner is " + winner);
      }
   }
}
