import exception.TaskException;
import exception.TestException;

/**
 * Created by sloanzhang on 2019/4/18.
 */
public class TaskBiz {


    private TaskDao dao;

    public int createTask()  {
        int result = 0;
        insertDb();

        TestFun1();
        TestFun2();
        return result;

    }



    private  void test(){
        int result=0;
        try{
            result = dao.startTask();
        } catch (TestException e) {
            e.printStackTrace();
        }


    }

    private int TestFun2() {
        int result;
        try {
            result = dao.startTask();
            result = dao.createTask();
        } catch (TaskException e) {
            int code=e.getCode();
            if(code==1){

            }else {

            }
        } catch (TestException e) {

        }
        return -1;
    }


    private int insertDb() {
        return 0;

    }

    private int rollbackDb() {
        return 0;

    }

    private int TestFun1() {
        int result;
        try {
            result = dao.createTask();
        } catch (TaskException taskExceptioin) {
            taskExceptioin.printStackTrace();
            rollbackDb();
        }
        return -1;
    }
}
