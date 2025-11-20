public class ConvertString {
    public static void main(String[] args) {
        String s = "Hello Swikriti";

        try {
            int num = Integer.parseInt(s);
            System.out.println("Converted: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert string to integer.");
        }
    }
}
