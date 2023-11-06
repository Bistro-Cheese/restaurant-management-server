package com.ooadprojectserver.restaurantmanagement.service.schedule;

import com.ooadprojectserver.restaurantmanagement.dto.request.AssignScheduleRequest;
import com.ooadprojectserver.restaurantmanagement.dto.response.schedule.ManagerScheduleRespone;
import com.ooadprojectserver.restaurantmanagement.dto.response.schedule.StaffScheduleResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface ScheduleService {
    StaffScheduleResponse getSchedule(HttpServletRequest request);
    ManagerScheduleRespone getManagerSchedule(HttpServletRequest request);
    void assignSchedule(String staff_username, AssignScheduleRequest request, HttpServletRequest httpServletRequest);
    void deleteSchedule(Long timekeeping_id);
    public void timekeepingStaff(Long timekeeping_id);
}
