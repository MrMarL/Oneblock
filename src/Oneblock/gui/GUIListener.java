package Oneblock.gui;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIListener implements Listener {

	@EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e){
    	if (!GUI.enabled)
    		return;
        Inventory inv = e.getClickedInventory();
        if (inv == null)
        	return;
        if (!inv.getHolder().getClass().isAssignableFrom(GUIHolder.class))
        	return;
	        
	    if (inv.getSize() == 9) {
	    	HumanEntity he = e.getWhoClicked();
		    if (!(he instanceof Player))
		        return;
		    Player pl = (Player) he;
		    
		    if (GUI.baseGUI != null && GUI.baseGUI.equals(inv)) {
		        ItemStack item = e.getCurrentItem();
		        if (item == null)
		        	return;
		        String command = item.getItemMeta().getDisplayName().split("/")[1];
		        pl.closeInventory();
		        pl.performCommand(command);
		    }
		    else {
		    	pl.closeInventory();
		        if (e.getRawSlot() == 2)
		        	pl.performCommand("ob accept");
		    }
        }
	    e.setCancelled(true);
    }
}