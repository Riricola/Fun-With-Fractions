public class CommandLineArguments {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide arguments enclosed in quotation marks.");
            return;
        }

        // Combine the command line arguments into a single string
        String input = String.join(" ", args);

        // Split the input string based on quotation marks
        String[] parts = input.split("\"");

        // Process the separated parts
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            if (!part.isEmpty()) {
                System.out.println("Argument " + (i + 1) + ": " + part);
            }
        }
    }
}
