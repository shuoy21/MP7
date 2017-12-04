
public class FinishedTest {

    public boolean finished = false;
    public int N = 4;
    public boolean checkFinished(String[][] board) {
    xLoop: for (int x = 0; x < board[0].length; x++) {
        String lastPlayer = "default";
        yLoop: for (int y = 0; y < board.length - N; y++) {
            finished = true;
            int realY = board.length - 1 - y;
            Player playerA = board[x][realY];
            if (playerA == null) {
                break xLoop;
            }
            if (playerA.equals(lastPlayer)) {
                continue yLoop;
            }
            for (int i = y; i < y + N; i++) {
                int realI = board.length - 1 - i;
                Player playerB = board[x][realI];
                if (!playerB.equals(playerA)) {
                    finished = false;
                    break;
                }
            }
            lastPlayer = playerA;
        }
    }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
