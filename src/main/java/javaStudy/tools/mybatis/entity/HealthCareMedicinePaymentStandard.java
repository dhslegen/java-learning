package javaStudy.tools.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCareMedicinePaymentStandard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * pk_no
     */
    @TableId(value = "pk_no", type = IdType.AUTO)
    private Integer pkNo;

    /**
     * 医保药品目录表物理主键
     */
    private Integer medicineDirectoryPkNo;

    /**
     * 医保支付地区编码
     */
    private String paymentAreaCode;

    /**
     * 支付比例
     */
    private Float paymentProportion;

    /**
     * 医保类别（01-甲类；02-乙类）
     */
    private String healthCareCategory;

    /**
     * 是否有效（Y-有效；N-无效）
     */
    private String isValid;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 修改人
     */
    private String updatedUser;

    /**
     * 创建日期
     */
    private LocalDateTime createdDate;

    /**
     * 更新日期
     */
    private LocalDateTime updatedDate;


}
