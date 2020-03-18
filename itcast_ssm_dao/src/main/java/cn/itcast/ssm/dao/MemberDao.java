package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * data layer
 * memberDao
 */
public interface MemberDao {
    /**
     * search member by id
     * @param memberId
     * @return
     */
    @Select("select * from member where id=#{memberId}")
    Member findById(int memberId) throws Exception;
}
