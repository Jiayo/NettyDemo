namespace java thrift.generated // 包名


typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String



struct Friend {
    1: optional String i_count,
    2: optional String y_count;
}



service FriendService {
    long insertFriend(1: required Friend bean);
    long deleteFriend(1:required String userName , 2: required String friendName);
    list<Friend> friendlist (1 : required string userName );

}