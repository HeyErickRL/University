
package all;
/*
Esta clase se encarga de leer el archivo de texto y proporcionar el contenido a otras clases para su procesamiento.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class DocumentProcessor {
    private String content;

    public DocumentProcessor(String fileName) {
        content = readFile(fileName);
    }

    public String getContent() {
        return content;
    }

    private String readFile(String fileName) {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            contentBuilder.append(line).append(" "); // Agrega un espacio entre líneas
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return contentBuilder.toString();
}

}

