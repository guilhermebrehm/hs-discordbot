package me.Corvus;

/**
 * Created by soulb on 1/5/2016.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CardFinder {

    OkHttpClient client = new OkHttpClient();
    // code request code here
    String getCardInfo(String url) throws IOException {
        Request request = new Request.Builder()
                .header("X-Mashape-Key", "vLksYid0J9mshCMq3vormXNEOu0Up1tQTNQjsnV8wYLAvMkizG")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @SuppressWarnings("unchecked")
    public String GetInfo(String cardName) throws IOException, ParseException {
        System.out.println(cardName);
        Boolean hasFound = false;

        ArrayList<String> searches = new ArrayList<String>();

        Matcher m = Pattern.compile("\\[([^)]+)\\]").matcher(cardName);
        while(m.find()) {
            searches.add(m.group(1));
        }

        ArrayList<String> responses = new ArrayList<>();

        // These code snippets use an open-source library. http://unirest.io/java
        for (String ab : searches) {
            String response = getCardInfo("https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/" + ab);

            responses.add(response);
        }

        JSONParser parser = new JSONParser();
        Object a =  parser.parse(String.valueOf(responses));
        for (String w:responses) {
            System.out.println(w);
        }


        ArrayList<String> infoArray = new ArrayList<String>();

        for (Object o : (JSONArray) a) {
            JSONArray crowd = (JSONArray) o;
            for(Object i: (JSONArray) crowd) {
                JSONObject person = (JSONObject) i;
                if (!(person.get("type").toString().equalsIgnoreCase("Hero") || person.get("type").toString().equalsIgnoreCase("Hero Power"))) {
                    String name = "";
                    String text = "";
                    String health = "";
                    String durability = "";
                    String attack = "";
                    String cost = "";
                    String flavor = "";
                    String race = "";
                    if (person.get("name") != null) {
                        name = person.get("name").toString();
                        infoArray.add("Name: " + name + "\n");
                    }
                    System.out.println(name);
                    if (person.get("attack") != null) {
                        attack = person.get("attack").toString();
                        infoArray.add("Attack: " + attack + "\n");
                    }
                    if (person.get("health") != null) {
                        health = person.get("health").toString();
                        infoArray.add("Health: " + health + "\n");
                    }
                    if (person.get("durability") != null) {
                        durability = person.get("durability").toString();
                        infoArray.add("Durability: " + durability + "\n");
                    }
                    if (person.get("cost") != null) {
                        cost = person.get("cost").toString();
                        infoArray.add("Cost: " + cost + "\n");
                    }
                    if (person.get("text") != null) {
                        text = person.get("text").toString().replaceAll("(<b>|</b>)", "**").replaceAll("(<i>|</i>)", "*").replaceAll("\\$", "");
                        infoArray.add("Text: " + text + "\n");
                    }
                    if (person.get("race") != null) {
                        race = person.get("race").toString();
                        infoArray.add("Tribal: " + race + "\n");
                    }
                    if (person.get("flavor") != null) {
                        flavor = person.get("flavor").toString().replaceAll("(<i>|</i>)", "*");
                        infoArray.add(flavor);
                    }
                    infoArray.add("\n\n");
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (String s : infoArray)
        {
            sb.append(s);
            sb.append("\t");
        }

        System.out.println("\n");

        System.out.println(sb.toString());

    return sb.toString();
    }

}
