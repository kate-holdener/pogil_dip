public class NaivePlayer
{
   private TicTacToePiece myPiece;

   public NaivePlayer(TicTacToePiece piece)
   {
      this.myPiece = piece;
   }

   public boolean makeNextMove(TicTacToeBoard board)
   {
      int boardSize = board.getSize();
      for (int i = 0; i < boardSize; i++)
      {
         for (int j = 0; j < boardSize; j++)
         {
            if(board.placeTicTacToePiece(i,j,this.myPiece))
            {
               return true;
            }
         }
      }
      return false;
   }

}
