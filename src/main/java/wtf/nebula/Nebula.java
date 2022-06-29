package wtf.nebula;

import me.bush.eventbus.bus.EventBus;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Session;
import wtf.nebula.repository.Repositories;
import wtf.nebula.repository.impl.CommandRepository;
import wtf.nebula.repository.impl.FriendRepository;
import wtf.nebula.repository.impl.ModuleRepository;
import wtf.nebula.repository.impl.WaypointRepository;

import java.util.logging.Logger;

/**
 * The main class of the client
 *
 * @author aesthetical
 * @since 06/27/22
 */
public class Nebula {
    public static final String NAME = "Nebula";
    public static final String VERSION = "1.0.0";

    public static final Logger log = Logger.getLogger(NAME);

    // our event bus
    public static final EventBus BUS = new EventBus(log::info);

    public static void init() {
        log.info("Loading " + NAME + " v" + VERSION + "...");

        // repos
        Repositories.add(new ModuleRepository());
        Repositories.add(new CommandRepository());
        Repositories.add(new FriendRepository());
        Repositories.add(new WaypointRepository());

        Minecraft.getMinecraft().session = new Session("Aestheticall", "");

        log.info("Loaded client, henlo!!!!?!?!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Saving repository states...");

            ModuleRepository.get().save();
            FriendRepository.get().save();
            WaypointRepository.get().save();
        }, "Shutdown-Save-Thread"));
    }
}
