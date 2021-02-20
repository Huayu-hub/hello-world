package Zction;

import com.alice.Userc;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    public Userc getUser(int id);

    public void addUser(int id , String name ) ;

}
