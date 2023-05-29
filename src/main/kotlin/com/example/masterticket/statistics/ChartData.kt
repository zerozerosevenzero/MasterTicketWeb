package com.example.masterticket.statistics

data class ChartData(
    var labels: List<String>,
    val attendedCounts: List<Long>,
    val cancelledCounts: List<Long>,
)