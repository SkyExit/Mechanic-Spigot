package de.laurinhummel.mechanic.listeners;

import java.util.Iterator;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathChest implements Listener {

	@EventHandler
    public void onDeath(PlayerDeathEvent e)
    {
      Player p = e.getEntity().getPlayer();
      assert p != null;
      if(p.hasPermission("mechanic.deathChest")) {
        Block loc = p.getLocation().getBlock();
        Location loc2 = p.getLocation().add(1, 0 ,0);
        Location loc3 = p.getLocation().add(-1, 0 ,0);
        Block dirt = loc;
        Block loc2B = loc2.getBlock();
        Block loc3B = loc3.getBlock();
        Block chest1 = loc2B;
        Block chest2 = loc3B;
        dirt.setType(Material.DIRT);
        chest1.setType(Material.CHEST);
        chest2.setType(Material.CHEST);
        Chest inv1 = (Chest)chest1.getState();
        Chest inv2 = (Chest)chest2.getState();

        ItemStack[] armor = p.getInventory().getArmorContents();
        ItemStack offHand = p.getInventory().getItemInOffHand();

        //Row1
        ItemStack slot0 = p.getInventory().getItem(0);
        ItemStack slot1 = p.getInventory().getItem(1);
        ItemStack slot2 = p.getInventory().getItem(2);
        ItemStack slot3 = p.getInventory().getItem(3);
        ItemStack slot4 = p.getInventory().getItem(4);
        ItemStack slot5 = p.getInventory().getItem(5);
        ItemStack slot6 = p.getInventory().getItem(6);
        ItemStack slot7 = p.getInventory().getItem(7);
        ItemStack slot8 = p.getInventory().getItem(8);
        //Row2
        ItemStack slot9 = p.getInventory().getItem(9);
        ItemStack slot10 = p.getInventory().getItem(10);
        ItemStack slot11 = p.getInventory().getItem(11);
        ItemStack slot12 = p.getInventory().getItem(12);
        ItemStack slot13 = p.getInventory().getItem(13);
        ItemStack slot14 = p.getInventory().getItem(14);
        ItemStack slot15 = p.getInventory().getItem(15);
        ItemStack slot16 = p.getInventory().getItem(16);
        ItemStack slot17 = p.getInventory().getItem(17);
        //Row3
        ItemStack slot18 = p.getInventory().getItem(18);
        ItemStack slot19 = p.getInventory().getItem(19);
        ItemStack slot20 = p.getInventory().getItem(20);
        ItemStack slot21 = p.getInventory().getItem(21);
        ItemStack slot22 = p.getInventory().getItem(22);
        ItemStack slot23 = p.getInventory().getItem(23);
        ItemStack slot24 = p.getInventory().getItem(24);
        ItemStack slot25 = p.getInventory().getItem(25);
        ItemStack slot26 = p.getInventory().getItem(26);
        //Hotbar
        ItemStack slot27 = p.getInventory().getItem(27);
        ItemStack slot28 = p.getInventory().getItem(28);
        ItemStack slot29 = p.getInventory().getItem(29);
        ItemStack slot30 = p.getInventory().getItem(30);
        ItemStack slot31 = p.getInventory().getItem(31);
        ItemStack slot32 = p.getInventory().getItem(32);
        ItemStack slot33 = p.getInventory().getItem(33);
        ItemStack slot34 = p.getInventory().getItem(34);
        ItemStack slot35 = p.getInventory().getItem(35);

        //Row1
        inv2.getInventory().setItem(0, slot0);
        inv2.getInventory().setItem(1, slot1);
        inv2.getInventory().setItem(2, slot2);
        inv2.getInventory().setItem(3, slot3);
        inv2.getInventory().setItem(4, slot4);
        inv2.getInventory().setItem(5, slot5);
        inv2.getInventory().setItem(6, slot6);
        inv2.getInventory().setItem(7, slot7);
        inv2.getInventory().setItem(8, slot8);
        //Row2
        inv2.getInventory().setItem(9, slot9);
        inv2.getInventory().setItem(10, slot10);
        inv2.getInventory().setItem(11, slot11);
        inv2.getInventory().setItem(12, slot12);
        inv2.getInventory().setItem(13, slot13);
        inv2.getInventory().setItem(14, slot14);
        inv2.getInventory().setItem(15, slot15);
        inv2.getInventory().setItem(16, slot16);
        inv2.getInventory().setItem(17, slot17);
        //Row3
        inv2.getInventory().setItem(18, slot18);
        inv2.getInventory().setItem(19, slot19);
        inv2.getInventory().setItem(20, slot20);
        inv2.getInventory().setItem(21, slot21);
        inv2.getInventory().setItem(22, slot22);
        inv2.getInventory().setItem(23, slot23);
        inv2.getInventory().setItem(24, slot24);
        inv2.getInventory().setItem(25, slot25);
        inv2.getInventory().setItem(26, slot26);

        //Hotbar
        inv1.getInventory().setStorageContents(armor);
        inv1.getInventory().setItem(4, offHand);
        inv1.getInventory().setItem(9, slot27);
        inv1.getInventory().setItem(10, slot28);
        inv1.getInventory().setItem(11, slot29);
        inv1.getInventory().setItem(12, slot30);
        inv1.getInventory().setItem(13, slot31);
        inv1.getInventory().setItem(14, slot32);
        inv1.getInventory().setItem(15, slot33);
        inv1.getInventory().setItem(16, slot34);
        inv1.getInventory().setItem(17, slot35);

        List <ItemStack> list = e.getDrops();
        Iterator<ItemStack> i = list.iterator();
        while(i.hasNext()){
          ItemStack item = i.next();
          i.remove();
      }
      }
    }
}