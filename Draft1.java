import java.util.*;
public class Draft1 {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
    public static void main(String[] args){
        char [] [] Board = {{' ', '|', ' ', '|',' '}, {'_', '+', '_', '+','_'}, {' ', '|', ' ', '|',' '}, {'_', '+', '_', '+','_'}, {' ', '|', ' ', '|',' '}};
        printBoard(Board);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter where you want to place your sign from 1 to 9: ");
            int playerPosition = sc.nextInt();
            while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)){ // maybe change this to if? If I put in a value where somethign already is it just kept going on and on because there was no stopping place.
                System.out.println("position taken. enter another position");
                playerPosition = sc.nextInt();
            }
            place(Board, playerPosition, "player");

            Random rand = new Random();
            int computerPosition = rand.nextInt(9)+1;
            while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)){
                System.out.println("position taken. enter another position");
                int computerPositions = rand.nextInt(9)+1;
            }
            place(Board,  computerPosition, "computer");
            printBoard(Board);

            String  result = isWin();
            System.out.println(result);

        }

    }
        public static void printBoard(char [] [] Board){
            for(char[] row : Board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }public static void place(char[] [] Board, int position, String user){
        char symbol = ' ';

    if(user.equals("player")){
        symbol = 'X';
        playerPositions.add(position);
    } else if(user.equals("computer")){
        symbol = 'O';
        playerPositions.add(position);
    }
        switch(position){
            case 1:
            Board [0][0] = symbol;
            break;
            case 2:
            Board [0][2] = symbol;
            break;
            case 3:
            Board [0][4] = symbol;
            break;
            case 4:
            Board [2][0] = symbol;
            break;
            case 5:
            Board [2][2] = symbol;
            break;
            case 6:
            Board [2][4] = symbol;
            break;
            case 7:
            Board [4][0] = symbol;
            break;
            case 8:
            Board [4][2] = symbol;
            break;
            case 9:
            Board [4][4] = symbol;
            break;
            default:
            break;
        }
    }
    public static String isWin(){

        List firstRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List lastRow = Arrays.asList(7,8,9);
        List firstColumn = Arrays.asList(1,4,7);
        List secondColumn = Arrays.asList(2,5,8);
        List thirdColumn = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(7,5,3);

        List<List>winning = new ArrayList<List>();

        winning.add(firstRow); //I noticed that the program says that you win even if you didn't as long as there was a line with some values. 
        winning.add(midRow); //I'm wondering if you can change it so it it looks at the values in the spots and not just if there is something there.
        winning.add(lastRow); // maybe you could do them as arrays and then check the value?
        winning.add(firstColumn);
        winning.add(secondColumn);
        winning.add(thirdColumn);
        winning.add(diagonal1);
        winning.add(diagonal2);

        for (List l : winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations, you win!" ;
            } else if (computerPositions.contains(l)){
                return "Computer wins." ;
            } else if (playerPositions.size() + computerPositions.size() == 9){
                return "It's a draw." ;
            }
    } return "";
}
}
