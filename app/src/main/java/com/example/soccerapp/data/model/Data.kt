package com.example.soccerapp.data.model

import com.example.soccerapp.data.model.Teams
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id"             ) var id            : String?        = null,
    @SerializedName("status"         ) var status        : String?        = null,
    @SerializedName("status_name"    ) var statusName    : String?     = null,
    @SerializedName("status_period"  ) var statusPeriod  : String?     = null,
    @SerializedName("pitch"          ) var pitch         : String?     = null,
    @SerializedName("referee_id"     ) var refereeId     : String?     = null,
    @SerializedName("round_id"       ) var roundId       : String?     = null,
    @SerializedName("round_name"     ) var roundName     : String?     = null,
    @SerializedName("season_id"      ) var seasonId      : String?     = null,
    @SerializedName("season_name"    ) var seasonName    : String?     = null,
    @SerializedName("stage_id"       ) var stageId       : String?     = null,
    @SerializedName("stage_name"     ) var stageName     : String?     = null,
    @SerializedName("group_id"       ) var groupId       : String?     = null,
    @SerializedName("group_name"     ) var groupName     : String?     = null,
    @SerializedName("aggregate_id"   ) var aggregateId   : String?     = null,
    @SerializedName("winner_team_id" ) var winnerTeamId  : String?     = null,
    @SerializedName("venue_id"       ) var venueId       : String?     = null,
    @SerializedName("leg"            ) var leg           : String?     = null,
    @SerializedName("week"           ) var week          : String?     = null,
    @SerializedName("deleted"        ) var deleted       : String?     = null,
    @SerializedName("info"           ) var info          : String?     = null,
    @SerializedName("attendance"     ) var attendance    : String?     = null,
    @SerializedName("teams"          ) var teams         : Teams?,
    @SerializedName("league"         ) var league        : League?,
    @SerializedName("time") var time: Time?
)
