// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class AirlineReservations {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        int[][] seats = new int[N][10];
        int families = 0;
        
        if(S.length() != 0) {
            String[] reservedSeats = S.split("\\s+");
            String letters = "ABCDEFGHJK";
            
            for(int i = 0; i < reservedSeats.length; i++) {
                int number = Integer.parseInt(reservedSeats[i].replaceAll("[^0-9]",""));
                String letter = reservedSeats[i].replaceAll("[^A-Z]","");
                seats[number-1][letters.indexOf(letter)] = 1;				
            }
            
            for(int row = 0; row < N; row++) {
                for(int section = 0; section < 3; section++) {
                    int consecutiveSeats = 0;
                    
                    if(section == 0) {
                        for(int seat = 0; seat < 3; seat++) {
                            if(seats[row][seat] == 0)
                                consecutiveSeats++;
                        }

                        if(consecutiveSeats == 3)
                            families++;
                    }
                    else if(section == 1) {
                        for(int seat = 3; seat < 7; seat++) {
                            if(seats[row][seat] == 0)
                                consecutiveSeats++;
							else
								consecutiveSeats = 0;
						}

						if(consecutiveSeats > 2)
							families++;
                    }
                    else {
                        for(int seat = 7; seat < 10; seat++) {
                            if(seats[row][seat] == 0)
                                consecutiveSeats++;
						}

						if(consecutiveSeats == 3)
							families++;
                    }
                }
            }
        }
        else {
            families = 3 * N;
        }
        
        return families;
    }
	
	public int solution_N_size(int N, String S, int familySize) {
        // write your code in Java SE 8
        int[][] seats = new int[N][10];
        int families = 0;
        
        if(S.length() != 0) {
            String[] reservedSeats = S.split("\\s+");
            String letters = "ABCDEFGHJK";
            
            for(int i = 0; i < reservedSeats.length; i++) {
                int number = Integer.parseInt(reservedSeats[i].replaceAll("[^0-9]",""));
                String letter = reservedSeats[i].replaceAll("[^A-Z]","");
                seats[number-1][letters.indexOf(letter)] = 1;				
            }
            
            for(int row = 0; row < N; row++) {
                for(int section = 0; section < 3; section++) {
                    int consecutiveSeats = 0;
                    
                    if(section == 0) {
                        for(int seat = 0; seat < 3; seat++) {
                            if(seats[row][seat] == 0) {
                                consecutiveSeats++;
								
								if(consecutiveSeats == familySize) {
									families++;
									consecutiveSeats = 0;
								}		
							}
							else
								consecutiveSeats = 0;
                        }
                    }
                    else if(section == 1) {
                        for(int seat = 3; seat < 7; seat++) {
                            if(seats[row][seat] == 0) {
                                consecutiveSeats++;
								
								if(consecutiveSeats == familySize) {
									families++;
									consecutiveSeats = 0;
								}									
							}
							else
								consecutiveSeats = 0;
						}						
						
						families += consecutiveSeats / familySize;
                    }
                    else {
                        for(int seat = 7; seat < 10; seat++) {
                            if(seats[row][seat] == 0) {
                                consecutiveSeats++;
								
								if(consecutiveSeats == familySize) {
									families++;
									consecutiveSeats = 0;
								}		
							}
							else
								consecutiveSeats = 0;
						}
                    }
                }
            }
        }
        else {
			if(familySize == 4)
				families = N;
			else if(familySize == 3)
				families = 3 * N;
			else if(familySize == 2)
				families = 4 * N;
			else if(familySize == 1)
				families = 10 * N;
			else families = 0;
        }
        
        return families;
    }
	
	public static void main(String[] args) {		
		AirlineReservations s = new AirlineReservations();
		System.out.println("Solution: " + s.solution(2,"1A 2F 1C") + " families");
		System.out.println("Solution: " + s.solution(3,"1A 2F 1C 3D 3J") + " families");
		System.out.println("Solution: " + s.solution(1,"") + " families");
		
		System.out.println("Solution: " + s.solution_N_size(2,"1A 2F 1C",2) + " families");
		System.out.println("Solution: " + s.solution_N_size(3,"1A 2F 1C 3D 3J",2) + " families");
		System.out.println("Solution: " + s.solution_N_size(1,"",2) + " families");
	}
}