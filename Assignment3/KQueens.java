
public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


    /**
     * Checks if the input parameters are valid
     *
     * @param k number of queens
     * @param rows number of rows to be on a board
     * @param cols number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls){
    	boolean isValid = true;
    	int counter = 0;
    	// check if all the parameters are valid
    	if (rows >= 1 & cols >=1 & k>=1 & walls != null && walls.length == rows) {
    		for (int i = 0 ; i < rows & isValid ; i=i+1) {
    			// ensure that all the elements in wall are not null
    			if (walls[i] != null) {
    				for (int j = 0; j < walls[i].length & isValid ; j=j+1) {
    					counter = counter +1;
    					// check is the value of each element in walls is valid
    					if (walls[i][j] > cols)
    						isValid = false;
    				}
    			}
    			else 
    				isValid = false;
    		}
    		// check if the numbers of queens id bigger than the number of empty places on the board
    		if (k > (rows*cols) - counter)
    			isValid = false;
    	}
    	else
    		isValid = false;
        return isValid;
    }

    /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows number of rows in board. Assume valid value.
     * @param cols number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    public static int[][] createBoard(int rows, int cols, int[][] walls){
    	int [][] board = new int [rows][cols];
    	// enter the walls to their places in board
    	for (int i = 0 ; i<rows ; i=i+1) {
    		if (walls[i].length != 0) {
    			for (int j = 0 ; j<walls[i].length ; j=j+1) {
    				int p = walls [i][j];
    				board [i][p] = WALL;
    			}
    		}
    	}
        return board;
    }

    /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    public static void printBoard(int[][] board){
    	if (board.length == 0) 
    		System.out.print("There is no solution");
    	else {
    		// check for each element what is contains and print it
    		for (int i = 0 ; i < board.length ; i=i+1) {
    			for (int j = 0 ; j < board[i].length ; j = j+1) {
    				if (board[i][j] == QUEEN)
    					System.out.print("Q ");
    				else if (board[i][j] == WALL)
    					System.out.print("X ");
    				else if (board [i][j] == EMPTY)
    					System.out.print("* ");
    			}
    			System.out.println();
    		}
    	}
    }

    /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    public static boolean validateWalls(int[][] walls, int[][] board){
    	boolean val = true;
    	// check if board is null
    	if (board == null)
    		val = false;
    	else {
    		// check if there is a element that is null
    		for (int i = 0; i<board.length ; i=i+1) {
    			if (board [i] == null) 
    				val = false;
    			else {
    				// check if all the elements in board are QUEEN/EMPTY/WALL
    				for (int j = 0; j<board[i].length ; j=j+1) {
    					if (board[i][j] != WALL & board [i][j] != QUEEN & board[i][j] != EMPTY)
    						val = false;
    				}
    			}
    		}
    	}
    	if (val == true) {
    		// check that all the walls are in board
    		for (int k = 0 ; k<walls.length & val; k=k+1) {
    			for (int q = 0 ; q<walls[k].length & val ; q=q+1) {
    				int p = walls [k][q];
    				if (board [k][p] != WALL)
    					val = false;
    			}
    		}
    		// check if there are any walls that are not suppose to be in board
    		for (int a = 0; a<board.length ; a=a+1) {
    			for (int b = 0; b<board[a].length; b=b+1) {
    				if (board [a][b] == WALL) {
    					val = false;
    					int y = 0;
    					// check if this wall needs to be in board according to walls
    					while (y<walls[a].length & !val) {
    						if (walls[a][y] == b)
    							val = true;
    						y = y+1;
    					}
    				}
    			}
    		}
    	}
        return val;
    }



    /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row the row in which the queen is located
     * @param col the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    public static boolean isQueenThreatened(int[][] board, int row, int col){
    	boolean isThreatened = false;
    	// check if the queen is threatened in her row
    	for (int i = 0 ; i<board[row].length & !isThreatened ; i=i+1) {
    			if (board[row][i] == QUEEN & i!=col) {
    				isThreatened = true;
    				// check if there is a wall between the queens
    				if (i<col) {
    					for (int j = i ; j<col & isThreatened ; j=j+1) {
    						if (board[row][j] == WALL)
    							isThreatened = false;
    					}
    				}
    				// check if there is a wall between the queens
    				if (i>col) {
    					for (int j = i ; j>col & isThreatened ; j=j-1) {
    						if (board[row][j] == WALL)
    							isThreatened = false;
    					}
    				}
    		}
    	}
    	// check if the queen is threatened in her column
    	for (int a = 0; a<board.length & !isThreatened ; a=a+1) {
    		if (board[a][col] == QUEEN & a!=row) {
				isThreatened = true;
				// check if there is a wall between the queens
				if (a<row) {
					for (int b = a; b<row & isThreatened ; b=b+1) {
						if (board[b][col] == WALL)
							isThreatened = false;
					}
				}
				// check if there is a wall between the queens
				if (a>row) {
					for (int b = a; b>row & isThreatened ; b=b-1) {
						if(board[b][col] == WALL)
							isThreatened = false;
					}
				}
    		}
    	}
    	int stepForward = 1;
    	int currentRow;
    	int currentCol;
    	boolean keepCheck = true;
    	// Check the diagonals
    	while (keepCheck & !isThreatened) {
    		keepCheck = false;
    		// check up right
    		currentRow = row + (-1*stepForward);
    		currentCol = col + (+1*stepForward);
    		if (currentRow >= 0 & currentRow < board.length & currentCol >= 0 & currentCol < board[row].length) {
    			keepCheck = true;
    			if (board[currentRow][currentCol] == QUEEN) {
    				isThreatened = true;
    				// check if there is a wall
    					int row1 = row;
    					int col1 = col;
    					while (row1>currentRow & row1>=0 & row1 < board.length & col1 >=0 & col1 < board[row].length ) {
    						if (board[row1][col1] == WALL)
    							isThreatened = false;
    						row1 = row1 -1;
    						col1 = col1 +1;
    				}
    			}
    		}
    		// check up left
    		currentRow = row + (-1*stepForward);
    		currentCol = col + (-1*stepForward);
    		if (currentRow >= 0 & currentRow < board.length & currentCol >= 0 & currentCol < board[row].length) {
    			keepCheck = true;
    			if (board[currentRow][currentCol] == QUEEN) {
    				isThreatened = true;
    				// check if there is a wall
    					int row1 = row;
    					int col1 = col;
    					while (row1>currentRow & row1>=0 & row1 < board.length & col1 >=0 & col1 < board[row].length) {
    						if (board[row1][col1] == WALL)
    							isThreatened = false;
    						row1 = row1 -1;
    						col1 = col1 -1;
    				}
    			}
    		}
    		// check down right
    		currentRow = row + (1*stepForward);
    		currentCol = col + (1*stepForward);
    		if (currentRow >= 0 & currentRow < board.length & currentCol >= 0 & currentCol < board[row].length) {
    			keepCheck = true;
    			if (board[currentRow][currentCol] == QUEEN) {
    				isThreatened = true;
    				// check if there is a wall
    					int row1 = row;
    					int col1 = col;
    					while (row1<currentRow & row1>=0 & row1 < board.length & col1 >=0 & col1 < board[row].length) {
    						if (board[row1][col1] == WALL)
    							isThreatened = false;
    						row1 = row1 +1;
    						col1 = col1 +1;
    				}
    			}
    		}
    		// check down left
    		currentRow = row + (1*stepForward);
    		currentCol = col + (-1*stepForward);
    		if (currentRow >= 0 & currentRow < board.length & currentCol >= 0 & currentCol < board[row].length) {
    			keepCheck = true;
    			if (board[currentRow][currentCol] == QUEEN) {
    				isThreatened = true;
    				// check if there is a wall
    					int row1 = row;
    					int col1 = col;
    					while (row1<currentRow & row1>=0 & row1 < board.length & col1 >=0 & col1 < board[row].length) {
    						if (board[row1][col1] == WALL)
    							isThreatened = false;
    						row1 = row1 +1;
    						col1 = col1 -1;
    				}
    			}
    		}
    		stepForward = stepForward +1;
    	}
    	return isThreatened;
    }


    /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k number of queens that must be on the board. Assume k>=1.
     * @param rows number of rows that must be on the board. Assume rows>=1.
     * @param cols number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls){
    	boolean isLegal = true;
    	// check if board length is rows on cols
    	if (board.length != rows)
    		isLegal = false;
    	for (int j = 0; j<board.length & isLegal ; j=j+1) {
    		if (board[j].length != cols)
    			isLegal = false;
    		else {
    			// check if every elements contains WALL/QUEEN/EMPTY
				for (int t = 0; t<board[j].length ; t=t+1) {
					if (board[j][t] != WALL & board [j][t] != QUEEN & board[j][t] != EMPTY)
						isLegal = false;
				}
    		}
    	}
    	// check if board contain all the walls
    	if (!validateWalls(walls, board))
    		isLegal = false;
    	// check if there are k queens
    	int counter = 0;
    	for (int i = 0; i<board.length & isLegal ; i=i+1) {
    		for (int e =0 ; e<board[0].length & isLegal ; e=e+1) {
    			if (board[i][e] == QUEEN) {
    				// check if there is a queen that is threatened
    		    	if (isQueenThreatened(board, i, e))
    		    		isLegal = false;
    				counter = counter+1;
    			}
    		}
    	}
    	// check if there are k queens
    	if (counter != k)
    		isLegal = false;
        return isLegal;
    }

    /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row queen must be added to this row. Assume valid value.
     * @param col queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    public static boolean addQueen(int[][] board, int row, int col){
    	boolean add = false; 
    	// check if the queen is threatened 
    	if(!isQueenThreatened(board, row, col)) {
    		// check that in this place there is not a wall
    		if (board[row][col] != WALL) {
    			board[row][col] = QUEEN;
    			add = true;
    		}
    	}
        return add;
    }

    /**
     * Solves the k queens problem.
     *
     * @param k number of queens to be located on the board
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls){
    	int [][] board = new int [0][0];
    	// check if the input is valid
    	if (isValidInput(k, rows, cols, walls)) {
    		board = createBoard(rows,cols,walls);
    	}
    	// if there is no solution return empty board
    	if (!(kQueens(board, k, 0, 0, 0)))
    		board = new int [0][0];
        return board;
    }

    /**
     * Recursive helper function for the k queens problem
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens){
    	boolean output = false;
    	if (numOfQueens == k)
    		return true;
    	// change the value of col to 0 if it passed all the elements in row
		if (col == board[row].length) {
			col = 0;
			row = row +1;
		}
		// if passed all the elements in board and there is no solution
		if (row == board.length)
			return false;
		// add queen if possible
		boolean add = addQueen(board, row, col);
		// enlarge the number of queens added
		if (add) {
			numOfQueens = numOfQueens + 1;
		}
		output = kQueens(board, k, row, col+1, numOfQueens);
        return output;
    }

}

