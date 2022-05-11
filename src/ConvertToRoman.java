public class ConvertToRoman {
    public static String toRomanNum(int input) {
        String output = "";
        while (input >= 100) {
            output += "C";
            input -= 100;
        }
        while (input >= 90) {
            output += "XC";
            input -= 90;
        }
        while (input >= 50) {
            output += "L";
            input -= 50;
        }
        while (input >= 40) {
            output += "XL";
            input -= 40;
        }
        while (input >= 10) {
            output += "X";
            input -= 10;
        }
        while (input >= 9) {
            output += "IX";
            input -= 9;
        }
        while (input >= 5) {
            output += "V";
            input -= 5;
        }
        while (input >= 4) {
            output += "IV";
            input -= 4;
        }
        while (input >= 1) {
            output += "I";
            input -= 1;
        }
        return output;
    }
}
