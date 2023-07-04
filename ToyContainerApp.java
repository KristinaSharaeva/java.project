import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


    public class ToyContainerApp {
    public static void main(String[] args) {
        ToyContainer container = new ToyContainer();

        // Add elements to container
        container.put(new Toy("1", "Teddy Bear", 70));
        container.put(new Toy("2", "Barbie Doll", 90));
        container.put(new Toy("3", "Lego Set", 30));

        // Call get method and write results to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt"))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = container.get();
                if (toy != null) {
                    writer.println("Operation " + (i + 1) + ": Toy ID: " + toy.getToyId());
                } else {
                    writer.println("Operation " + (i + 1) + ": No toys in the container.");
                }
                container.put(toy); // Put the toy back into the container
            }
            writer.flush();
            System.out.println("Results written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

