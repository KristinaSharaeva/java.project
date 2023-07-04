
import java.util.PriorityQueue;
import java.util.Random;

class Toy {
    private String toyId;
    private String toyName;
    private int frequency;

    public Toy(String toyId, String toyName, int frequency) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.frequency = frequency;
    }

    public String getToyId() {
        return this.toyId;
    }

    public String getToyName() {
        return this.toyName;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "ID: " + toyId + ", Name: " + toyName + ", Frequency: " + frequency + "%";
    }
}

class ToyContainer {
    private PriorityQueue<Toy> toys;
    private Random random;

    public ToyContainer() {
        this.toys = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getFrequency(), t1.getFrequency()));
        this.random = new Random();
    }

    public void put(Toy toy) {
        toys.offer(toy);
    }

    public Toy get() {
        if (toys.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(toys.size());
        Toy selectedToy = null;

        int currentIndex = 0;
        PriorityQueue<Toy> tempQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getFrequency(), t1.getFrequency()));

        while (!toys.isEmpty()) {
            Toy toy = toys.poll();
            if (currentIndex == randomIndex) {
                selectedToy = toy;
            } else {
                tempQueue.offer(toy);
            }
            currentIndex++;
        }

        toys = tempQueue;
        return selectedToy;
    }
}

