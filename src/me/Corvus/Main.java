package me.Corvus;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.DiscordBuilder;
import me.itsghost.jdiscord.exception.BadUsernamePasswordException;
import me.itsghost.jdiscord.exception.DiscordFailedToConnectException;
import me.itsghost.jdiscord.exception.NoLoginDetailsException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        System.out.println(">> I am running in: " + System.getProperty("user.dir"));
        SettingsGetter SG = new SettingsGetter();
        ArrayList<String> settings = new ArrayList<String>();
        settings = SG.GetSettings();

        DiscordAPI api = new DiscordBuilder(settings.get(0), settings.get(2)).build();

        try {
            api.login();
        } catch (NoLoginDetailsException e) {
            e.printStackTrace();
        } catch (BadUsernamePasswordException e) {
            e.printStackTrace();
        } catch (DiscordFailedToConnectException e) {
            e.printStackTrace();
        }

        api.getEventManager().registerListener(new ExampleListener(api)); //Register listener

    }
}
