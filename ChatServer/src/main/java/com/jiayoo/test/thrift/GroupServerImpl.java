package com.jiayoo.test.thrift;

import com.jiayoo.Dao.GroupDao;
import com.jiayoo.impl.GroupDapImpl;
import com.jiayoo.thrift.generated.Group;
import com.jiayoo.thrift.generated.GroupService;
import org.apache.thrift.TException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupServerImpl  implements GroupService.Iface {
    @Override
    public long insertGroup(Group bean)  {
        try {
            GroupDao groupDao = new GroupDapImpl();
            com.jiayoo.bean.Group group = new com.jiayoo.bean.Group();

            group.setUserName(bean.getUserName());
            group.setGroupId(bean.getGoupId());
            groupDao.insert(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public long deleteGroup(String userName, long groupId)  {
        try {
            GroupDao groupDao = new GroupDapImpl();
            groupDao.delete(userName, groupId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Group> lloadById(long id) throws TException {

        List<Group> groupList = new ArrayList<>();

        try {


            GroupDao groupDao = new GroupDapImpl();

            List<com.jiayoo.bean.Group> groups = groupDao.loadById(id);
            // 查询失败先做判断, 对于thrift来说返回null是错误的
            groups.forEach(ch->{

                Group bean = new Group();
                bean.setUserName(ch.getUserName());
                bean.setGoupId(ch.getGroupId());
                groupList.add(bean);

            });


        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }



    @Override
    public List<Group> listByUserName(String userName)  {
        List<Group> groups = new ArrayList<>();

        try {
            GroupDao groupDao = new GroupDapImpl();
            List<com.jiayoo.bean.Group> list = groupDao.listByUserName(userName);
            list.forEach(eh->{
                Group group = new Group();
                group.setUserName(eh.getUserName());
                group.setGoupId(eh.getGroupId());
                groups.add(group);
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        return groups;
    }
}
