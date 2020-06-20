package javaStudy.tools.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javaStudy.tools.mybatis.entity.IncludedPayment;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-18
 */
public interface IncludedPaymentMapper extends BaseMapper<IncludedPayment> {

    /**
     * list
     *
     * @return list
     */
    List<IncludedPayment> list();
}
