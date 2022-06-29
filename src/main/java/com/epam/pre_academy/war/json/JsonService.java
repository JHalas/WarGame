package com.epam.pre_academy.war.json;

import com.epam.pre_academy.war.*;
import com.epam.pre_academy.war.output.Output;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jakub Hałas
 */


public class JsonService implements Parser , Output {

    Path scenariooPath;
    String json;
    Scenario scenario;


    public JsonService(Path scenariooPath , Scenario scenario) {
        this.scenariooPath = scenariooPath;
        this.scenario = scenario;
    }

    @Override
    public Players parse() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(scenariooPath.toString()));) {


            while (bufferedReader.ready()) {
                json = bufferedReader.lines().collect(Collectors.joining());
            }
            if (!JsonUtils.isJSONValid(json)) {
                throw new JsonSyntaxException("Not valid JSON");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage() +" : " +  scenario.getScenarioName(scenariooPath.getFileName()) +"\n" +separator );
            return null;
        }


        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(Players.class, new PlayerDeserializer());


        return gsonBuilder.create().fromJson(json, Players.class);
    }

    static class PlayerDeserializer implements JsonDeserializer<Players> {


        public Players deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < jsonArray.size() ; i++) {
                Deque<Card> cards = new LinkedList<>() {
                };
                jsonElement = jsonArray.get(i);
                JsonArray jsonArrayInner = jsonElement.getAsJsonArray();
                for (int j = 0; j < jsonArrayInner.size(); j++) {
                    cards.addLast(new Card(jsonArrayInner.get(j).getAsInt()));
                }
                players.add(new Player("Player" + (i + 1), cards));


            }
            return new Players(players);

        }
    }

}
