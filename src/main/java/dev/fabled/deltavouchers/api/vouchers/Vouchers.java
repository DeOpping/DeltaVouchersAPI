package dev.fabled.deltavouchers.api.vouchers;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Vouchers {

    List<Voucher> getVouchers();
    List<String> getVoucherIDs();

    boolean isVoucherID(final String id);
    boolean isItemVoucher(final ItemStack item, final boolean compareVUIDs);
    boolean isItemVoucher(final ItemStack item);
    boolean compareVoucherUIDs(ItemStack item, Voucher voucher);

    String voucherIDFromItem(ItemStack item);

    Voucher voucherFromItem(ItemStack item);
    Voucher voucherFromID(String id);

}
