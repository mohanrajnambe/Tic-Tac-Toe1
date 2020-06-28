package tictactoe;
import java.util.*;
public class Main {


    public static void main(String[] args) {

        Board board = new Board();
        int opponent = 0;
        boolean play = true;
        char player = 'X';
        while(play) {
            switch (opponent) {
                case 0:
                    player = 'X';
                    break;
                case 1:
                    player = 'O';
                    break;
            }
            board.askUser(board.m,player);
            play = board.result(board.m);
            opponent ^= 1;
        }


    }





}
