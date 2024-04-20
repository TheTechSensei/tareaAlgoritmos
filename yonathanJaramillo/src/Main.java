import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Procesador procesador = new Procesador();
        String pathToFile = "src/LoR.txt";
        String text = readFile(pathToFile);

        // Convertimos el texto a un array de palabras.
        String[] words = text.split("\\s+(?=[\\p{Punct}]*\\b)");

        List<String> errors = new ArrayList<>();

        // Aplicamos búsqueda binaria para encontrar cada uno de los errores.
        for (int i = 1; i <= 3; i++) {
            int errorIndex = findError(words, procesador, i);
            if (errorIndex != -1) {
                errors.add(words[errorIndex]);
                words[errorIndex] = "";
            }
        }

        // Mostrar los resultados
        System.out.println("Errores encontrados en el texto:");
        for (String error : errors) {
            System.out.println(error);
        }
    }

    private static int findError(String[] words, Procesador procesador, int errorNumber) {
        int start = 0;
        int end = words.length - 1;
        int lastErrorIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int rangeStart = Math.max(0, mid - 5);
            int rangeEnd = Math.min(words.length - 1, mid + 5);

            for (int i = rangeStart; i <= rangeEnd; i++) {
                boolean hasError = false;
                if (errorNumber == 1) hasError = procesador.procesado1(words[i]);
                else if (errorNumber == 2) hasError = procesador.procesado2(words[i]);
                else if (errorNumber == 3) hasError = procesador.procesado3(words[i]);

                System.out.printf("Revisando: %s - %s\n", words[i], hasError ? "❌" : "✅");

                if (hasError) {
                    lastErrorIndex = i;
                    break;
                }
            }

            // Ajustamos el rango de búsqueda
            if (lastErrorIndex != -1) {
                if (rangeEnd == mid + 5) {
                    start = rangeEnd + 1;
                } else {
                    end = rangeStart - 1;
                }
            } else {
                if (start == mid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return lastErrorIndex;
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return content.toString().trim();
    }
}
