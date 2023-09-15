package dev.paracausal.deltavouchers.api;

import dev.paracausal.deltavouchers.api.actions.Actions;
import dev.paracausal.deltavouchers.api.vouchers.Vouchers;
import dev.paracausal.deltavouchers.api.requirements.Requirements;

public interface DeltaVouchersAPI {

    /**
     * Get the DeltaVouchers Actions class instance
     * @return Actions
     */
    Actions actions();

    /**
     * Get the DeltaVouchers Requirements class instance
     * @return Requirements
     */
    Requirements requirements();

    /**
     * Get the DeltaVouchers Vouchers class instance
     * @return Vouchers
     */
    Vouchers vouchers();

}
