package dev.paracausal.deltavouchers.api.requirements;

public interface Requirements {

    /**
     * Register your Requirement!
     * @param requirement Requirement
     */
    void register(Requirement requirement);

    /**
     * Check whether a Requirement with this key already exists!
     * @param key Requirement key
     * @return
     */
    boolean exists(String key);

}
