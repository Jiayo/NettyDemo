namespace java thrift.generated // 包名


typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

struct Group {
      1: optional String userName,
      2: optional long goupId;
}

service GroupService {
        long insertGroup(1 : required Group bean);
        long deleteGroup(1 : required  String userName,2 : required long groupId);
       list<Group> lloadById(1: required long id);
        list<Group> listByUserName(1 : required String userName);

}