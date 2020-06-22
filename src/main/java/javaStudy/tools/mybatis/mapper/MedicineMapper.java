package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.Medicine;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface MedicineMapper extends BaseMapper<Medicine> {

    /**
     * get
     *
     * @param medicineCommonNamePkNo medicineCommonNamePkNo
     * @param medicineName           medicineName
     * @return return
     */
    Medicine getByCommonNamePkNoAndMedicineName(@Param("medicineCommonNamePkNo") Integer medicineCommonNamePkNo, @Param("medicineName") String medicineName);

    /**
     * insert
     *
     * @param medicine medicine
     */
    void insertAndSetPkNo(Medicine medicine);
}
