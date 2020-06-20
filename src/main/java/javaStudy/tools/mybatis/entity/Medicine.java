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
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "pk_no", type = IdType.AUTO)
    private Integer pkNo;

    /**
     * 编号
     */
    private String medicineCode;

    /**
     * 药品通用名称表物理主键
     */
    private Integer commonNamePkNo;

    /**
     * 药品通用名称
     */
    private String medicineName;

    /**
     * 药品剂型
     */
    private String medicineForm;

    /**
     * 是否医保用药（Y-是；N-否）
     */
    private String isHealthCare;

    /**
     * 数据类别参数编码
     */
    private String fieldTypeParamCode;

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
