package dsa.backtrack;

public class WordSearch {
    int row;
    int col;
    public boolean exist(char[][] board, String word){
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(backtrack(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, int start, String word) {
        if (start >= word.length()) return true;
        if (i < 0 || i >= row | j < 0 || j >= col || board[i][j] != word.charAt(start)) return false;
        board[i][j] = '#';
        if (backtrack(board, i+1, j, start+1, word)) return true;
        if (backtrack(board, i, j+1, start+1, word)) return true;
        if (backtrack(board, i-1, j, start+1, word)) return true;
        if(backtrack(board, i, j-1, start+1, word)) return true;
        board[i][j] = word.charAt(start);
        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(board1, "ABCCED"));

        char[][] board2 = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new WordSearch().exist(board2, "ABCB"));
    }
}
