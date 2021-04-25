# Discord_Jar


##  I Moved This Project To https://github.com/Hammer86gn/Discord.jar

A small robust Discord API wrapper

**Disclaimer: THIS IS NOT FINISHED AND SHOULD NOT BE USED IN ITS CURRENT STATE**

# Current Features

*Yes I know it's short*

*Status Key*
- Perfect  | no changes need perfect as is
- Passable | Works fine as it is
- Working  | Bear minimally working
- Bugged | Needs minor fixing
- Broken | Needs major fixing
- Rework | Needs a major rework to be fixed


| Feature                                               | Status   |
|-------------------------------------------------------|----------|
| Connect Application to the Discord Websockets/gateway | Passable |
| Intents                                               | Passable |
| Events                                                | Passable |


# Currently in the Works

| Thing         | Complete % | Extra Notes                                                                 |
|---------------|------------|-----------------------------------------------------------------------------|
| Guild         | 18%        | progress suspended                                                          |
| Message       | 75%        | Rewrite on the related message events and adding more to the message object |


# Examples

### Creating a Bot

```java
import me.hammer86gn.discordjar.DJAR;

public class Main {
    
    public static final String YOUR_TOKEN = "YOURTOKEN";
    
    public static void main(String[] args) {
        DJAR djar = new DJAR();
        djar.build(YOUR_TOKEN);
    }
}
```


### Listening to Events
```java
public class ExampleListener extends EventListener {

    @Override
    public void onMessageSentEvent(MessageSentEvent event) {
        Message message = event.getMessage();
        System.out.println(message.getMessageContent());
        
    }
}
```
make sure you register it in your main

```java
public class Main {
    
    public static final String YOUR_TOKEN = "YOURTOKEN";
    
    public static void main(String[] args) {
        DJAR djar = new DJAR();

        djar.registerEvent(new ExampleListener());
        
        djar.build(YOUR_TOKEN);
    }
}
```
