import java.util.Arrays;

public class Utils {
    static Integer[] cUInputToGameCord(String cUInput) {
        //calculate A1 to 11
        String cUInputonlyNumbers = "";
        for (int i = 0; i < cUInput.length(); i++) {
            // if (0 = 0) {

            if (cUInput.charAt(i) >= 'A' && cUInput.charAt(i) <= 'Z') {
                cUInputonlyNumbers = cUInputonlyNumbers+ ((int) cUInput.charAt(i) - (int) 'A'+1);
            }
            else
            {
                cUInputonlyNumbers= cUInputonlyNumbers + cUInput.charAt(i);
            }

        }
        //split the string into coordinates
        String[] parts = cUInputonlyNumbers.split(" ");
        String Gamecord1 = parts[0];
        String Gamecord2 = parts[1];


        //return as array, with both coordniates

        Integer[] Gamecord = {Integer.parseInt(Gamecord1), Integer.parseInt(Gamecord2)};



        return Gamecord;
    }
}