namespace java thrift.generated


typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

struct User {
    1: optional String userName,
    2: optional long id;
    3: optional String userPass;
}



service UserService {

    long insert(1: required User bean);
    User loadByName(1: required String name);
    long update(1: required User bean);


}

