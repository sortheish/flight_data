package com.example.assignmentflight.models

/**
 * @author Ishwari Sorthe
 * Data class - Rocket
 */
data class Rocket(
    val fairings: Fairings,
    val first_stage: FirstStage,
    val rocket_id: String,
    val rocket_name: String,
    val rocket_type: String,
)