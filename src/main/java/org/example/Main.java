package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int originalNumber = number;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }

        return originalNumber == reverse;
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) {
            return  false;
        }

        int sum = 0;
        for (int i=1; i<number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return  "Invalid Value";
        }
        if (number == 0) {
            return "Zero";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        StringBuilder result = new StringBuilder(); // Metinleri birleştirmek için
        int reversedNumber = reverseNumber(number);
        int originalDigitCount = countDigits(number);
        int reversedDigitCount = countDigits(reversedNumber);

        for (int i=0; i<reversedDigitCount; i++) { // Ters çevrilmiş sayının rakamları kelimelere çevirme
            int digit = reversedNumber % 10;
            result.append(words[digit]).append(" "); // eklenen veriyi stringe dönüştürerek sonuna eklemek için
            reversedNumber /= 10;
        }
        for (int i = reversedDigitCount; i<originalDigitCount; i++) { // Eksik sıfırları ekleme
            result.append("Zero").append(" ");
        }
        return result.toString().trim();
    }
    private static int reverseNumber(int number) { // sayıyı ters çevirme methodu
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }

    private static int countDigits(int number) { //Basamak sayısı hesabı
        int count = 0;
        if (number == 0) {
            return 1;
        }
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}


