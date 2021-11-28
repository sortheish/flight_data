package com.example.assignmentflight.models

/**
 * @author Ishwari Sorthe
 * Data class - Timeline
 */
data class Timeline(
    val beco: Int,
    val center_core_entry_burn: Int,
    val center_core_landing: Int,
    val center_stage_sep: Int,
    val engine_chill: Int,
    val fairing_deploy: Int,
    val go_for_launch: Int,
    val go_for_prop_loading: Int,
    val ignition: Int,
    val liftoff: Int,
    val maxq: Int,
    val meco: Int,
    val payload_deploy: Int,
    val prelaunch_checks: Int,
    val propellant_pressurization: Int,
    val seco_one: Int,
    val seco_two: Int,
    val seco_three: Int,
    val seco_four: Int,
    val second_stage_ignition: Int,
    val second_stage_restart: Int,
    val side_core_boostback: Int,
    val side_core_entry_burn: Int,
    val side_core_landing: Int,
    val side_core_sep: Int,
    val stage1_lox_loading: Int,
    val stage1_rp1_loading: Int,
    val stage2_lox_loading: Int,
    val stage2_rp1_loading: Int,
    val webcast_liftoff: Any = TODO()
)