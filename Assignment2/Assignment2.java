import java.util.Map;

public class Assignment2 {

	// Task 1
	public static boolean isSquareMatrix(boolean[][] matrix){
		boolean isSquare = true;
		if (matrix != null) {
			// Checks if each element in the array contains an array that its length equals to matrix.length 
			for (int i = 0; i < matrix.length & isSquare; i=i+1) {
				if (matrix [i] != null) {
					if (matrix[i].length != matrix.length)
						isSquare = false;
				}
				else 
					isSquare = false;
			}
		}
		else
			isSquare = false;
		return isSquare;
	}
	
	// Task 2	
	public static boolean isSymmetricMatrix(boolean[][] matrix){
		boolean isSymmetric = true;
		// check if for each element in matrix has the same values as its symmetric element. 
		for (int i = 0; i < matrix.length & isSymmetric; i=i+1) {
			for (int j = 0; j < matrix.length; j = j +1) {
				if (i != j) {
					if (matrix[i][j] != matrix [j][i])
						isSymmetric=false;
				}
			}
		}
		return isSymmetric;
	}
	
	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
		boolean isAntiReflexive = true;
		// check that every element contains in matrix [i][i] the value false
		for (int i = 0; i < matrix.length & isAntiReflexive; i = i +1) {
			if (matrix[i][i] == true)
				isAntiReflexive = false;
		}
		return isAntiReflexive;
	}
	
	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix){
		// ensure that all the functions return true
		boolean isLegal = isSquareMatrix(matrix);
		if (isLegal) {
			isLegal = isSymmetricMatrix(matrix);
			if (isLegal)
				isLegal = isAntiReflexiveMatrix(matrix);
		}
		
		return isLegal;
	}
	
	// Task 5
	public static boolean isPermutation(int[] array){
		boolean isPermutation = true;
		// check every element in the array
		for (int i = 0; i < array.length ; i = i+1) {
			int counter = 0;
			int j = 0;
			// count the number of time that a number appears in the array
			while (counter < 2 & j < array.length) {
				if (array [j] == i)
					counter = counter + 1;
				if (counter == 2)
					isPermutation = false;
				j = j+1;
			}
			if ( counter != 1)
				isPermutation = false;
		}	
		return isPermutation;
	}
	
	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
		boolean isLegal = true;
		int a = tour.length -1;
		// check the values in every element in the array
		for (int i = 0; i < a & isLegal ; i = i + 1) {
			int j = tour [i+1];
			int k = tour [i];
			// check if every element in the array contain the value true in the place of tour [i] [i+1]. 
			if (flights [k][j] != true | flights [j][k] != true)
				isLegal = false;
		}
		// check if the values in the array flights in the places of tour[0],tour[n-1] and tour[n-1],tour[0] are true.
		int dest = tour [0];
		int last = tour [a];
		if (flights [dest][last] != true | flights [last][dest] != true)
			isLegal = false;
		return isLegal;
	}	
	
	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour){
		int length = flights.length;
		// ensure that that the array contain legal values
		if (tour.length != length | tour == null)
			throw new RuntimeException ("The array does not contain the required amount of numbers" );
		// ensure that all the functions return true
		boolean isSolution = isPermutation(tour);
		if (isSolution)
			isSolution = hasLegalSteps(flights,tour);				
		if (tour [0] != 0)
			isSolution = false;
		return isSolution;
	}
	
	// Task 8
	public static int[][] atLeastOne(int[] vars) {
		int [][] cnf = new int [1][vars.length];
		cnf [0] = vars;
		return cnf;
	}
	
	// Task 9
	public static int[][] atMostOne(int[] vars) {
		int [][] cnf;
		//if there is only one element enter it into a new array
		if (vars.length == 1){
			cnf = new int [1][1];
			cnf[0] = vars;
		}
		else {
			//counting how many places the array needs
			int counter = 0;
			for (int i=1 ; i<vars.length ; i=i+1) 				
				counter = counter+i;
			cnf = new int [counter][2];
			int a = 0;
			//dividing all the elements to couples and multiply them by -1.
			for (int j = 0; j<vars.length ; j=j+1) {
				for (int k = j+1; k<vars.length ; k=k+1) {
				if (k!=j) {
					cnf [a] = new int [] {-(vars[j]),-(vars[k])};
					a = a+1;
				}
				}
			}
		}
		return cnf;
	}

	// Task 10
	public static int[][] exactlyOne(int[] vars) {
		int [][] most= atMostOne(vars);
		int [][] least= atLeastOne(vars);
		int [][] cnf = new int [most.length+1][];
		// enter the array we got in atMostOne into a new array 
		for (int i=0; i<most.length ; i=i+1) {
			cnf [i] = new int [2];
			cnf [i] = most [i];
		}
		// enter into the last element the array we got in atLeatOne
		cnf [most.length] = new int [least[0].length];
		cnf [most.length] = least [0];
		return cnf;
	}
	
	// Task 11
	public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {
		int max = 0;
		// Checking which number is the biggest.
		for (int j = 0; j < varSets.length ; j=j+1) {
			for (int k = 0; k< varSets [j].length ; k=k+1) {
				if (varSets[j][k] > max)
					max = varSets[j][k];
			}
		}
		int nVars = max;
		SATSolver.init(nVars);
		// adding the arrays to the SATSolver
		for (int i = 0; i<varSets.length ; i=i+1) {
			int [][] clauses = exactlyOne(varSets [i]);
			SATSolver.addClauses(clauses);
		}
		// checking if there is a TIMEOUT
		boolean[] assignment = SATSolver.getSolution();
		if (assignment == null)
			System.out.println("TIMEOUT");

		return assignment;
	}
	
	// Task 12
	public static int[][] createVarsMap(int n) {
		int [][] map = new int [n][n];
		int k = 1;
		// adding numbers into the array
		for (int i = 0; i<n ; i=i+1) {
			for (int j = 0; j<n ; j=j+1) {
				map [i][j] = k;
				k = k+1;
			}
		}
		return map;
	}
	
	// Task 13
	public static int[][] oneCityInEachStep(int[][] map) {
		int [][] size = atMostOne(map[0]);
		int s = (size.length*map.length)+map.length; //the number of arrays we will need
		int [][] cnf = new int [s][];
		int counter = 0;
		//applying the function "exactlyOne" on every array and adding it to the cnf array
		for (int i = 0; i<map.length ; i=i+1) {
			int [][] a = exactlyOne(map [i]);
			for (int k = 0; k<a.length ; k=k+1) {
				cnf [counter] = a[k];
				counter = counter +1;
			}
		}
		return cnf;
	}
	
	// Task 14
	public static int[][] fixSourceCity(int[][] map) {
		int [][] cnf = new int [1][1];
		cnf [0][0] = map [0][0];
		return cnf;
	}
	
	// Task 15
	public static int[][] eachCityIsVisitedOnce(int[][] map) {
		int [][] size = atMostOne(map[0]);
		int s = (size.length*map.length)+map.length; //the number of arrays we will need
		int [][] cnf = new int [s][];
		int counter = 0;
		// 
		for (int i = 0; i<map.length ; i=i+1) {
			int [] arr = new int [map[i].length];
			for (int j=0; j<map.length ; j=j+1) {
				arr [j] = map [j][i];
			}
			int [][] a = exactlyOne(arr);
			for (int k = 0; k<a.length ; k=k+1) {
				cnf [counter] = a[k];
				counter = counter +1;
			}
		}
		return cnf;
	}

	// Task 16
	public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {
		// count the numbers of places the array needs
		int counter = 0;
		for (int z = 0; z < flights.length; z = z + 1) {
			for (int d = 0; d < flights[z].length; d = d + 1) {
				if (flights[z][d] == false & d != z)
					counter = counter + (map.length - 1);
			}
		}
		for (int last = 0; last < flights.length; last = last + 1) {
			if (flights[last][0] == false & 0 != last)
				counter = counter + 1;
		}
		int[][] cnf = new int[counter][];
		int s = 0;
		// checking in each place if the value is false
		for (int k = 0; k < flights.length; k = k + 1) {
			for (int j = 0; j < flights.length; j = j + 1) {
				if (flights[k][j] == false & k != j) { 
					for (int i = 0; i < map.length - 1; i = i + 1) { 
 						cnf[s] = new int[] { -(map[i][j]), -(map[i + 1][k]) };
						s = s + 1;
					}
				}
			}
		}
		int s1 = map.length - 1;
		// 
		// checking for each array if the value in place 0 is false
		for (int a = 1; a < flights.length; a = a + 1) {
			if (flights[a][0] == false) {
				cnf[s] = new int[] { -map[s1][a] };
				s = s + 1;
			}
		}
		return cnf;
	}
	
	// Task 17
	public static void encode(boolean[][] flights, int[][] map) {
		// checking that the inputs are legal
		boolean isLegal = isLegalInstance(flights);
		if (!isLegal | flights==null | map == null)
			throw new IllegalArgumentException ("The array is ilegal");
		for (int i =0 ; i<map.length ; i=i+1) {
			if (map.length != map[i].length)
				throw new IllegalArgumentException ("The array is ilegal");
		}
		if (flights.length != map.length)
			throw new IllegalArgumentException ("The two arrays do not contain the same amount of variables");
		else if (flights.length == map.length & isLegal) {
			// find max value
			int max = 0;
			for (int j = 0; j < map.length ; j=j+1) {
				for (int k = 0; k< map[j].length ; k=k+1) {
					if (map[j][k] > max)
						max = map[j][k];
				}
			}
			int nVars = max;
			SATSolver.init(nVars);
			// adding each array to the SAT
			int [][] clauses = oneCityInEachStep(map);
			SATSolver.addClauses(clauses);
			int [][] clauses2 = eachCityIsVisitedOnce(map);
			SATSolver.addClauses(clauses2);
			int [][] clauses3 = fixSourceCity(map);
			SATSolver.addClauses(clauses3);
			int [][] clauses4 = noIllegalSteps(flights, map);
			SATSolver.addClauses(clauses4);

		}
	}
	
	// Task 18
	public static int[] decode(boolean[] assignment, int[][] map) {
		if (assignment.length != (map.length*map.length) + 1)
			throw new IllegalArgumentException ("The array is ilegal");
		int [] tour = new int [map.length];
		int a = 0;
		// creating an array that contains places of the numbers in map that are true 
		for (int i = 1; i<assignment.length ; i=i+1) {
			if (assignment[i] == true) {
				for (int j=0 ; j<map.length ; j=j+1) {
					for (int k=0 ; k<map[j].length ; k=k+1) {
						if (map[j][k] == i) {
							tour[a] = k;
							a=a+1;
						}
					}
				}
			}
		}
		return tour;
	}
	
	// Task 19
	public static int[] solve(boolean[][] flights) {
		// checking if the array is legal
		boolean isLegal = isLegalInstance(flights);
		if (!isLegal | flights==null)
			throw new IllegalArgumentException ("The array is ilegal");
		int[][] map = createVarsMap(flights.length);
		encode(flights,map);
		// find the max value
		int max = 0;
		for (int j = 0; j < map.length ; j=j+1) {
			for (int k = 0; k< map[j].length ; k=k+1) {
				if (map[j][k] > max)
					max = map[j][k];
			}
		}
		int nVars = max;
		int [] ans = null;
		boolean [] assignment = SATSolver.getSolution();
		// checking if the solution is legal
		if (assignment == null)
			 System.out.println("TIMEOUT");
		else if (assignment.length == nVars+1) {
			int [] s = decode (assignment, map);
			boolean isSolution =  isSolution(flights, s);
			if (isSolution)
				ans = s;	
			if (!isSolution)
				 System.out.println("The solution is illegal");
		}
		return ans;
	}
		
	// Task 20
	public static boolean solve2(boolean[][] flights) {
		boolean ans = false;
		// checking if the array is legal
		boolean isLegal = isLegalInstance(flights);
		if (!isLegal | flights==null)
			throw new IllegalArgumentException ("The array is ilegal");
		int [] solution1 = solve(flights);
		if(solution1 == null)
			ans = false;
		else {
			int [][] map = createVarsMap(flights.length);
			int [] arr = new int [solution1.length];
			int [] arr2 = new int [solution1.length];
			// create the a demand not to get the same solution.
			for (int i = 0; i<solution1.length ; i=i+1) {
					arr [i] = -(map [i][solution1[i]]);
			}
			// create the demand not to get the equivalence
			arr2 [0] = -(map [0][solution1[0]]);
			for (int f = 1; f<solution1.length ; f=f+1) {
				arr2 [f] = -(map [f][solution1[solution1.length-f]]);
			}
			// find the max value
			int max = 0;
			for (int j = 0; j < map.length ; j=j+1) {
				for (int k = 0; k< map[j].length ; k=k+1) {
					if (map[j][k] > max)
						max = map[j][k];
				}
			}
			int nVars = max;
			// add the demands to the SAT and ask for a solution
			SATSolver.init(nVars);
			encode(flights, map);
			SATSolver.addClause(arr);
			SATSolver.addClause(arr2);		
			boolean [] assignment = SATSolver.getSolution();
			if (assignment == null)
				System.out.println("TIMEOUT");
			else if (assignment.length == nVars+1) {
				// checking if the solution is legal
				int [] solution2 = decode (assignment, map);
				boolean isSolution =  isSolution(flights, solution2);
				if (isSolution)
					ans = true;
				if (!isSolution)
					System.out.println("The solution is illegal");
			}
		}
		return ans;
	}

}

