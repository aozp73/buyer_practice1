package shop.mtcoding.buyer3.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    public int insert(@Param("username") String username, @Param("password") int password, @Param("email") int email);

    public List<User> findALl();

    public User findById(int id);

    public int update(@Param("password") int password, @Param("id") String id);

    public int deleteById(int id);
}
