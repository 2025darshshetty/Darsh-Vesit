import java.util.Scanner;

public class SortingMenu {

    // Selection Sort: repeatedly place the smallest element
    // at the beginning of the unsorted part.
    static void selectionSort(int[] marks) {
        for (int i = 0; i < marks.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] < marks[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = marks[i];
            marks[i] = marks[minIndex];
            marks[minIndex] = temp;
        }
    }

    // Insertion Sort: insert each element into its correct
    // position in the already sorted part.
    static void insertionSort(int[] marks) {
        for (int i = 1; i < marks.length; i++) {
            int key = marks[i];
            int j = i - 1;

            while (j >= 0 && marks[j] > key) {
                marks[j + 1] = marks[j];
                j--;
            }

            marks[j + 1] = key;
        }
    }

    static void display(int[] marks) {
        System.out.print("Sorted marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        int[] marks = new int[n];

        System.out.println("Enter marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\\n--- SORTING MENU ---");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Display Original Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    selectionSort(marks);
                    System.out.println("Marks sorted using Selection Sort.");
                    display(marks);
                    break;

                case 2:
                    insertionSort(marks);
                    System.out.println("Marks sorted using Insertion Sort.");
                    display(marks);
                    break;

                case 3:
                    System.out.print("Current marks: ");
                    for (int mark : marks) {
                        System.out.print(mark + " ");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
