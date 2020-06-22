package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.HealthCareMedicinePaymentStandard;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
public interface HealthCareMedicinePaymentStandardMapper extends BaseMapper<HealthCareMedicinePaymentStandard> {

    /**
     * get
     *
     * @param healthCareMedicineDirectoryPkNo healthCareMedicineDirectoryPkNo
     * @param paymentAreaCode                 paymentAreaCode
     * @return return
     */
    HealthCareMedicinePaymentStandard getByMedicineDirectoryPkNoAndPaymentAreaCode(@Param("healthCareMedicineDirectoryPkNo") Integer healthCareMedicineDirectoryPkNo, @Param("paymentAreaCode") String paymentAreaCode);

    /**
     * void
     *
     * @param healthCareMedicinePaymentStandard healthCareMedicinePaymentStandard
     */
    void updateByPkNo(HealthCareMedicinePaymentStandard healthCareMedicinePaymentStandard);

    /**
     * add
     * @param healthCareMedicinePaymentStandard healthCareMedicinePaymentStandard
     */
    void add(HealthCareMedicinePaymentStandard healthCareMedicinePaymentStandard);
}
