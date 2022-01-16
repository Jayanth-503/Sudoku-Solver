class Sudoku{
    
    private static final int SIZE = 9;
    
    private static boolean inRow(int[][] board,int n,int row){
        for(int i=0;i<SIZE;i++){
            if(board[row][i] == n){
                return false;
            }
        }
        return true;
    }
     private static boolean inColumn(int[][] board,int n,int column){
        for(int i=0;i<SIZE;i++){
            if(board[i][column] == n){
                return false;
            }
        }
        return true;
    }
     private static boolean inBox(int[][] board,int n,int row,int column){
         int lRow = row-row%3;
         int lColumn = column - column%3;
        for(int i=lRow;i<lRow+3;i++){
            for(int j=lColumn;j<lColumn+3;j++){
                if(board[i][j] == n)   return false;
            }
        }
        return true;
    }
    
    private static boolean isValid(int[][] board, int n, int row, int column){
        return inRow(board,n,row) && inColumn(board,n,column) && inBox(board,n,row,column);
    }
    
    private static boolean solve(int[][] board){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(board[i][j] == 0){
                    for(int number = 1;number<=SIZE;number++){
                        if(isValid(board,number,i,j)) {
                            board[i][j] = number;
                            
                            if(solve(board)) return true;
                            else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void printBoard(int[][] board){
        for(int i=0;i<SIZE;i++){
            if(i%3 == 0 && i != 0){
                System.out.println("- - - - - - - - - - - ");
            }
            for(int j=0;j<SIZE;j++){
                if(j%3 == 0 && j!=0){
                    System.out.print("| ");
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int [][] board = {
            {7,0,2,0,5,0,6,0,0},
            {0,0,0,0,0,3,0,0,0},
            {1,0,0,0,0,9,5,0,0},
            {8,0,0,0,0,0,0,9,0},
            {0,4,3,0,0,0,7,5,0},
            {0,9,0,0,0,0,0,0,8},
            {0,0,9,7,0,0,0,0,5},
            {0,0,0,2,0,0,0,0,0},
            {0,0,7,0,4,0,2,0,3}
        };
        printBoard(board);
        if(solve(board)){
            System.out.println("Solved Successfully");
        }
        else {
            System.out.println("Unsolvable board :(");
        }
        
        printBoard(board);
    }
}