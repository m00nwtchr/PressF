package io.github.lukas2005.pressf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class EventHandler {

    public static long deathMilis = 0;

    public static ArrayList<EntityPlayer> playersWhoPaidRespects = new ArrayList<>();
    public static MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent e) {
        if (e.getEntityLiving() instanceof EntityPlayer && deathMilis - System.currentTimeMillis() >= ModConfig.DEATH_COOLDOWN*60000) {
            deathMilis = System.currentTimeMillis();
            playersWhoPaidRespects.clear();

           // server.getPlayerList().sendMessage(new TextComponentString(ModConfig.SERVER_MESSAGE));
        }
    }

    @SubscribeEvent
    public static void onChat(ServerChatEvent e) {
        if (e.getMessage().toLowerCase().equals(ModConfig.MESSAGE.toLowerCase()) && deathMilis - System.currentTimeMillis() <= ModConfig.MINUTES_AFTER_DEATH*60000 && !playersWhoPaidRespects.contains(e.getPlayer())) {

            server.commandManager.executeCommand(server, String.format(ModConfig.COMMAND, e.getUsername()));

            playersWhoPaidRespects.add(e.getPlayer());
        }
    }

}