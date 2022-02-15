package boilerplate.java8;

import boilerplate.java8.dao.AppDao;
import boilerplate.java8.dao.AppDaoImpl;
import boilerplate.java8.dao.StudentsDao;
import boilerplate.java8.dao.StudentsDaoImpl;
import boilerplate.java8.entity.Employee;
import boilerplate.java8.entity.Students;
import boilerplate.java8.repository.EmployeeRepository;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Slf4jJdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class LessonMain {

  public static void main(String[] args) {
    Config config = createConfig();
    TransactionManager tm = config.getTransactionManager();

//    // setup database
//    AppDao appDao = new AppDaoImpl(config);
//    tm.required(appDao::create);

    // read and update
//      tm.required(()->{
//            StudentsDao studentsDao = new StudentsDaoImpl(config);
//            Students students = new Students();
//            students.studentName = "エムアイ太郎";
//            students.studentAge = 25;
//            students.admissionDate = LocalDate.now();
//            students.admissionTime = LocalTime.now();
//            students.admissionDateTime = LocalDateTime.now();
//            studentsDao.insert(students);
//
//            studentsDao.selectAll().stream().forEach(System.out::println);
//            throw new RuntimeException();
//      });

//    tm.required(
//        () -> {
//            StudentsDao studentsDao = new StudentsDaoImpl(config);
//
//            Students students = new Students();
//            students.studentName = "エムアイ太郎";
//            students.studentAge = 25;
//            students.admissionDate = LocalDate.now();
//            students.admissionTime = LocalTime.now();
//            students.admissionDateTime = LocalDateTime.now();
//            studentsDao.insert(students);
//
//            Students students2 = new Students();
//            students2.studentName = "エムアイ次郎";
//            students2.studentAge = 25;
//            students2.admissionDate = LocalDate.now();
//            students2.admissionTime = LocalTime.now();
//            students2.admissionDateTime = LocalDateTime.now();
//            studentsDao.insert(students2);
//
//            //studentsDao.selectAll().stream().forEach(System.out::println);
//
//            students.studentName = "えむあいゴロウ";
//            studentsDao.update(students);
//            //studentsDao.selectAll().stream().forEach(System.out::println);
//
//            studentsDao.delete(students);
//            //studentsDao.selectAll().stream().forEach(System.out::println);
//        });
////    tm.required(()->{
////        StudentsDao studentsDao = new StudentsDaoImpl(config);
////        studentsDao
////                .selectAll()
////                .stream()
////                .forEach(System.out::println);
////    });
//
////      tm.required(()->{
////          StudentsDao studentsDao = new StudentsDaoImpl(config);
////          Students s = studentsDao.selectByID(6L);
////          System.out.println(s);
////      });
//
//      tm.required(()->{
//          StudentsDao studentsDao = new StudentsDaoImpl(config);
//          List<Students> datas = studentsDao.selectByName("yamasaki");
//          System.out.println(datas);
//      });
////
////      tm.required(()->{
////        StudentsDao studentsDao = new StudentsDaoImpl(config);
////        List<Students> datas = studentsDao.selectByName(null);
////        System.out.println(datas);
//      });
  }

  private static Config createConfig() {
    Dialect dialect = new MysqlDialect();
    LocalTransactionDataSource dataSource =
            new LocalTransactionDataSource(
                    "jdbc:mysql://localhost:3306/lesson_doma?characterEncoding=UTF-8"
                      , "root"
                      , "mysqladm");
    JdbcLogger jdbcLogger = new Slf4jJdbcLogger();
    TransactionManager transactionManager = new LocalTransactionManager(dataSource, jdbcLogger);
    return new DbConfig(dialect, dataSource, jdbcLogger, transactionManager);
  }
}
