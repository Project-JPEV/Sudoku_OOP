
/*public class TestHello {
    public static void main(String[] args) {
        String str = "004-034556-987/33-5421/879";
        int sum = 0;

        for (String num : str.split("-|/")) {
            sum += num.isEmpty() ? 0 : Integer.parseInt(num);
        }

        System.out.println("Sum of numbers: " + sum);
    }
} 

import java.util.ArrayList;
import java.util.Scanner;

public class TestHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println("Initial list: " + list);

        list.removeIf(num -> num % 2 == 0);

        System.out.println("Final list: " + list);

        scanner.close();
    }
} 

import java.util.Scanner;

public class TestHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of purchases: ");
        int numPurchases = scanner.nextInt();

        int totalProfit = 0;
        int totalLoss = 0;

        for (int i = 0; i < numPurchases; i++) {
            System.out.print("Enter cost price and selling price for purchase " + (i + 1) + ": ");
            int costPrice = scanner.nextInt();
            int sellingPrice = scanner.nextInt();

            int profitOrLoss = sellingPrice - costPrice;

            if (profitOrLoss > 0) {
                totalProfit += profitOrLoss;
            } else {
                totalLoss += -profitOrLoss;
            }
        }

        System.out.println("Total profit: " + totalProfit);
        System.out.println("Total loss: " + totalLoss);


        scanner.close();
    }
} 

import java.util.Scanner;

public class TestHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Input the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Input the third number: ");
        int num3 = scanner.nextInt();

        int leftmostDigit1 = num1 / (int) Math.pow(10, (int) Math.log10(num1));
        int leftmostDigit2 = num2 / (int) Math.pow(10, (int) Math.log10(num2));
        int leftmostDigit3 = num3 / (int) Math.pow(10, (int) Math.log10(num3));

        boolean result = leftmostDigit1 == leftmostDigit2 || leftmostDigit1 == leftmostDigit3 || leftmostDigit2 == leftmostDigit3;
        System.out.println("The result is: " + result);

        scanner.close();
    }
}

import java.util.Scanner;

public class TestHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();

        String[] names = new String[n];
        String[] surnames = new String[n];
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name and surname of person " + (i + 1) + ": ");
            names[i] = scanner.next();
            surnames[i] = scanner.next();

            System.out.print("Enter the age of person " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        int youngestIndex = 0;
        int oldestIndex = 0;

        for (int i = 1; i < n; i++) {
            if (ages[i] < ages[youngestIndex]) youngestIndex = i;
            if (ages[i] > ages[oldestIndex]) oldestIndex = i;
        }

        System.out.println("Youngest person: " + names[youngestIndex] + " " + surnames[youngestIndex] + ", age " + ages[youngestIndex]);
        System.out.println("Oldest person: " + names[oldestIndex] + " " + surnames[oldestIndex] + ", age " + ages[oldestIndex]);

scanner.close();
    }
}*/

import java.util.Scanner;

public class TestHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.print("Enter a letter: ");
        char letter = scanner.next().charAt(0);

        String[] words = str.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (word.endsWith(String.valueOf(letter))) {
                count++;
            }
        }

        System.out.println("Total number of words ending with '" + letter + "': " + count);

        scanner.close();
    }
}