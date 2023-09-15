package dev.paracausal.deltavouchers.api.events;

import dev.paracausal.deltavouchers.api.vouchers.Voucher;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCannotRedeemVoucherEvent extends Event {

    private final Player player;
    private final Voucher voucher;

    /**
     * Called when a player can't redeem a voucher because they do not meet the requirements
     * @param player Player
     * @param voucher Voucher
     */
    public PlayerCannotRedeemVoucherEvent(final Player player, final Voucher voucher) {
        this.player = player;
        this.voucher = voucher;
    }

    /**
     * The player who tried to redeem the voucher
     * @return Player
     */
    public Player getPlayer() { return player; }

    /**
     * The voucher that was to be redeemed
     * @return String
     */
    public Voucher getVoucher() { return voucher; }
    
    private static final HandlerList HANDLERS = new HandlerList();
    public static HandlerList getHandlerList() { return HANDLERS; }
    @Override public HandlerList getHandlers() { return HANDLERS; }

}
