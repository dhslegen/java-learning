package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.HealthCareMedicineMap;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface HealthCareMedicineMapMapper extends BaseMapper<HealthCareMedicineMap> {

    /**
     * get
     *
     * @param medicinePkNo medicinePkNo
     * @return return
     */
    HealthCareMedicineMap getByMedicinePkNo(@Param("medicinePkNo") Integer medicinePkNo);

    /**
     * update
     *
     * @param healthCareMedicineMap healthCareMedicineMap
     */
    void updateByMedicinePkNo(HealthCareMedicineMap healthCareMedicineMap);

    /**
     * add
     *
     * @param healthCareMedicineMap healthCareMedicineMap
     */
    void add(HealthCareMedicineMap healthCareMedicineMap);
}
