package dev.paracausal.zetavouchers.api.requirements;

import dev.paracausal.zetavouchers.api.ZetaVouchersAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Requirement {

    private final String key;
    private final Map<String, RequirementOption> requirementOptions = new HashMap<>();

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

    public List<RequirementOption> options() { return new ArrayList<>(requirementOptions.values()); }

    public void addOption(RequirementOption option) {
        requirementOptions.putIfAbsent(option.key(), option);
    }

    public abstract boolean allowed(Player player, String[] conditions);

}
