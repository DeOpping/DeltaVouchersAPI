package dev.fabled.deltavouchers.api.actions;

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

    /**
     * Get an Action from the command line!
     * @param commandLine String
     * @return Action
     */
    Action fromCommandLine(String commandLine);

}
