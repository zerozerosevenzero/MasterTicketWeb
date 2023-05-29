package com.example.masterticket.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import java.util.*

class LocalDateTimeUtils {
    companion object {
        val YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyyMMdd")
        val YYYY_MM_DD2 = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val MM_DD = DateTimeFormatter.ofPattern("MM-dd")

        fun format(localDateTime: LocalDateTime): String {
            return localDateTime.format(YYYY_MM_DD_HH_MM)
        }

        fun format(localDateTime: LocalDateTime, formatter: DateTimeFormatter?): String {
            return localDateTime.format(formatter)
        }

        fun parse(localDateTimeString: String?): LocalDateTime {
            return if (localDateTimeString.isNullOrBlank()) throw IllegalArgumentException("주어진 날짜가 없습니다.")
            else {
                LocalDate.parse(localDateTimeString, YYYY_MM_DD).atStartOfDay()
            }
        }

        fun getWeekOfYear(localDateTime: LocalDateTime): Int {
            return localDateTime[WeekFields.of(Locale.KOREA).weekOfYear()]
        }

        fun parseDate(localDateTimeString: String): LocalDateTime? {
            return if (localDateTimeString.isNullOrBlank()) null
            else LocalDate.parse(localDateTimeString, YYYY_MM_DD).atStartOfDay()
        }
    }

}