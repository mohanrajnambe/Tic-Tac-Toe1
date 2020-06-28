package tictactoe;
import java.util.*;
public class Board {

    char[][] m = new char[3][3];
    Board(){
        // matrix generation
        for (int i = 0;i < 3;i ++){
            Arrays.fill(m[i],'_');
        }
        printCell(m);
    }

    //analyse board status
    public boolean result(char[][] m){


        int emptyCount = 0;

        for (int i = 0;i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (m[i][j] == '_')
                    emptyCount++;
            }
        }
        int xHat=0, oHat=0;

        // check for row hat trick
        for (int i = 0;i < 3;i ++){
            if (m[i][0]!='_') {
                char check = m[i][0];
                boolean row = true;
                for (int j = 1; j < 3; j++) {
                    if(check != m[i][j]){
                        row = false;
                        break;
                    }
                }
                if(row){
                    if(check=='X')
                        xHat++;
                    else
                        oHat++;
                }

            }
        }

        //check for column hat trick
        for (int j = 0;j < 3;j ++){
            if (m[0][j]!='_') {
                char check = m[0][j];
                boolean col = true;
                for (int i = 1; i < 3; i++) {
                    if(check != m[i][j]){
                        col = false;
                        break;
                    }
                }
                if(col){
                    if(check=='X')
                        xHat++;
                    else
                        oHat++;
                }

            }
        }

        // check for main diagonal for hat trick
        if(m[0][0]==m[1][1]  && m[1][1]==m[2][2]  &&  m[0][0] != '_') {
            if(m[0][0] == 'X')
                xHat++;
            else
                oHat++;
        }

        //check for other diagonal hat trick
        if(m[0][2] == m[1][1]  && m[1][1] == m[2][0]  &&  m[0][2] != '_') {
            if(m[0][2] == 'X')
                xHat++;
            else
                oHat++;
        }

        printCell(m);

        // status analysis

        if(xHat > 0 && oHat == 0)
            System.out.println("X wins");
        else if(xHat == 0 && oHat > 0)
            System.out.println("O wins");
        else if(emptyCount==0)
            System.out.println("Draw");
        else
            return true;

        return false;

    }

    // print method to display the cells
    public void printCell(char[][] m){
        System.out.println("---------");
        System.out.println(String.format("| %c %c %c |", m[0][0], m[0][1], m[0][2]));
        System.out.println(String.format("| %c %c %c |", m[1][0], m[1][1], m[1][2]));
        System.out.println(String.format("| %c %c %c |", m[2][0], m[2][1], m[2][2]));
        System.out.println("---------");
    }

    public void askUser(char[][] m,char player){

        Scanner scanner = new Scanner(System.in);
        int x = -1, y = -1;
        boolean correctInput = false;
        while (!correctInput) {
            System.out.println("Enter the coordinates:");
            try {
                x = Integer.parseInt(scanner.next());
                y = Integer.parseInt(scanner.next());
                correctInput = true;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }

            if(correctInput){
                if(x < 1 || x > 3 || y < 1 || y > 3){
                    System.out.println("Coordinates should be from 1 to 3!");
                    correctInput = false;
                }else if(m[3-y][x-1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    correctInput = false;
                }else{
                    m[3-y][x-1] = player;
                }
            }
        }
    }
}
