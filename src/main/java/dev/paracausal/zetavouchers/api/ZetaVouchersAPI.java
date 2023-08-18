package dev.paracausal.zetavouchers.api;

import dev.paracausal.zetavouchers.api.actions.Actions;
import dev.paracausal.zetavouchers.api.requirements.Requirements;

public interface ZetaVouchersAPI {

    /**
     * Get the ZetaVouchers Actions class instance
     * @return Actions
     */
    Actions actions();

    /**
     * Get the ZetaVouchers Requirements class instance
     * @return Requirements
     */
    Requirements requirements();

}
