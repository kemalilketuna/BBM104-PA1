import java.io.*;
import java.util.*;

/**
 * Provides an iterator over purchase records from a file, where each record is a line in the file.
 */
public class PurchaseReader implements Iterable<String> {
    private String filePath;

    /**
     * Constructs a PurchaseReader to read from a specified file.
     *
     * @param filePath The path to the file containing purchase records.
     */
    public PurchaseReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns an iterator that iterates over the lines of the purchase file.
     *
     * @return An Iterator over the lines of the file.
     */
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private BufferedReader reader;
            private String nextLine;

            // Initializer block to set up the reader and read the first line.
            {
                try {
                    reader = new BufferedReader(new FileReader(filePath));
                    nextLine = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error opening file: " + e.getMessage());
                }
            }

            /**
             * Checks if there is another line to read in the file.
             *
             * @return true if there is another line to read; false otherwise.
             */
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            /**
             * Returns the next line in the file and advances the reader.
             *
             * @return The next line in the file.
             * @throws NoSuchElementException if there are no more lines to read.
             */
            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more lines in the file.");
                }
                String currentLine = nextLine;
                try {
                    nextLine = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error reading file: " + e.getMessage());
                }
                return currentLine;
            }

            /**
             * Remove operation is not supported for this iterator.
             *
             * @throws UnsupportedOperationException if the remove operation is called.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation not supported.");
            }
        };
    }
}
