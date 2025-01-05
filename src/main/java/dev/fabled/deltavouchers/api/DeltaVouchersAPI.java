package dev.fabled.deltavouchers.api;

import dev.fabled.deltavouchers.api.actions.Actions;
import dev.fabled.deltavouchers.api.vouchers.Vouchers;
import dev.fabled.deltavouchers.api.requirements.Requirements;

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
