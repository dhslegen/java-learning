package javaStudy.tools.mybatis.mapper;

import javaStudy.tools.mybatis.entity.HealthCareMedicineDirectoryOfficial;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-08
 */
public interface HealthCareMedicineDirectoryOfficialMapper {

    /**
     * 保存
     *
     * @param healthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial
     * @return HealthCareMedicineDirectoryOfficial
     */
    void save(@Param("healthCareMedicineDirectoryOfficial") HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial);

}
