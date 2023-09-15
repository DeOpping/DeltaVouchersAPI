package dev.paracausal.deltavouchers.api.events;

import dev.paracausal.deltavouchers.api.vouchers.Voucher;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;

public class VoucherGiveAllEvent extends Event implements Cancellable {

    private final List<Player> skippedPlayers;
    private Voucher voucher;
    private int amount;
    private boolean canceled = false;

    /**
     * Called when all online players are given a voucher
     * @param voucher Voucher
     * @param amount int
     */
    public VoucherGiveAllEvent(final Voucher voucher, final int amount) {
        this.skippedPlayers = new ArrayList<>();
        this.voucher = voucher;
        this.amount = amount;
    }

    /**
     * Skip giving this player a voucher
     * @param player Player
     */
    public void skipPlayer(Player player) {
        if (!skippedPlayers.contains(player)) skippedPlayers.add(player);
    }

    public List<Player> getSkippedPlayers() { return skippedPlayers; }

    /**
     * The voucher that is to be given
     * @return Voucher
     */
    public Voucher getVoucher() { return voucher; }

    /**
     * Set the voucher to be given
     * @param voucher Voucher
     */
    public void setVoucher(Voucher voucher) { this.voucher = voucher; }

    /**
     * Get the amount of the voucher to be given
     * @return int
     */
    public int getAmount() { return amount; }

    /**
     * Set the amount of vouchers to be given
     * @param amount
     */
    public void setAmount(int amount) { this.amount = amount; }

    @Override public void setCancelled(boolean cancel) { canceled = cancel; }
    @Override public boolean isCancelled() {return canceled; }

    private static final HandlerList HANDLERS = new HandlerList();
    public static HandlerList getHandlerList() { return HANDLERS; }
    @Override public HandlerList getHandlers() { return HANDLERS; }

}
