package com.jiayoo.test.thrift;


import com.jiayoo.bean.Friend;
import com.jiayoo.bean.Group;
import com.jiayoo.generated.FriendService;
import com.jiayoo.generated.GroupService;
import com.jiayoo.generated.User;
import com.jiayoo.generated.UserService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.ArrayList;
import java.util.List;

public class ThriftClient {



    public void insertUser(String userName, String userPass){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8890), 600);
        TProtocol protocol = new TCompactProtocol(transport);

        UserService.Client client = new UserService.Client(protocol);

        try {
            transport.open();
            User user = new User();
            user.setUserName(userName);
            user.setUserPass(userPass);
            client.insert(user);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
    }

    public com.jiayoo.bean.User loadUserByName(String userName){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8890), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        com.jiayoo.bean.User user = null;
        try {
            transport.open();
            User bean = client.loadByName(userName);
/*            System.out.println(user.getUserName());
            System.out.println(user.userPass);

            System.out.println("-------");*/
            // 查询失败的话
            if (bean.getUserName().equals("ex000")){
                return null;
            }else {
                user = new com.jiayoo.bean.User(bean.getUserName(),bean.getUserPass());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
        return user;
    }

    public void updateUser(String userName, String newUserPass){
        User user = new User();
        user.setUserName(userName);
        user.setUserPass(newUserPass);
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8890), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        try {
            transport.open();
            client.update(user);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
    }











    private com.jiayoo.generated.Friend toserverFriend(Friend friend){
        com.jiayoo.generated.Friend bean = new com.jiayoo.generated.Friend();
        bean.setI_count(friend.getI_count());
        bean.setY_count(friend.getY_count());
        return bean;
    }




    public  Long insertFriend(Friend friend){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8801), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        FriendService.Client client = new FriendService.Client(protocol);
        try {
            transport.open();
            client.insertFriend(toserverFriend(friend));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
        return 0L;
    }

    public Long deleteFriend(String userName, String friendName){

        TTransport transport = new TFramedTransport(new TSocket("localhost", 8801), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        FriendService.Client client = new FriendService.Client(protocol);
        try {
            transport.open();
            client.deleteFriend(userName, friendName);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }


        return 0L;
    }

    public List<Friend> friendList(String userName){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8801), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        FriendService.Client client = new FriendService.Client(protocol);
        List<Friend> friendList = new ArrayList<>();
        try {
            transport.open();
            List<com.jiayoo.generated.Friend> friends = client.friendlist(userName);
            friends.forEach(eh -> {
                Friend friend = new Friend();
                friend.setI_count(eh.getI_count());
                friend.setY_count(eh.getY_count());
                friendList.add(friend);
            });
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
        return friendList;
    }











    // 以下是对Group的操作





    public static void main(String[] args) {

        // 下面的代码是测试FriendServer提供功能部分的。

//        new ThriftClient().insertFriend(new Friend("11", "11"));

/*        List<Friend> friendList = new ThriftClient().friendList("123");
        friendList.forEach(eh->{
            System.out.println(eh);
        });*/

//        Long result = new ThriftClient().deleteFriend("123", "zjy");

        // 下面是测试Group
//        new ThriftClient().insertGroup(new Group("123", 12L));

//        new ThriftClient().deleteGroup("123", 12L);

/*        List<Group> groupList = new ThriftClient().groupListByUserName("zjy");
        groupList.forEach(ec->{
            System.out.println(ec);
        });*/
        List<Group> groupList = new ThriftClient().loadById(1L);

        groupList.forEach(ec->{
            System.out.println(ec);
        });


    }






    private com.jiayoo.generated.Group toServerGroup(Group bean){
        com.jiayoo.generated.Group group = new com.jiayoo.generated.Group();
        group.setUserName(bean.getUserName());
        group.setGoupId(bean.getGroupId());

        return group;
    }

   public long insertGroup(Group group){

       TTransport transport = new TFramedTransport(new TSocket("localhost", 8802), 600);
       TProtocol protocol = new TCompactProtocol(transport);
       GroupService.Client client = new GroupService.Client(protocol);

       try {
           transport.open();
           client.insertGroup(toServerGroup(group));
       } catch (Exception ex) {
           throw new RuntimeException(ex.getMessage(), ex);
       } finally {
           transport.close();
       }
       return 0L;

   }



    public long deleteGroup(String userName, long groupId){

        TTransport transport = new TFramedTransport(new TSocket("localhost", 8802), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        GroupService.Client client = new GroupService.Client(protocol);

        try {
            transport.open();
            client.deleteGroup(userName, groupId);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }



        return 0L;


    }




  public List<Group> groupListByUserName(String userName){

    List<Group> groupList = new ArrayList<>();
      TTransport transport = new TFramedTransport(new TSocket("localhost", 8802), 600);
      TProtocol protocol = new TCompactProtocol(transport);
      GroupService.Client client = new GroupService.Client(protocol);

      try {
          transport.open();

          List<com.jiayoo.generated.Group> groups = client.listByUserName(userName);

          groups.forEach(ec ->{
              Group group = new Group();
              group.setUserName(ec.getUserName());
              group.setGroupId(ec.getGoupId());
              groupList.add(group);
          });


      } catch (Exception ex) {
          throw new RuntimeException(ex.getMessage(), ex);
      } finally {
          transport.close();
      }
     return groupList;

  }
    public List<Group> loadById(Long id){

        List<Group> groupList = new ArrayList<>();
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8802), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        GroupService.Client client = new GroupService.Client(protocol);

        try {
            transport.open();

            List<com.jiayoo.generated.Group> groups = client.lloadById(id);

            groups.forEach(ec ->{
                Group group = new Group();
                group.setUserName(ec.getUserName());
                group.setGroupId(ec.getGoupId());
                groupList.add(group);
            });


        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
        return groupList;

    }


}
