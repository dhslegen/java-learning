package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.IncludedMedicine;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-12
 */
public interface IncludedMedicineMapper extends BaseMapper<IncludedMedicine> {

    /**
     * list
     *
     * @return list
     */
    List<IncludedMedicine> list();
}
