import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scaner.nextLine().toUpperCase();
        System.out.println("Output:\n" + calc(input));
    }
    public static String calc(String input) throws Exception {
        String[] a = input.split(" ");
        if (a.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }
        if (a.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String num1 = a[0];
        String oper = a[1];
        String num2 = a[2];
        String output = "";
        boolean num1IsRoman = ConvertToArabic.itsRoman(num1);
        boolean num2IsRoman = ConvertToArabic.itsRoman(num2);
        boolean num1IsArabic = ConvertToArabic.itsArabic(num1);
        boolean num2IsArabic = ConvertToArabic.itsArabic(num2);
        if (num1IsArabic & num2IsRoman | num1IsRoman & num2IsArabic) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if (num1IsArabic & num2IsArabic) {
            output = Integer.toString(operation(Integer.parseInt(a[0]), oper, Integer.parseInt(a[2])));
        } else if (num1IsRoman & num2IsRoman) {
            int result = operation(ConvertToArabic.valueOf(a[0]).toInt(), oper, ConvertToArabic.valueOf(a[2]).toInt());
            if (result >= 1) {
                return output = ConvertToRoman.toRomanNum(result);
            } else {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
        } else throw new Exception("В выражении должны участвовать только целые положительные арабские или римские числа");
        return output;
    }
    public static int operation(int num1, String oper, int num2) throws Exception {
        int result;
//        String output;
        switch (oper) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Cтрока не является математической операцией");
        }
        return result;
    }
}