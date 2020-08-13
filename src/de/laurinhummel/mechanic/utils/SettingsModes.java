package de.laurinhummel.mechanic.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsModes {
	
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> menu = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> dmgalert = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> dmgremover = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> settings = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> timer = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> scoreboard = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> gamerule = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> challenge = new HashMap<>();
	public static HashMap<SettingsItems.ItemType, SettingsItems.ItemLevel> level = new HashMap<>();
	public static List<String> uuids = new ArrayList<>();
	public static int startTime = 0;
	public static int currentTime = 0;
	public static double currentHP = 20.0;
	public static double currentHunger = 20.0;
	public static double currentEXP = 0;
	public static boolean isPing = false;

}