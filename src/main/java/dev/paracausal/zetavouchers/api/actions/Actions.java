package dev.paracausal.zetavouchers.api.actions;

public interface Actions {

    /**
     * Registers your custom Action
     * @param action Action
     */
    void register(Action action);

    /**
     * Check if an existing action is already using the specified ID.
     * @param id Action ID
     * @return boolean
     */
    boolean exists(String id);

}
