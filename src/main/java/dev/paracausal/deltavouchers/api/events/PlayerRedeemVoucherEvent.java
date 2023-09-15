package dev.paracausal.deltavouchers.api.events;

import dev.paracausal.deltavouchers.api.vouchers.Voucher;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerRedeemVoucherEvent extends Event implements Cancellable {

    private final Player player;
    private final Voucher voucher;
    private boolean canceled = false;

    /**
     * Called when a player redeems a voucher successfully
     * @param player Player
     * @param voucher Voucher
     */
    public PlayerRedeemVoucherEvent(final Player player, final Voucher voucher) {
        this.player = player;
        this.voucher = voucher;
    }

    /**
     * The player who redeemed the voucher
     * @return Player
     */
    public Player getPlayer() { return player; }

    /**
     * The voucher that is to be redeemed
     * @return String
     */
    public Voucher getVoucher() { return voucher; }

    @Override public void setCancelled(boolean cancel) { canceled = cancel; }
    @Override public boolean isCancelled() {return canceled; }

    private static final HandlerList HANDLERS = new HandlerList();
    public static HandlerList getHandlerList() { return HANDLERS; }
    @Override public HandlerList getHandlers() { return HANDLERS; }

}
