HearthBot
===================


<sup>awesome</sup> [Discord](https://discordapp.com/) _Chatbot_. Gets card details for [HearthStone](http://us.battle.net/hearthstone/en/) cards.  
Uses [JDiscord](https://github.com/nerd/jDiscord) and data from [Hearthstone API](http://hearthstoneapi.com/).

#### Example interaction
![Example Interaction](https://raw.githubusercontent.com/HolyThunder/HSDiscordCardBot/master/example.png)

-----------

## Settting it up

 * Download the latest release
 * Unpack it somewhere
 * edit the ```settings.json``` file as described below
 * **_[optional]_** edit the ```substitutions.json``` file as described below
 * run it  
 i.e.

#### The ```settings.json``` file

should look like:
>{  
>  "BotAccountEmail": "**YOUR BOTACCOUNT EMAIL**",  
>  "BotAccountUsername": "**YOUR BOTACCOUNT USERNAME**",  
>  "BotAccountPassword": "**YOUR BOTACCOUNT PASSWORD**"  
>}

where ```YOUR BOT ACCOUNT EMAIL```, ```YOUR BOT ACCOUNT USERNAME``` and ```YOUR BOT ACCOUNT PASSWORD``` should be your actual bot's information.


#### [OPTIONAL] The ```substitutions.json``` file

is a file that allows you to set up alias' for card names. If you want ```[AoL]``` to bring up ```Ancient of Lore``` and ```[LoH]``` to bring up ```Lay on Hands``` your substitutions file should look like:

```json
[  
  {  
    "input": "AoL",  
    "output": "Ancient of Lore"  
  },
  {
    "input": "LoH",
    "output": "Lay on Hands"
  }
]
```

_(a preset alias file is included)_

### Running it

After both files are set up, all you have to do is run the .jar file. Whether you're on windows, mac or linux, all you have to do is open a terminal, navigate to the directory where all 3 files are, and type

>  java -jar HSChatBot.jar

And you're good to go! Remember to log your bot into your server and it'll reply to messages with card names with the card information!

Customize it by logging into it's account and changing it's avatar!
