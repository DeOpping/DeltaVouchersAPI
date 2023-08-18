package dev.paracausal.zetavouchers.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class Action {

    private final String id;

    public Action(String id) {
        this.id = id;
    }

    public String id() { return id; }

    public void register() {
        final Plugin pl = Bukkit.getPluginManager().getPlugin("ZetaVouchers");
        if (pl == null) return;
        final ZetaVouchersAPI api = (ZetaVouchersAPI) pl;
        api.actions().register(this);
    }

    public String replace(String commandLine) {
        if (commandLine.startsWith("[" + id + "] "))
            commandLine = commandLine.replaceFirst("\\[" + id + "] ", "");

        else if (commandLine.startsWith("[" + id + "]"))
            commandLine = commandLine.replaceFirst("\\[" + id + "]", "");

        return commandLine;
    }

    public abstract void run(Player player, String commandLine);

}
