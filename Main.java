import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BalancedBST tree = new BalancedBST();
        Scanner scanner = new Scanner(System.in);
        int[] data = {1, 2, 3, 4, 5, 6, 7};

        boolean running = true;

        while (running) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                    	tree.root = tree.sortedArrayToBST(data, 0, data.length - 1);
                        System.out.println("Create Binary Search Tree: " + Arrays.toString(data));
                        break;
                    case 2:
                    	System.out.println("Add a node: ");
                    	int valueToInsert = scanner.nextInt();
                        tree.insert(valueToInsert);
                        break;
                    case 3:
                    	System.out.println("Delete a node: ");
                    	int valueToDelete = scanner.nextInt();
                    	tree.delete(valueToDelete);
                        break;
                    case 4:
                    	System.out.print("Pre-order traversal of the balanced BST: ");
                    	tree.printPreOrder(tree.root);
                        break;
                    case 5:
                    	System.out.print("In-order traversal of the balanced BST: ");
                    	tree.printInOrder(tree.root);
                        break;
                    case 6:
                    	System.out.print("Post-order traversal of the balanced BST: ");
                    	tree.printPostOrder(tree.root);
                        break;
                    case 7:
                        running = false;
                        System.out.println("Exiting Bynary Tree. Goodbye! 👋");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear buffer
            }
        }
        scanner.close();
    }
	
	private static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Create a binary search tree");
        System.out.println("2. Add a node");
        System.out.println("3. Delete a node");
        System.out.println("4. Print nodes by InOrder");
        System.out.println("5. Print nodes by PreOrder");
        System.out.println("6. Print nodes by PostOrder");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}
