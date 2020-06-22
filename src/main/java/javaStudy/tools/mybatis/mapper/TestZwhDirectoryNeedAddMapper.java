package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.TestZwhDirectoryNeedAdd;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface TestZwhDirectoryNeedAddMapper extends BaseMapper<TestZwhDirectoryNeedAdd> {

    /**
     * list
     *
     * @return list
     */
    List<TestZwhDirectoryNeedAdd> list();
}
