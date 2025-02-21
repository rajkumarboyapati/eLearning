package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Integer>{
	@Query(value = "select r.report_id,r.progress,r.quiz_id,r.quiz_score,r.course_ref_course_id,r.employee_employee_id,e.employee_name from reports r join employee e on r.employee_employee_id=e.employee_id join team_employee_list te on e.employee_id=te.employee_list_employee_id join team t on te.team_team_id=t.team_id join"
			+ " manager m on t.manager_ref_manager_id=m.manager_id where m.manager_id=:managerId",nativeQuery = true)
	public List<Reports> getReportByManager(@Param("managerId") int managerId);
	@Query(value="SELECT count(DISTINCT quiz_id)\r\n"
			+ "FROM reports\r\n"
			+ "WHERE quiz_id IN (\r\n"
			+ "    SELECT q.quiz_id\r\n"
			+ "    FROM course c\r\n"
			+ "    JOIN course_module_list cm ON c.course_id = cm.course_course_id\r\n"
			+ "    JOIN modules m ON cm.module_list_module_id = m.module_id\r\n"
			+ "    JOIN quiz q ON m.quiz_ref_quiz_id = q.quiz_id\r\n"
			+ "    WHERE c.course_id = :courseid\r\n"
			+ ");\r\n"
			+ " ",nativeQuery = true)
	public int countOfQuizIdByReports(@Param("courseid") int courseId);
	@Query(value ="SELECT AVG(r.progress) \r\n"
			+ "FROM reports r \r\n"
			+ "WHERE r.quiz_id IN (\r\n"
			+ "    SELECT q.quiz_id \r\n"
			+ "    FROM course c \r\n"
			+ "    JOIN course_module_list cm ON c.course_id = cm.course_course_id  \r\n"
			+ "    JOIN modules m ON cm.module_list_module_id = m.module_id  \r\n"
			+ "    JOIN quiz q ON m.quiz_ref_quiz_id = q.quiz_id \r\n"
			+ "    WHERE c.course_id = ?\r\n"
			+ ");\r\n"
			+ "",nativeQuery = true)
	public double getProgressByCourseId(@Param("courseid")int courseId);
}
