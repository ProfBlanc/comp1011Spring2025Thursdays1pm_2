package com.example.demo5;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.*;

public class PlayerAPI {
    private static final String BASE_URL = "https://api.balldontlie.io/v1/players";

    private static final String API_KEY = "6c49f0d5-395d-4b87-998e-9b0524aa8891";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public List<Player> fetchAll(int maxPlayers) throws IOException, InterruptedException {
        List<Player> players = new ArrayList<>();
        int perPage = 100;
        int page = 1;

        while (players.size() < maxPlayers) {
            String url = BASE_URL + "?per_page=" + perPage + "&page=" + page;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", API_KEY)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Failed to fetch players: " + response.statusCode() + " - " + response.body());
            }

            JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray data = root.getAsJsonArray("data");

            for (JsonElement element : data) {


                Player player = new Gson().fromJson(element, Player.class);
                players.add(player);
                if (players.size() >= maxPlayers) break;
            }

            if (data.size() < perPage) break; // No more pages
            page++;
        }

        return players;
    }
}
