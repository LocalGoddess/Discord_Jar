# Discord_Jar

A small robust Discord API wrapper

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


# Currently in the Works

| Thing         | Complete % |
|---------------|------------|
| Guild         | 18%        |


# Examples

<b>Creating a Bot</b>

```java
import me.hammer86gn.discordjar.DJAR;

public class Main() {
    
    public static final String YOUR_TOKEN = "YOURTOKEN";
    
    public static void main(String[] args) {
        DJAR djar = new DJAR();
        djar.build(YOUR_TOKEN);
    }
}
```
