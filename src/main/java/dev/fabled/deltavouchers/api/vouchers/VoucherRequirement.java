package dev.fabled.deltavouchers.api.vouchers;

import org.bukkit.entity.Player;

public interface VoucherRequirement {

    boolean canRedeem(Player player);
    boolean canRedeem(Player player, boolean run);

}
