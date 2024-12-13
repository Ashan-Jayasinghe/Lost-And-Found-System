package com.lostandfoundsystem.LAFS.entity.enums;

public enum MatchStatus {
    PENDING,         // A match has been suggested but not confirmed yet.
    VERIFIED,        // The match has been reviewed and verified.
    REJECTED,        // The match was reviewed and determined to be incorrect.
    COMPLETED        // The match process is complete, and the item has been returned or resolved.

}
