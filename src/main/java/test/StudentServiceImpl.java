package test; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.stereotype.Service; 
import javax.annotation.Resource;
 @Service 
 public class StudentServiceImpl implements StudentService { 
 private StudentDao studentDao; 
 /** 
 * @Autowired
 * @Qualifier("studentDaoId") 
 * 上面两行为一种方式 
 * 下面一行为另一种方式 
 * @Resource(name = "studentDaoId") 
 * @param studentDao 
 */ 
 @Autowired
 @Qualifier("studentDaoId") 
 // @Resource(name = "studentDaoId")
 public void setStudentDao(StudentDao studentDao) { this.studentDao = studentDao; } @Override public void addStudent() { studentDao.save(); } }
