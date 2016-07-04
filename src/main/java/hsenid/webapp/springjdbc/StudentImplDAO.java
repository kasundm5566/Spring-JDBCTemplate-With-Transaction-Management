package hsenid.webapp.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import javax.sql.DataSource;

/**
 * Created by hsenid on 5/25/16.
 */
public class StudentImplDAO implements StudentDAO {

    private DataSource dataSource;
    private PlatformTransactionManager transactionManager;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void queryStudent(){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            String query1 = "INSERT INTO student_data (name,age) VALUES ('ABC',28);";
            jdbcTemplate.update(query1);
            System.out.println("Query 1 executed successfully...");
            String query2 = "INSERT INTO student_data (name,age) VALUES ('xyz',28);";
            jdbcTemplate.update(query2);
            System.out.println("Query 2 executed successfully...");
            transactionManager.commit(status);
        }catch (Exception e){
            System.out.println("Error executing queries...");
            transactionManager.rollback(status);
        }
    }
}
