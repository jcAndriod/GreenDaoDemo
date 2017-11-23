package com.example.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.greendaodemo.bean.User;
import com.example.greendaodemo.dao.MyUserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyUserDao dao = new MyUserDao(this);

//        User u = new User();
//        u.setAge(10);
//        u.setName("22");
//        u.setId("001");
//        dao.insertUser(this,);

        for (int i = 20; i < 25; i++) {
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setAge(i * 3);
            user.setName("第" + i + "人");
            dao.insertUser(user);
        }
        List<User> userList = dao.queryUserList();
        for (User user : userList) {
            Log.e("TAG", "queryUserList--before-->" + user.getId() + "--" + user.getName() +"--"+user.getAge());
            if (user.getId() == 10) {
                dao.deleteUser(user);
            }
            if (user.getId() == 13) {
                user.setAge(25);
                dao.updateUser(user);
            }
        }
        userList = dao.queryUserList();
        for (User user : userList) {
            Log.e("TAG", "queryUserList--after--->" + user.getId() + "---" + user.getName()+"--"+user.getAge());
        }
    }
}
