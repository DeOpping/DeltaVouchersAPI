package dev.paracausal.zetavouchers.api.requirements;

import dev.paracausal.zetavouchers.api.ZetaVouchersAPI;
import dev.paracausal.zetavouchers.api.config.KeyConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class Requirement {

    private final String key;

    public Requirement(String key) {
        this.key = key;
    }

    public String key() { return key; }

    public void register() {
        final Plugin pl = Bukkit.getPluginManager().getPlugin("ZetaVouchers");
        if (pl == null) return;
        final ZetaVouchersAPI api = (ZetaVouchersAPI) pl;
        api.requirements().register(this);
    }

    public abstract boolean allowed(Player player, KeyConfig config);

}
