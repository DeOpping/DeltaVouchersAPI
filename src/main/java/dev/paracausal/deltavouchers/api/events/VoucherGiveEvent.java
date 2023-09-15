package dev.paracausal.deltavouchers.api.events;

import dev.paracausal.deltavouchers.api.vouchers.Voucher;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VoucherGiveEvent extends Event implements Cancellable {

    private final OfflinePlayer player;
    private Voucher voucher;
    private int amount;
    private boolean canceled = false;

    /**
     * Called when a player is given a voucher
     * @param player Player
     * @param voucher Voucher
     * @param amount Amount
     */
    public VoucherGiveEvent(final OfflinePlayer player, final Voucher voucher, final int amount) {
        this.player = player;
        this.voucher = voucher;
        this.amount = amount;
    }

    /**
     * The player who was given the voucher
     * @return OfflinePlayer
     */
    public OfflinePlayer getPlayer() { return player; }

    /**
     * The voucher that is to be given
     * @return String
     */
    public Voucher getVoucher() { return voucher; }

    /**
     * Set the voucher to be given
     * @param voucher Voucher
     */
    public void setVoucher(Voucher voucher) { this.voucher = voucher; }

    /**
     * Get the amount of vouchers to be given
     * @return int
     */
    public int getAmount() { return amount; }

    /**
     * Set the amount of vouchers to be given
     * @param amount int
     */
    public void setAmount(int amount) { this.amount = amount; }

    @Override public void setCancelled(boolean cancel) { canceled = cancel; }
    @Override public boolean isCancelled() {return canceled; }

    private static final HandlerList HANDLERS = new HandlerList();
    public static HandlerList getHandlerList() { return HANDLERS; }
    @Override public HandlerList getHandlers() { return HANDLERS; }

}
