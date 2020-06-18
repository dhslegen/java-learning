package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.NewMap;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-12
 */
public interface NewMapMapper extends BaseMapper<NewMap> {

    /**
     * newMap
     *
     * @param newMap newMap
     */
    void add(NewMap newMap);
}
