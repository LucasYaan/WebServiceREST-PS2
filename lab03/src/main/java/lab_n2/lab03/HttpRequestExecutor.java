package lab_n2.lab03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HttpRequestExecutor implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... args) throws Exception {
        Path dir = Paths.get("src/main/resources/http");

        Files.list(dir)
                .filter(path -> path.toString().endsWith(".http"))
                .forEach(this::processarArquivo);
    }

    private void processarArquivo(Path path) {
        try {
            String conteudo = Files.readString(path);

            // divide o arquivo em blocos pelo "###"
            String[] blocos = conteudo.split("###");

            for (String bloco : blocos) {
                processarBloco(bloco.trim());
            }

        } catch (Exception e) {
            System.err.println("Erro executando " + path.getFileName() + ": " + e);
        }
    }

    private void processarBloco(String bloco) throws Exception {
        if (bloco.isBlank()) return;

        List<String> linhas = bloco.lines().toList();

        String primeira = linhas.get(0).trim(); // ex: POST http://localhost...

        String[] partes = primeira.split(" ");
        String metodo = partes[0];
        String url = partes[1];

        // lê headers
        HttpHeaders headers = new HttpHeaders();

        int i = 1;
        for (; i < linhas.size(); i++) {
            String linha = linhas.get(i).trim();
            if (linha.isEmpty()) break; // body começa após linha em branco

            if (linha.startsWith("Content-Type:")) {
                String tipo = linha.substring("Content-Type:".length()).trim();
                headers.set("Content-Type", tipo);
            }
        }

        // lê body
        String body = "";
        if (i < linhas.size() - 1) {
            body = linhas.subList(i + 1, linhas.size())
                    .stream()
                    .reduce("", (a, b) -> a + b + "\n")
                    .trim();
        }

        // prepara entidade
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // envia request
        switch (metodo) {
            case "POST" -> restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            case "PUT" -> restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
            case "GET" -> restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            case "DELETE" -> restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
            default -> throw new IllegalArgumentException("Método não suportado: " + metodo);
        }

        System.out.println("✔ Executado: " + metodo + " " + url);
    }
}