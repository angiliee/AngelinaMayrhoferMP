package de.mayrhofer.pluginapr;

import de.mayrhofer.pluginapr.timer.timerAPR;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;



public class PlayerMovementListener implements Listener {
@EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

        //looks if player steps on a light weighted pressure plate -> timer starts
        Player p = event.getPlayer();

        Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (b.getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE){
            timerAPR time = new timerAPR(true, 0);
         time.run();



        }
    }
}
