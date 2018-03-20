import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        bt.initBinaryTree(new BufferedReader(new FileReader("data.dat")));

        bt.add(20);

        bt.add(30);

        System.out.println(bt);

        bt.delete(25);

        System.out.println(bt);

    }
}
