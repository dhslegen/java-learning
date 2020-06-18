package javaStudy.tools.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IncludedMedicine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    private Integer directoryPkNo;

    /**
     * 药品类型
     */
    private String directoryType;

    /**
     * 医保目录药品编号
     */
    private String directoryMedicineCode;

    /**
     * 药品名称
     */
    private String directoryMedicineName;

    /**
     * 剂型（参考医保药品剂型表数据）
     */
    private String directoryForm;

    private Integer mapDirectoryPkNo;

    private Integer mapMedicinePkNo;

    /**
     * 物理主键
     */
    private Integer medicinePkNo;

    /**
     * 药品通用名称
     */
    private String medicineName;

    /**
     * 药品剂型
     */
    private String medicineForm;


}
