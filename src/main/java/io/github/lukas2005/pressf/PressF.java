package io.github.lukas2005.pressf;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static io.github.lukas2005.pressf.PressF.MODID;

@Mod(modid = MODID, serverSideOnly = true, useMetadata = true)
public class PressF {

    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "pressf";

    @NetworkCheckHandler
    public boolean checkModLists(Map<String,String> modList, Side side)
    {
        return true;
    }

}
