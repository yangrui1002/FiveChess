package User;

/**
 * Created by YR on 2018/12/23.
 */
import java.awt.*;

public class UserListPad extends Panel{
    public List userList=new List(10);

    public UserListPad(){
        setLayout(new BorderLayout());
        for(int i=0;i<10;i++){
            userList.add(i+"."+"无用户");
        }
        add(userList,BorderLayout.CENTER);
    }
}

