package dev.fabled.deltavouchers.api.vouchers;

import dev.fabled.deltavouchers.api.exceptions.InvalidPlayerException;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public interface Voucher {

    String id();
    UUID vuid();
    String name();

    void give(Player player, OfflinePlayer target, int amount) throws InvalidPlayerException;
    void give(OfflinePlayer player, int amount) throws InvalidPlayerException;

    ItemStack item(Player player);

    VoucherRequirement requirement();

    void run(Player player);

}
