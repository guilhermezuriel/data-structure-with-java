import bag.BagRA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/numbers.txt"));
        BagRA<Integer> bag = new BagRA<Integer>();

        while (scanner.hasNextLine()) {
            Integer number = Integer.parseInt(scanner.nextLine());
            bag.add(number);
        }
        scanner.close();
        System.out.printf("Tamanho da bag: %d\n", bag.size());

        AtomicInteger soma = new AtomicInteger(0);
        bag.iterator().forEachRemaining(soma::addAndGet);
        double media = (double) soma.get() / bag.size();

        System.out.printf("Soma dos números da bag: %d\n", soma.get());
        System.out.printf("Media: %.2f", media);
    }
}