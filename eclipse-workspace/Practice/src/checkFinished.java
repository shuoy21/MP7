
public class checkFinished {
	
	boolean finished = false;
	private Player[][] board;
	int width = board.length;
	int height = board[0].length;
	int N = 3;
	private Player winner;
	public boolean checkFinishedTester(Player[][] board) {
		this.board = board;
        // vertical
        finished = false;
        if (board == null) {
            return false;
        }
        xLoop: for (int x = 0; x < width; x++) {
            Player previousPlayer = new Player("default");
            yLoop: for (int y = 0; y < height - N; y++) {
                finished = true;
                int realY = height - 1 - y;
                Player playerA = board[x][realY];
                //System.out.println("line257:" + x + " " + realY);
                if (playerA == null) {
                    continue xLoop;
                }
                if (playerA.equals(previousPlayer)) {
                    continue yLoop;
                }
                for (int i = y + 1; i < y + N; i++) {
                    int realI = height - 1 - i;
                    Player playerB = board[x][realI];
                    if (playerB == null) {
                        finished = false;
                        continue xLoop;
                    }
                    if (!playerB.equals(playerA)) {
                        finished = false;
                        break;
                    }
                }
                    if (finished) {
                        winner = playerA;
                        return finished;
                }
                    previousPlayer = playerA;
                }
            }
        //horizontal
        yLoop: for (int y = 0; y < height; y++) {
            Player lastPlayer = new Player("default");
            xLoop: for (int x = 0; x < width - N; x++) {
                finished = true;
                Player playerA = board[x][y];
                System.out.println("line289:" + x + " " + y);
                if (playerA == null) {
                    continue xLoop;
                }
                if (playerA.equals(lastPlayer)) {
                    continue xLoop;
                }
                for (int i = x + 1; i < x + N; i++) {
                    Player playerB = board[x][y];
                    if (playerB != null && !playerB.equals(playerA)) {
                        finished = false;
                        break;
                    }
                }
                if (finished) {
                    winner = playerA;
                    return finished;
                }
                lastPlayer = playerA;
            }
        }
            System.out.println(winner);
        return finished;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player A = new Player("A");
		Player B = new Player("B");
		Player[][] board = {{null, A, B, A, A ,A, B}, {null, B, A, B, A, B, A}, {null, A, B, B, A, null, null}};
		//System.out.println(winner);
}
}
