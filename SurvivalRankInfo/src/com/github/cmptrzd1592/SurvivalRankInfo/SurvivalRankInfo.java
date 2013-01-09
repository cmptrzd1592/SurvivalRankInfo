package com.github.cmptrzd1592.SurvivalRankInfo;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.*;

@SuppressWarnings("unused")
public class SurvivalRankInfo extends JavaPlugin {
	
	File configFile;
	
	FileConfiguration config;

	@Override
	public void onEnable(){
		getLogger().info("SurvivalRankInfo has been enabled!");
		configFile = new File(getDataFolder(), "config.yml");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	
	@Override
	public void onDisable(){
		getLogger().info("SurvivalRankInfo has been disabled!");
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(cmd.getName().equalsIgnoreCase("rankinfo")){
            	Player player = (Player) sender;
            	if(args.length == 0){
            		player.sendMessage(ChatColor.RED + "ERROR: /rankinfo [rank]");
            		return true;
            	}else if(args[0].equalsIgnoreCase("member") || args[0].equalsIgnoreCase("m")){
            		player.sendMessage(ChatColor.DARK_GRAY + "Member" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.member"));
            	}else if(args[0].equalsIgnoreCase("tier1") || args[0].equalsIgnoreCase("t1")){
                    player.sendMessage(ChatColor.DARK_BLUE + "Tier 1" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.tier1"));
            	}else if(args[0].equalsIgnoreCase("tier2") || args[0].equalsIgnoreCase("t2")){
                    player.sendMessage(ChatColor.DARK_GREEN + "Tier 2" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.tier2"));
                }else if(args[0].equalsIgnoreCase("tier3") || args[0].equalsIgnoreCase("t3")){
                    player.sendMessage(ChatColor.GOLD + "Tier 3" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.tier3"));
                }else if(args[0].equalsIgnoreCase("tier4") || args[0].equalsIgnoreCase("t4")){
                    player.sendMessage(ChatColor.AQUA + "Tier 4" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.tier4"));
                }else if(args[0].equalsIgnoreCase("trialmod") || args[0].equalsIgnoreCase("tm")){
                    player.sendMessage(ChatColor.RED + "TrialMod" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.trialmod"));
                }else if(args[0].equalsIgnoreCase("moderator") || args[0].equalsIgnoreCase("mod")){
                    player.sendMessage(ChatColor.RED + "Moderator" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.mod"));
                }else if(args[0].equalsIgnoreCase("admin")){
                    player.sendMessage(ChatColor.DARK_RED + "Admin" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.admin"));
                }else if(args[0].equalsIgnoreCase("owner")){
                    player.sendMessage(ChatColor.DARK_RED + "Owner" + ChatColor.LIGHT_PURPLE + ": " + getConfig().getString("rank.owner"));
                }else if(args[0].equalsIgnoreCase("help")){
                    player.sendMessage(ChatColor.LIGHT_PURPLE + getConfig().getString("rank.help"));
                }
            } return true;
}
}