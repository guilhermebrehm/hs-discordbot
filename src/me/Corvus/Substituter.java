package me.Corvus;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by soulb on 1/10/2016.
 */
public class Substituter {
    public String Substitute(String input) {
        String output = "";

        JSONParser parser = new JSONParser();
        JSONArray a = null;

        String substitutionsLocal = System.getProperty("user.dir") + "/substitutions.json";

        try {
            a = (JSONArray) parser.parse(new FileReader(substitutionsLocal));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Where am I?! (check substitutions)");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Where am I?! (check substitutions)");
        }

        for (Object o : (JSONArray) a) {
            JSONObject person = (JSONObject) o;
            if(person.get("input").toString().equalsIgnoreCase(input)){
                output = person.get("output").toString();
            }

        }

        return output;
    }
}
