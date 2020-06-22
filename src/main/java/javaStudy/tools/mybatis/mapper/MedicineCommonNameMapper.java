package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.MedicineCommonName;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface MedicineCommonNameMapper extends BaseMapper<MedicineCommonName> {

    /**
     * get
     *
     * @param medicineName medicineName
     * @return return
     */
    MedicineCommonName getByMedicineName(@Param("medicineName") String medicineName);

    /**
     * void
     *
     * @param medicineCommonName medicineCommonName
     */
    void insertAndSetPkNo(MedicineCommonName medicineCommonName);
}
