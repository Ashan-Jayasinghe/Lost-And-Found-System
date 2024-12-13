package com.lostandfoundsystem.LAFS.entity.enums;

public enum ItemStatus {
    REPORTED,       // The item has been reported as lost or found.
    IN_PROGRESS,    // A match is being investigated or verified.
    MATCHED,        // The item has been matched (lost and found items paired).
    RETURNED,       // The item has been returned to the owner.
    UNRESOLVED      // The item could not be resolved or is still unclaimed.
}
