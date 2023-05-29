package com.example.masterticket.statistics

import com.example.masterticket.util.LocalDateTimeUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StatisticsService(
    val statisticsRepository: StatisticsRepository
) {
    fun makeChartData(to: LocalDateTime?): ChartData {
        val from = to?.minusDays(10)
        val aggregatedStatisticsList = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from, to)
        val labels: MutableList<String> = ArrayList()
        val attendedCounts: MutableList<Long> = ArrayList()
        val cancelledCounts: MutableList<Long> = ArrayList()

        for (statistics in aggregatedStatisticsList) {
            labels.add(LocalDateTimeUtils.format(statistics.statisticsAt, LocalDateTimeUtils.MM_DD))
            attendedCounts.add(statistics.attendedCount)
            cancelledCounts.add(statistics.cancelledCount)
        }
        return ChartData(labels, attendedCounts, cancelledCounts)
    }
}