package io.github.lukas2005.pressf;

import net.minecraftforge.common.config.Config;

@Config(modid = PressF.MODID)
public class ModConfig {

    @Config.Name("minutesAfterDeath")
    @Config.Comment("Amount of minutes after death the players have to send the message")
    public static int MINUTES_AFTER_DEATH = 5;

    @Config.Name("deathCooldown")
    @Config.Comment("Amount of minutes until another death can trigger")
    public static int DEATH_COOLDOWN = 5;

    @Config.Name("message")
    @Config.Comment("The message the players have to send, non-case-sensitive")
    public static String MESSAGE = "F";

    @Config.Name("serverMessage")
    @Config.Comment("The message the server sends when you can pay respects")
    public static String SERVER_MESSAGE = "Press F to pay respects";

    @Config.Name("command")
    @Config.Comment("The command to be executed, use %s in place of username")
    public static String COMMAND = "/give %s minecraft:diamond 32";
}
