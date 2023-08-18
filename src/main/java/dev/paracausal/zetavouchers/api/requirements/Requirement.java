package dev.paracausal.zetavouchers.api.requirements;

import dev.paracausal.zetavouchers.api.ZetaVouchersAPI;
import dev.paracausal.zetavouchers.api.actions.Action;
import dev.paracausal.zetavouchers.api.actions.Actions;
import dev.paracausal.zetavouchers.api.config.KeyConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.LinkedList;

public abstract class Requirement {

    private final String key;
    private final ZetaVouchersAPI api;

    private final LinkedList<Action> actions = new LinkedList<>();
    private final LinkedList<String> commandLines = new LinkedList<>();

    public Requirement(String key) {
        this.key = key;
        final Plugin pl = Bukkit.getPluginManager().getPlugin("ZetaVouchers");
        if (pl != null) api = (ZetaVouchersAPI) pl;
        else api = null;
    }

    public String key() { return key; }

    public void register() {
        if (api == null) return;
        api.requirements().register(this);
    }

    public abstract boolean allowed(Player player, KeyConfig config);

    public void loadActions(KeyConfig config) {
        if (api == null) return;
        final Actions actions = api.actions();
        config.getStringList("actions").forEach(string -> {
            final Action action = actions.fromCommandLine(string);
            final String commandLine = action.replace(string);
            this.actions.add(action);
            this.commandLines.add(commandLine);
        });
    }

    public LinkedList<Action> actions() { return actions; }
    public LinkedList<String> commandLines() { return commandLines; }

    public void executeActions(Player player) {
        final LinkedList<Action> actions = actions();
        final LinkedList<String> commandLines = commandLines();
        int size = actions.size();
        for (int i = 0; i < size; i++) actions.get(i).run(player, commandLines.get(i));
    }

}
