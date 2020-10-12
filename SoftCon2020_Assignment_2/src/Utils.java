import java.util.Arrays;

public class Utils {
    static Integer[] cUInputToGameCord(String cUInput) {
        //calculate Input "A1 B1" to [0, 1, 1, 1]

        Integer[] Gamecord = new Integer[4];
        Gamecord[0] = cUInput.charAt(0) - (int) 'A';
        Gamecord[1] = cUInput.charAt(1) - 48;
        Gamecord[2] = cUInput.charAt(3) - (int) 'A';
        Gamecord[3] = cUInput.charAt(4) - 48;

        return Gamecord;
    }


}