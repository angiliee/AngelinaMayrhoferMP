package de.mayrhofer.pluginapr;


import de.mayrhofer.pluginapr.timer.timerAPR;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;


public final class APRplugin extends JavaPlugin  {

    private static APRplugin instance;
    private timerAPR timer;
    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static APRplugin getInstance() {
        return instance;
    }
}
