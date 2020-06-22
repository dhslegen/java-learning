package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.MedicineAlias;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface MedicineAliasMapper extends BaseMapper<MedicineAlias> {

    /**
     * get
     *
     * @param medicineCommonNamePkNo medicineCommonNamePkNo
     * @param medicineAliasName      medicineAliasName
     * @return return
     */
    List<MedicineAlias> getByCommonNamePkNoAndMedicineAliasName(@Param("medicineCommonNamePkNo") Integer medicineCommonNamePkNo, @Param("medicineAliasName") String medicineAliasName);

    /**
     * add
     *
     * @param medicineAlias medicineAlias
     */
    void add(MedicineAlias medicineAlias);
}
