package de.mayrhofer.pluginapr.timer;

import de.mayrhofer.pluginapr.APRplugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class timerAPR {
//create variables if timer is running and the time
    private boolean running; //true or false
    private int time;

    //constructor
    public timerAPR(boolean running, int time) {
        this.running = running;
        this.time = time;

        run();
    }

    //getter and setter
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public void showTimer(){
        //shows every player the timer in blue and bold
        for(Player player : Bukkit.getOnlinePlayers()){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.BLUE.toString() + ChatColor.BOLD + getTime()));
        }
    }

    public void run(){
        new BukkitRunnable() {
            @Override
            public void run() {

                showTimer();

                if(!isRunning()){
                    return;
                }
                //update timer to +1
                setTime(getTime()+1);
            }
        }.runTaskTimer(APRplugin.getInstance(), 20, 20);
    }
}
