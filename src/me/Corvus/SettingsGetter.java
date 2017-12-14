package me.Corvus;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by soulb on 1/6/2016.
 */
public class SettingsGetter {

    public ArrayList<String> GetSettings() {

        ArrayList<String> settings = new ArrayList<String>();

        JSONParser parser = new JSONParser();
        JSONObject a = null;

        String settingsLocal = System.getProperty("user.dir") + "/settings.json";

        try {
            a = (JSONObject) parser.parse(new FileReader(settingsLocal));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Where am I?! (check settings)");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Where am I?! (check settings)");
        }

            JSONObject setting = (JSONObject) a;
            String email = "";
            String username = "";
            String password = "";
            if (setting.get("BotAccountEmail") != null) {
                email = setting.get("BotAccountEmail").toString();
            }
            if (setting.get("BotAccountUsername") != null) {
                username = setting.get("BotAccountUsername").toString();
            }
            if (setting.get("BotAccountPassword") != null) {
                password = setting.get("BotAccountPassword").toString();
            }

            if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                settings.add(email);
                settings.add(username);
                settings.add(password);
            }else{
                System.out.println("BotAccountEmail, BotAccountUsername or BotAccoutPassword is empty!");
            }

    return settings;}
}
