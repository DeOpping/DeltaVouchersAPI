package dev.fabled.deltavouchers.api.requirements;

import dev.fabled.deltavouchers.api.actions.Actions;
import dev.fabled.deltavouchers.api.config.KeyConfig;
import dev.fabled.deltavouchers.api.DeltaVouchersAPI;
import dev.fabled.deltavouchers.api.actions.Action;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.LinkedList;

public abstract class Requirement {

    private final String key;
    private final DeltaVouchersAPI api;

    public Requirement(String key) {
        this.key = key;
        final Plugin pl = Bukkit.getPluginManager().getPlugin("DeltaVouchers");
        if (pl != null) api = (DeltaVouchersAPI) pl;
        else api = null;
    }

    public String key() { return key; }

    public void register() {
        if (api == null) return;
        api.requirements().register(this);
    }

    public abstract boolean allowed(Player player, KeyConfig config);

    public void loadActions(KeyConfig config) {
        clearActions();
        if (api == null) return;
        final Actions actions = api.actions();
        config.getStringList("actions").forEach(string -> {
            final Action action = actions.fromCommandLine(string);
            final String commandLine = action.replace(string);
            addAction(action);
            addCommandLine(commandLine);
        });
    }

    public abstract void clearActions();

    public abstract void addAction(Action action);
    public abstract void addCommandLine(String commandLine);

    public abstract LinkedList<Action> actions();
    public abstract LinkedList<String> commandLines();

    public void executeActions(Player player) {
        final LinkedList<Action> actions = actions();
        final LinkedList<String> commandLines = commandLines();
        int size = actions.size();
        for (int i = 0; i < size; i++) actions.get(i).run(player, commandLines.get(i));
    }

    public abstract Requirement newInstance();

}
