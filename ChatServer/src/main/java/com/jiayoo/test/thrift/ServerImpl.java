package com.jiayoo.test.thrift;

import com.jiayoo.Dao.FriendDao;
import com.jiayoo.Dao.UserDao;
import com.jiayoo.impl.FriendDaoImpl;
import com.jiayoo.impl.UserDaoImpl;
import com.jiayoo.thrift.generated.Friend;
import com.jiayoo.thrift.generated.FriendService;
import com.jiayoo.thrift.generated.User;
import com.jiayoo.thrift.generated.UserService;
import org.apache.thrift.TException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements FriendService.Iface, UserService.Iface {
    @Override
    public long insertFriend(Friend bean) {
        try {
            FriendDao friendDao = new FriendDaoImpl();
            com.jiayoo.bean.Friend friend = new com.jiayoo.bean.Friend();
            friend.setI_count(bean.getI_count());
            friend.setY_count(bean.getY_count());
            friendDao.insert(friend);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long deleteFriend(String userName, String friendName)  {
        try {
            FriendDao friendDao = new FriendDaoImpl();
            friendDao.delete(userName, friendName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Friend> friendlist(String userName)  {
        List<Friend> friends = new ArrayList<>();

        try {
            FriendDao friendDao = new FriendDaoImpl();
            List<com.jiayoo.bean.Friend> list = friendDao.list(userName);
            list.forEach(eh->{
                Friend friend = new Friend();
                friend.setI_count(eh.getI_count());
                friend.setY_count(eh.getY_count());
                friends.add(friend);
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        return friends;
    }

    @Override
    public long insert(User bean)  {
        com.jiayoo.bean.User user = new com.jiayoo.bean.User();

        user.setUserName(bean.getUserName());
        user.setUserPass(bean.getUserPass());

        try {
            UserDao userDao = new UserDaoImpl();
            userDao.insert(user);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public User loadByName(String name) {
        User bean = new User();

        try {
            UserDao userDao = new UserDaoImpl();
            com.jiayoo.bean.User user = userDao.loadByName(name);
            // 查询失败先做判断, 对于thrift来说返回null是错误的
            if (user == null){
                bean.setUserName("ex000");
                bean.setUserPass("ex000");
                return bean;
            }

            bean.setUserName(user.getUserName());
            bean.setUserPass(user.getUserPass());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public long update(User bean) throws TException {
        com.jiayoo.bean.User user = new com.jiayoo.bean.User();

        try {
            UserDao userDao = new UserDaoImpl();
            user.setUserName(bean.getUserName());
            user.setUserPass(bean.getUserPass());
            userDao.update(user);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
