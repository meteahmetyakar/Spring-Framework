package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    /**
     * @param theCourse
     */
    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }


    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tempInstructor.getCourses();

        for(Course tempCourse : courses)
            tempCourse.setInstructor(null);

        entityManager.remove(tempInstructor);

    }

    /**
     * @param theId : Id of instructor
     * @return : InstructorDetail of instructor
     */
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    /**
     * @return
     */
    @Override
    public int getInstructorCount() {
        String jpql = "SELECT COUNT(*) FROM Instructor";
        return ((Long) entityManager.createQuery(jpql).getSingleResult()).intValue();
    }

    /**
     * @param theId
     */
    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        entityManager.remove(tempInstructorDetail);
    }

    /**
     * @param theId
     * @return
     */
    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",
                Course.class
        );

        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();

        return courses;

    }

    /**
     * @param theId
     * @return
     */
    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                "JOIN FETCH i.courses " +
                "where i.id = :data",
                Instructor.class
        );

        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    /**
     * @param tempInstructor
     */
    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    /**
     * @param tempCourse
     */
    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    /**
     * @param theId
     * @return
     */
    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    /**
     * @param theId
     */
    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);

    }

    /**
     * @param theId
     * @return
     */
    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.students  "
                + "where c.id = :data",
                Course.class
        );

        query.setParameter("data", theId);

        Course course = query.getSingleResult();

        return course;
    }

    /**
     * @param theId
     * @return
     */
    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data",
                Student.class
        );

        query.setParameter("data", theId);

        Student student = query.getSingleResult();

        return student;

    }

    /**
     * @param tempStudent
     */
    @Override
    @Transactional
    public void update(Student tempStudent) {

        entityManager.merge(tempStudent);


    }

    /**
     * @param theId
     */
    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student tempStudent = entityManager.find(Student.class, theId);

        entityManager.remove(tempStudent);
    }
}
