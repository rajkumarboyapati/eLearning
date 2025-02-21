package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Course;
import com.demo.entities.User;
@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer>{
	@Query(value="select * from course where course_id=:courseId",nativeQuery = true)
	public List<Course> getAllCourses(@Param("courseId") int courseId);
	@Query(value = "select * from course c join category c1 on c1.category_id=c.category_category_id  join course_level_list l on l.course_course_id=c.course_id join level l1 on l1.level_id=l.level_list_level_id where c1.category_name=:categoryname and l1.level_name=:levelName",nativeQuery = true)
	public Course getCourseByLevelAndCategory(@Param("categoryname") String CategoryName,@Param("levelName") String levelName);
	@Query(value = "select * from course c join category c1 on c1.category_id=c.category_category_id  join course_level_list l on l.course_course_id=c.course_id join level l1 on l1.level_id=l.level_list_level_id join course_instructor_ref cr on c.course_id=cr.course_course_id join instructor i on cr.instructor_ref_instructor_id=i.instructor_id  where c1.category_name=:categoryname and l1.level_name=:levelName and i.instructor_name=:instructorname",nativeQuery = true)
	public Course getCourseByLevelAndCategoryAndInstructor(@Param("categoryname") String categoryName,@Param("levelName")String levelName,@Param("instructorname")String instructorName);
	@Query(value = "select count(distinct(q.quiz_id)) from course c join course_module_list cm on c.course_id=cm.course_course_id  join modules m on cm.module_list_module_id=m.module_id  "
			+ "join quiz q on  m.quiz_ref_quiz_id=q.quiz_id  where c.course_id=:courseid ",nativeQuery = true)
	public int getCountOfmoduleQuizzes(@Param("courseid") int courseId);
			
}
