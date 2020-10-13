public class Utils {
    static Integer[] cUInputToGameCord(String cUInput) {
        //tansform Input "A1 B1" to [0, 1, 1, 1]
        Integer[] Gamecord = new Integer[4];
        //Check if length is correct
        if (cUInput.length()!= 5){
            throw new IllegalArgumentException("Input has not correct length! Example: 'A1 B2'");
        }
        Gamecord[0] = cUInput.charAt(0) - (int) 'A';
        Gamecord[1] = cUInput.charAt(1) - 48;
        Gamecord[2] = cUInput.charAt(3) - (int) 'A';
        Gamecord[3] = cUInput.charAt(4) - 48;
        return Gamecord;
    }
    static boolean validMove(Integer [] Gamecoord, String sN, Integer len) {
        //function is not tested
        //check if horizontal or vertical -> no diagonal possible
    if (Gamecoord[0]!=Gamecoord[2] && Gamecoord[1] != Gamecoord[3]) {
        throw new IllegalArgumentException("No diagonal ships allowed");
         }
        //check if out of field
    if (Gamecoord[0]<0 || Gamecoord[1]<0 ||Gamecoord[2]<0 ||Gamecoord[3]<0 ||Gamecoord[0]>10 ||Gamecoord[1]>10 ||Gamecoord[2]>10 ||Gamecoord[3]>10 ){
        throw new IllegalArgumentException("Out of Gameboard");}
        //check if length of ship is valid
    if (Math.abs(Gamecoord[0]-Gamecoord[2]) != (len-1) && Math.abs(Gamecoord[1]-Gamecoord[3]) != (len-1)) {
        throw new IllegalArgumentException("Invalid length of Ship");
    }
    else return true;
    }
}