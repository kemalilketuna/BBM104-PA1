import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PurchaseReader implements Iterable<String> {
    private String filePath;

    public PurchaseReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private BufferedReader reader;
            private String nextLine;

            {
                try {
                    reader = new BufferedReader(new FileReader(filePath));
                    nextLine = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error opening file: " + e.getMessage());
                }
            }

            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

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

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation not supported.");
            }
        };
    }
}
