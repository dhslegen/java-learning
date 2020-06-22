package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.HealthCareMedicineDirectory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-12
 */
public interface HealthCareMedicineDirectoryMapper extends BaseMapper<HealthCareMedicineDirectory> {

    /**
     * list
     *
     * @param directoryMedicineCode directoryMedicineCode
     * @param directoryPkNo         directoryPkNo
     * @param directoryType         directoryType
     * @return list
     */
    List<HealthCareMedicineDirectory> getByMedicineCode(@Param("directoryMedicineCode") String directoryMedicineCode, @Param("directoryPkNo") Integer directoryPkNo, @Param("directoryType") String directoryType);

    /**
     * list
     *
     * @param directoryMedicineCode directoryMedicineCode
     * @param directoryPkNo         directoryPkNo
     * @param directoryForm         directoryForm
     * @return list
     */
    List<HealthCareMedicineDirectory> getByMedicineCodeAndForm(@Param("directoryMedicineCode") String directoryMedicineCode, @Param("directoryType") String directoryType, @Param("directoryForm") String directoryForm);

    /**
     * list
     *
     * @param medicineName medicineName
     * @param form         form
     * @return list
     */
    HealthCareMedicineDirectory getByMedicineNameAndForm(@Param("medicineName") String medicineName, @Param("form") String form);

    /**
     * void
     *
     * @param healthCareMedicineDirectory healthCareMedicineDirectory
     */
    void insertAndSetPkNo(HealthCareMedicineDirectory healthCareMedicineDirectory);

    /**
     * get
     *
     * @param medicineName medicineName
     * @return return
     */
    HealthCareMedicineDirectory getByMedicineName(@Param("medicineName") String medicineName);

    /**
     * get
     *
     * @param prefix prefix
     * @return return
     */
    String getMaxMedicineCode(@Param("prefix") String prefix);
}
