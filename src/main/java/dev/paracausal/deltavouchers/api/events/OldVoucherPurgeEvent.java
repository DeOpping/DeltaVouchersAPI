package dev.paracausal.deltavouchers.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class OldVoucherPurgeEvent extends Event implements Cancellable {

    private final Player player;
    private final String voucherID;
    private final ItemStack purged;
    private boolean canceled = false;

    /**
     * Called when a player redeems an old voucher and it is purged
     * @param player Player
     * @param voucherID Voucher ID
     */
    public OldVoucherPurgeEvent(final Player player, final String voucherID, final ItemStack purged) {
        this.player = player;
        this.voucherID = voucherID;
        this.purged = purged;
    }

    /**
     * The player who redeemed the voucher
     * @return Player
     */
    public Player getPlayer() { return player; }

    /**
     * The Voucher ID that is to be purged
     * @return String
     */
    public String getVoucherID() { return voucherID; }

    /**
     * Get the ItemStack that will be purged
     * @return ItemStack
     */
    public ItemStack getPurged() { return purged; }

    @Override public void setCancelled(boolean cancel) { canceled = cancel; }
    @Override public boolean isCancelled() {return canceled; }

    private static final HandlerList HANDLERS = new HandlerList();
    public static HandlerList getHandlerList() { return HANDLERS; }
    @Override public HandlerList getHandlers() { return HANDLERS; }

}
