package com.example.masterticket.controller

import com.example.masterticket.UserGroupMapping.UserGroupMappingService
import com.example.masterticket.bulkpass.BulkPassRequest
import com.example.masterticket.bulkpass.BulkPassService
import com.example.masterticket.packaze.PackageService
import com.example.masterticket.statistics.StatisticsService
import com.example.masterticket.util.LocalDateTimeUtils
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime

@Controller
@RequestMapping(value = ["/admin"])
@RequiredArgsConstructor
class AdminViewController(
    val bulkPassService: BulkPassService,
    val packageService: PackageService,
    val userGroupMappingService: UserGroupMappingService,
    val statisticsService: StatisticsService,
) {

    @GetMapping
    fun home(modelAndView: ModelAndView, @RequestParam("to") toString: String): ModelAndView {
        val to: LocalDateTime? = LocalDateTimeUtils.parseDate(toString)
        modelAndView.addObject("chartData", statisticsService.makeChartData(to))
        modelAndView.viewName = "admin/index"
        return modelAndView
    }

    @GetMapping("/bulk-pass")
    fun registerBulkPass(modelAndView: ModelAndView): ModelAndView {
        modelAndView.addObject("bulkPasses", bulkPassService.allBulkPasses)
        modelAndView.addObject("packages", packageService.allPackages)
        modelAndView.addObject("userGroupIds", userGroupMappingService.allUserGroupIds)
        modelAndView.addObject("request", BulkPassRequest())
        modelAndView.viewName = "admin/bulk-pass"
        return modelAndView
    }

    @PostMapping("/bulk-pass")
    fun addBulkPass(@ModelAttribute("request") bulkPassRequest: BulkPassRequest, model: Model): String {
        bulkPassService.addBulkPass(bulkPassRequest)
        return "redirect:/admin/bulk-pass"
    }
}