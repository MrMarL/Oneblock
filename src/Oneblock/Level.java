package Oneblock;

import java.util.ArrayList;

import org.bukkit.boss.BarColor;

public class Level {
	public static Level max = new Level("Level: MAX");
	public static ArrayList <Level> levels = new ArrayList <>();
	
	public static Level get(int i) {
		if (i < levels.size())
			return levels.get(i);
		return max;
	}
	
	public static int size() {
		return levels.size();
	}
	
	public String name;
	public int size = 0;
	public BarColor color;
	
	public Level(String name) {
        this.name = name;
    }
}
