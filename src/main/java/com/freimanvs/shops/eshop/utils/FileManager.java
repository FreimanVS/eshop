package com.freimanvs.shops.eshop.utils;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager<T> {
    private static final Gson gson = new Gson();
    public List<T> fromJsonArrayToList(String jsonArray, Class<T> clazz) {
        JsonParser parser = new JsonParser();
        JsonArray thisJsonArray = (JsonArray) parser.parse(jsonArray);
        List<T> list = new ArrayList<>();
        for (JsonElement jsonElement : thisJsonArray) {
            JsonObject object = jsonElement.getAsJsonObject();
            list.add(gson.fromJson(object, clazz));
        }
        return list;
    }

    public String get(InputStream is) {
        StringBuilder json = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(is)) {
            while (isr.ready()) {
                json.append((char)isr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public String getFromResource(String path) {
        return get(FileManager.class.getResourceAsStream(path));
    }

    public List<T> fromJsonArrayResourceToList(String path, Class<T> clazz) {
        return fromJsonArrayToList(getFromResource(path), clazz);
    }
}
