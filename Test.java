import java.util.Random;
class Test{
    public static void main(String[] args) {
        Random generator = new Random();
        int value = generator.nextInt() % (50);
        System.out.println(value);
    }
}