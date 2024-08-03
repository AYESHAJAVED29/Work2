
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class Main10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Problem 1: Check for palindrome
        System.out.println("Enter an input string:");
        String str = input.nextLine();

        boolean isPalindrome = true;
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("is palindrome");
        } else {
            System.out.println("not palindrome");
        }

        // Problem 2: Validate email
        System.out.println("Enter an email address to validate: ");
        String email = input.nextLine();

        // Regular expression for UMT faculty and student email IDs
        String UMT_EMAIL_REGEX = "^[a-zA-Z]+\\d*@gmail.com$";
        Pattern pattern = Pattern.compile(UMT_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println(email + " is a valid UMT email address.");
        } else {
            System.out.println(email + " is not a valid UMT email address.");
        }

        // Problem 3: Format current date
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        String formattedDate = today.format(formatter);

        System.out.println("Before: " + today);
        System.out.println("After: " + formattedDate);

        // Problem 4: Add 30 days to a user-provided date
        System.out.println("Enter a date in dd-MM-yyyy format (e.g., 24-07-2024): ");
        String str1 = input.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the input date string to LocalDate
        LocalDate date = LocalDate.parse(str1, dateFormatter);

        // Add 30 days to the date
        date = date.plusDays(30);

        // Format the new date
        String formattedDate1 = date.format(dateFormatter);
        System.out.println("New date after adding 30 days: " + formattedDate1);

        // Problem 5: Convert number to Roman numerals
        System.out.println("Enter a number to convert to Roman numerals:");
        String numberString = input.nextLine();
        int number = Integer.parseInt(numberString);

        // Define Roman numeral symbols and their corresponding values
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] romanValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String romanNumeral = "";  // Initialize the result string

        // Convert the integer to Roman numeral
        for (int i = 0; i < romanValues.length; i++) {
            while (number >= romanValues[i]) {
                romanNumeral += romanSymbols[i];  // Append Roman numeral symbol to result
                number -= romanValues[i];    // Subtract the value from the number
            }
        }

        // Print the Roman numeral
        System.out.println("Roman numeral = " + romanNumeral);

        // Problem 6: Validate brackets (updated)
        System.out.println("Enter your special character..!");
        String userString = input.nextLine();
        if (userString.equals("()") || userString.equals("{}") || userString.equals("[]") ||
                userString.equals("(){}") || userString.equals("{}[]") || userString.equals("(){}[]")) {
            System.out.println("true..!");
        } else {
            System.out.println("false");
        }

        // Problem 7: Find longest common prefix
        System.out.println("Enter an array of strings separated by commas (e.g., dog,racecar,car):");
        String inputString = input.nextLine();
        String[] strArr = inputString.split(",");

        if (strArr.length == 0) {
            System.out.println("string is empty");
        } else if (strArr.length == 1) {
            System.out.println(strArr[0]);
        } else {
            String firstStr = strArr[0];
            for (int i = 1; i < strArr.length; i++) {
                String currStr = strArr[i];
                int j = 0;
                while (j < currStr.length() && j < firstStr.length() &&
                        currStr.charAt(j) == firstStr.charAt(j)) {
                    j++;
                }
                if (j == 0) {
                    System.out.println("No common prefix");
                    break;
                }
                firstStr = firstStr.substring(0, j);
            }
            System.out.println("Longest common prefix: " + firstStr);
        }

        // Problem 8: Remove duplicate letters
        System.out.println("Enter a string to remove duplicate letters:");
        String str2 = input.nextLine();
        String newStr = "";
        char[] arr = str2.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            // Duplicate not appear
            if (i == j) {
                newStr += arr[i];
            }
        }
        char[] arr1 = newStr.toCharArray();
        Arrays.sort(arr1);
        newStr = String.valueOf(arr1);
        System.out.println("String with duplicates removed and sorted: " + newStr);

        input.close(); // Close the scanner
    }
}





   
