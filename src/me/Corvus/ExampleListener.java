package me.Corvus;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.event.EventListener;
import me.itsghost.jdiscord.events.UserChatEvent;
import me.itsghost.jdiscord.message.MessageBuilder;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by soulb on 1/5/2016.
 */
public class ExampleListener implements EventListener {
    DiscordAPI api;
    CardFinder cf = new CardFinder();
    public ExampleListener(DiscordAPI api){
        this.api = api;
    }
    public void userChat(UserChatEvent e) throws IOException, ParseException {

        SettingsGetter SG = new SettingsGetter();
        Substituter S = new Substituter();
        ArrayList<String> settings = new ArrayList<String>();
        settings = SG.GetSettings();
        String substituted;
        String matched = "";

        Matcher m = Pattern.compile("\\[([^)]+)\\]").matcher(e.getMsg().toString());
        while(m.find()) {
            matched = m.group(1);
        }

        if(!e.getUser().toString().equalsIgnoreCase(settings.get(1))) {
            substituted = S.Substitute(matched);
            if(!substituted.isEmpty()){
                e.getGroup().sendMessage(new MessageBuilder()
                        .addString(cf.GetInfo("[" + substituted + "]"))
                        .build(api));
            }else{
                if(substituted.isEmpty()){
                    System.out.println(cf.GetInfo(e.getMsg().toString()));
                    e.getGroup().sendMessage(new MessageBuilder()
                            .addString(cf.GetInfo(e.getMsg().toString()))
                            .build(api));
                }
            }
        }
    }
}
