package br.com.weslley_evantelista.literalura.util;

import org.springframework.stereotype.Component;

@Component
public class GutendexClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "http://gutendex.com/books/";

    public JsonNode fetchBooksByTitle(String title) {
        String url = API_URL + "?search=" + title;
        return restTemplate.getForObject(url, JsonNode.class);
    }
}
