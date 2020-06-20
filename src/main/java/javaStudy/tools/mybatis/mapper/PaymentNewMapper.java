package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.PaymentNew;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-18
 */
public interface PaymentNewMapper extends BaseMapper<PaymentNew> {

    /**
     * add
     *
     * @param paymentNew paymentNew
     */
    void add(PaymentNew paymentNew);
}
