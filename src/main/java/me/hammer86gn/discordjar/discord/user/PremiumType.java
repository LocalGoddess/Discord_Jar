package me.hammer86gn.discordjar.discord.user;

public enum PremiumType {
    NONE(0),
    NITRO_CLASSIC(1),
    NITRO_NEW(2);

    private final int value;

    PremiumType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PremiumType getPremiumType(int value) {
        switch (value) {
            case 0:
                return PremiumType.NONE;
            case 1:
                return PremiumType.NITRO_CLASSIC;
            case 2:
                return PremiumType.NITRO_NEW;
        }
        return null;
    }

}
